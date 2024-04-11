package find.newmusic.client;

import java.util.ArrayList;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.newmusic.web.data.Artist;
import com.newmusic.web.data.MusicEvent;

public class MusicRequestClient {
	private static final String webServiceUrl = "http://localhost:8080/com.newmusic.web/api/music";

	public static void main(String[] args) {
		//deleteArtist(1);
		
		Artist billie = new Artist("Billie", "Eilish");
		int idArtist = addArtist(billie);
		if(idArtist < 0) {
			System.out.println("Artist already exists!");
			return;
		}
		System.out.println("Added artist at: " + idArtist);
		Artist a = getArtist(idArtist);
		System.out.println("Artist: ");
		System.out.println(a + "\n");

		int eventId = addUpcomingEvent(idArtist, "WHERE DO WE GO? WORLD TOUR: PHILADELPHIA");
		System.out.println("Added event at: " + idArtist + "/" + eventId);
		
		MusicEvent me = getEvent(idArtist, eventId);
		System.out.println(me);
		
		deleteEvent(idArtist, eventId);
		deleteArtist(idArtist);
	}
	
	/**
	 * Read the error code of a response, and show an appropriate message if necessary.
	 * @param r The response instance
	 * @return
	 */
	private static Integer parseErrorCode(Response r) {
		if (r.getStatus() == 400) {
			System.out.println("Oops!");
			return -400;
		}
		if(r.getStatus() == 404) {
			System.out.println("Url not found!");
			return -404;
		}
		
		if(r.getStatus() >= 400 && r.getStatus() < 500) {
			System.out.println("Client-side error.");
			return -r.getStatus();
		}
		if(r.getStatus() >= 500) {
			System.out.println("Server-side error.");
			return -r.getStatus();
		}
		return 0;
	}
	
	/**
	 * Adds an artist which does not exist yet.
	 * 
	 * @param artist The artist to add
	 * @return On success, the id of the event. On failure, the negative response code
	 */
	private static Integer addArtist(Artist artist) {
		System.out.println("Adding " + artist.getFirstName() + " " + artist.getLastName() + "...");
		WebClient c = WebClient.create(webServiceUrl);
		Response r = c.type(MediaType.APPLICATION_XML).post(artist);
		int response = 0;
		if((response = parseErrorCode(r)) != 0) {
			return response;
		}
		
		String uri = r.getHeaderString("Content-Location");
		System.out.println("Ok.");

		c.close();

		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}

	/**
	 * Retrieve an artist given its id.
	 * @param id The artist's id
	 * @return The artist in question
	 */
	private static Artist getArtist(Integer id) {
		System.out.println("Getting " + id + "... ");
		WebClient c = WebClient.create(webServiceUrl).path("artist").path(id);
		Artist s = null;
		try {
			s = c.get(Artist.class);
		} catch (NotFoundException e) {
			System.out.println("Oops! Artist not found.");
		}
		c.close();
		return s;
	}

	/**
	 * Delete an artist.
	 * @param id The id of the artist
	 * @return Whether or not we were able to succesfully delete the artist
	 */
	private static Boolean deleteArtist(Integer id) {
		System.out.println("Deleting " + id + "... ");
		WebClient c = WebClient.create(webServiceUrl).path("artist").path(id);
		int status = c.delete().getStatus();

		if (status == 200) {
			System.out.println("OK.");
			return true;
		}
		System.out.println("Oops!");
		return false;
	}

	/**
	 * Adds an upcoming event to the list. If the artist is not in the list, they
	 * will be added, along with the event. Otherwise, the event will be added to
	 * the pre-existing list and sorted according to its start date.
	 * 
	 * @param idArtist The id of the artist headlining the event
	 * @param eventName  The name of the event to be added
	 * @return On success, the id of the event. On failure, the negative response code
	 */
	private static Integer addUpcomingEvent(int idArtist, String eventName) {
		System.out.println("Adding event: " + eventName);
		WebClient c = WebClient.create(webServiceUrl).path("artist").path(idArtist);
		
		Artist a = getArtist(idArtist);
		if(a == null) {
			return -1;
		}

		//System.out.println(a);
		
		MusicEvent bme = new MusicEvent(eventName, a);
		
		Response r = c.type(MediaType.APPLICATION_XML).post(bme);

		int response = 0;
		if((response = parseErrorCode(r)) != 0) {
			return response;
		}
		
		String uri = r.getHeaderString("Content-Location");
		System.out.println("OK.");

		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}

	/**
	 * Get an event, given its artist and event id.
	 * 
	 * @param artistId The artist's id
	 * @param eventId The event's id
	 * @return The event, if it exists, null otherwise
	 */
	private static MusicEvent getEvent(Integer artistId, Integer eventId) {
		System.out.println("Getting event " + eventId + "... ");
		WebClient c = WebClient.create(webServiceUrl).path("artist").path(artistId).path("event").path(eventId);
		MusicEvent s = null;
		try {
			s = c.get(MusicEvent.class);
		} catch (NotFoundException e) {
			System.out.println("Oops! Event not found!");
		}
		c.close();
		return s;
	}

	/**
	 * Delete an artist.
	 * @param id The id of the artist
	 * @return Whether or not we were able to succesfully delete the artist
	 */
	private static Boolean deleteEvent(Integer artistId, Integer eventId) {
		System.out.println("Deleting " + eventId + "... ");
		WebClient c = WebClient.create(webServiceUrl).path("artist").path(artistId).path("event").path(eventId);
		int status = c.delete().getStatus();

		if (status == 200) {
			System.out.println("OK.");
			return true;
		}
		System.out.println("Oops! " + status);
		return false;
	}
}
