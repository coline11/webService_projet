package com.newmusic.web.resource;

import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.newmusic.web.data.Artist;
import com.newmusic.web.data.MusicEvent;
import com.newmusic.web.service.MusicService;

/**
 * Calls {@link MusicService} to interact with the database and send back the requested information, or an error if it can't.
 * @author Yang Mattew
 * @author Wu Jingyi
 *
 */
@Path("/music")
public class MusicResource {
	MusicService service = new MusicService();

	@Context
	UriInfo uriInfo;
	
	/**
	 * Add an event.
	 * 
	 * @param artistId The id of the artist where we'll add the event
	 * @param event The event we're adding
	 * @return A {@link Response} on whether we were able to successfully execute
	 *         the method or not
	 */
	@POST
	@Path("/artist/{aid}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addUpcomingEvent(@PathParam("aid") int artistId, MusicEvent event) {
		// Adding event and retrieving added event
		MusicEvent eventAdded = service.addUpcomingEvent(artistId, event);
		if(eventAdded == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.build();
		}
		
		URI uri = uriInfo.getRequestUri();
		
		// Creating URL to new event
		String newUri = uri.getPath() + "/" + event.getEventId();
		return Response.status(Response.Status.CREATED)
					   .entity(event)
					   .contentLocation(uri.resolve(newUri))
					   .build();
	}

	/**
	 * Add an artist
	 * 
	 * @param artist The artist we're adding
	 * @return A {@link Response} on whether we were able to successfully execute
	 *         the method or not
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addArtist(Artist artist) {
		// Adding artist and retrieving added artist
		Artist artistAdded = service.addArtist(artist);
		if (artistAdded == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.build();
		}
		
		URI uri = uriInfo.getRequestUri();

		// Creating URL to new event
		String newUri = uri.getPath() + "/" + artist.getArtistsId();
		return Response.status(Response.Status.CREATED)
					   .entity(artist)
					   .contentLocation(uri.resolve(newUri))
					   .build();
	}

	/**
	 * Delete an artist
	 * @param id The id of the artist
	 * @return A {@link Response} on whether we were able to successfully delete the Artist or not
	 */
	@DELETE
	@Path("/artist/{aid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteArtist(@PathParam("aid") int id) {
		// True = was able to delete, false = not able to delete
		if(service.deleteArtist(id)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	/**
	 * Get an artist given its id.
	 * @param id The id of the artist
	 * @return A {@link Response} on whether we were able to successfully execute
	 *         the method or not
	 */
	@GET
	@Path("/artist/{aid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getArtist(@PathParam("aid") int id) {
		Artist artist = service.getArtist(id);
		
		// NULL = artist does not exist
		if (artist == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		// Need to find where artist info is stored
		Link link = Link.fromUri(uriInfo.getRequestUri())
						.rel("self")
						.type("application/xml")
						.build();
		return Response.status(Response.Status.OK)
				.entity(artist)
				.links(link)
				.build();
	}

	/**
	 * Get all of the events of a specific artist
	 * @param artistId The id of the artist
	 * @return A {@link Response} on whether we were able to successfully execute
	 *         the method or not
	 */
	@GET
	@Path("/artist/{aid}/event")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEvents(@PathParam("aid") int artistId) {
		Artist artist = service.getArtistEvents(artistId);
		
		// NULL = artist does not exist
		if (artist == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		// Need to find where info on events is stored
		Link link = Link.fromUri(uriInfo.getRequestUri())
						.rel("self")
						.type("application/xml")
						.build();
		return Response.status(Response.Status.OK)
				.entity(artist)
				.links(link)
				.build();
	}

	/**
	 * Get an event given the id of the artist who headlined it and its event id.
	 * @param artistId The id of the artist
	 * @param eventId The id of the event
	 * @return A {@link Response} on whether we were able to successfully execute
	 *         the method or not
	 */
	@GET
	@Path("/artist/{aid}/event/{eid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEvent(@PathParam("aid") int artistId, @PathParam("eid") int eventId) {
		MusicEvent event = service.getEventByArtistAndId(artistId, eventId);
		
		// Null = event OR artist does not exist
		if (event == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		// Need to find where event info is stored
		Link link = Link.fromUri(uriInfo.getRequestUri())
						.rel("self")
						.type("application/xml")
						.build();
		return Response.status(Response.Status.OK)
				.entity(event)
				.links(link)
				.build();
	}

	/**
	 * Delete an event.
	 * @param artistId The id of the artist that headlined the event
	 * @param musicId The id of the event that we want to delete
	 * @return A {@link Response} on whether we were able to successfully execute
	 *         the method or not
	 */
	@DELETE
	@Path("/artist/{aid}/event/{eid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEvent(@PathParam("aid") int artistId, @PathParam("eid") int musicId) {
		// True = was able to delete, false = not able to delete
		if (service.deleteEvent(artistId, musicId)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
