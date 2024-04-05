package find.newmusic.com.resource;

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

import find.newmusic.com.data.Artist;
import find.newmusic.com.service.MusicService;

@Path("/music")
public class MusicResource {
	MusicService service = new MusicService();

	@Context
	UriInfo uriInfo;

	/*
	@POST
	@Path("/{aid}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addUpcomingEvent(@PathParam("aid") int artistId, MusicEvent event) {
		service.addUpcomingEvent(artist, event);
		URI uri = uriInfo.getRequestUri();

		String newUri = uri.getPath() + "/" + artist.getAlias() + "/" + event.getEventId();
		if (!artist.getDisamiguation().isEmpty()) {
			newUri += "_" + artist.getDisamiguation();
		}
		return Response.status(Response.Status.CREATED)
					   .entity(artist)
					   .contentLocation(uri.resolve(newUri))
					   .build();
	}*/

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addArtist(Artist artist) {
		Artist artistAdded = service.addArtist(artist);
		if(artistAdded == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.build();
		}
		
		URI uri = uriInfo.getRequestUri();

		String newUri = uri.getPath() + "/" + artist.getArtistsId();
		/*if (!artist.getDisamiguation().isEmpty()) {
			newUri += "_" + artist.getDisamiguation();
		}*/
		return Response.status(Response.Status.CREATED)
					   .entity(artist)
					   .contentLocation(uri.resolve(newUri))
					   .build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteArtist(@PathParam("id") int id) {
		if(service.deleteArtist(id)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getArtist(@PathParam("id") int id) {
		Artist artist = service.getArtist(id);
		if (artist == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri())
						.rel("self")
						.type("application/xml")
						.build();
		return Response.status(Response.Status.OK)
				.entity(artist)
				.links(link)
				.build();
	}

	/*
	@DELETE
	@Path("/{aid}/{eid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEvent(@PathParam("aid") int artistId, @PathParam("eid") int musicId) {
		if (service.deleteEvent(artistId, musicId)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	*/

	/*@GET
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
	}*/
}