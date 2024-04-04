package com.newmusic.web.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.newmusic.web.data.Artist;
import com.newmusic.web.data.MusicEvent;
import com.newmusic.web.service.MusicService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Path("/music")
public class MusicResource {
	MusicService service = new MusicService();

	@Context
	UriInfo uriInfo;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addUpcomingEvent(Artist artist, MusicEvent event) {
		service.addUpcomingEvent(artist, event);
		URI uri = uriInfo.getRequestUri();

		String newUri = uri.getPath() + "/" + artist.getAlias();
		if (!artist.getDisamiguation().isEmpty()) {
			newUri += "_" + artist.getDisamiguation();
		}
		return Response.status(Response.Status.CREATED)
					   .entity(artist)
					   .contentLocation(uri.resolve(newUri))
					   .build();
	}

	@DELETE
	//@Path(/*What do I put here*/)
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteArtist(Artist artist) {
		if(service.deleteArtist(artist)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEvent(Artist artist, MusicEvent me) {
		if (service.deleteEvent(artist, me)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUpcomingEventsArtist() {
		HashMap<Artist, ArrayList<MusicEvent>> hmaalme = service.getUpcomingEventsArtist();
		if (hmaalme == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		return Response.status(Response.Status.OK)
				.entity(hmaalme)
				.links(link)
				.build();
	}
}
