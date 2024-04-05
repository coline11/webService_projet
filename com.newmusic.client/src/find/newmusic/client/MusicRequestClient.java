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
		Artist billie = new Artist("Billie", "Eilish");
		int idArtist = addArtist(billie);
		System.out.println("Added artist at: " + idArtist);

		// addUpcomingEvent(billie, "WHERE DO WE GO? WORLD TOUR: PHILADELPHIA");
	}

	/**
	 * Adds an artist which does not exist yet.
	 * 
	 * @param artist The artist to add
	 */
	private static Integer addArtist(Artist artist) {
		System.out.println("Adding " + artist.getFirstName() + " " + artist.getLastName() + "...");
		WebClient c = WebClient.create(webServiceUrl);
		Response r = c.type(MediaType.APPLICATION_XML).post(artist);
		if (r.getStatus() == 400) {
			System.out.println("Oops!");
			return -1;
		}
		if(r.getStatus() == 404) {
			System.out.println("Url not found!");
			return -1;
		}
		
		System.out.println(r.getStatus());
		
		String uri = r.getHeaderString("Content-Location");
		System.out.println("Ok.");

		c.close();

		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}

	private static Boolean delete(Integer id) {
		System.out.print("Deleting " + id + "... ");
		WebClient c = WebClient.create(webServiceUrl).path(id);
		int status = c.delete().getStatus();
		c.close();

		if (status == 200) {
			System.out.println("OK.");
			return true;
		}
		System.out.println("Oops!");
		return false;
	}

	private static Artist get(Integer id) {
		System.out.print("Getting " + id + "... ");
		WebClient c = WebClient.create(webServiceUrl).path(id);
		Artist s = null;
		try {
			s = c.get(Artist.class);
			System.out.println(s.toString());
		} catch (NotFoundException e) {
			System.out.println("Oops!");
		}
		c.close();
		return s;
	}

	/**
	 * Adds an upcoming event to the list. If the artist is not in the list, they
	 * will be added, along with the event. Otherwise, the event will be added to
	 * the pre-existing list and sorted according to its start date.
	 * 
	 * @param artist The artist headlining the event
	 * @param event  The event to be added
	 */
	private static Integer addUpcomingEvent(Artist artist, String eventName) {
		System.out.println("Adding " + artist + "'s event: " + eventName);
		WebClient c = WebClient.create(webServiceUrl);
		MusicEvent bme = new MusicEvent(eventName, artist);
		Response r = c.type(MediaType.APPLICATION_XML).post(bme);

		if (r.getStatus() == 400) {
			System.out.println("Oops! Bad request.");
			return null;
		}

		String uri = r.getHeaderString("Content-Location");
		System.out.println("OK.");

		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}
}
