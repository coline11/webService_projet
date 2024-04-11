package find.newmusic.client;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.newmusic.web.data.Artist;
import com.newmusic.web.data.MusicEvent;

public class MusicRequestClient {
	private static final String webServiceUrl = "http://localhost:8080/com.newmusic.web/api/music";
	private static Integer idArtistMain, idEventMain;
	//private static final Integer[] eventAmountByArtist = {4,3,2,3};

	public static void main(String[] args) {
		
		boolean success = testAddingArtists();
		if (!success) {
			return;
		}

		success = testAddingEvents();
		if (!success) {
			testDeleting();
			return;
		}

		testDeleting();
	}

	/**
	 * Adds an artist to the database, given the artist's first and last name
	 * 
	 * @param fName The artist's first name
	 * @param lName The artist's last name
	 * @return Whether or not the artist was able to be added.
	 */
	public static boolean testAddingArtist(String fName, String lName) {
		Artist a;

		Artist artist = new Artist(fName, lName);
		idArtistMain = addArtist(artist);
		if (idArtistMain < 0) {
			System.out.println("Artist " + fName + " already exists!");
			return false;
		}
		System.out.println("Added artist at: " + idArtistMain);
		a = getArtist(idArtistMain);
		System.out.println("Artist: ");
		System.out.println(a + "\n");
		return true;
	}

	/**
	 * Test adding artists.
	 * 
	 * @return Whether or not all four artists were able to be added.
	 */
	public static boolean testAddingArtists() {
		if (!testAddingArtist("Billie", "Eilish")) {
			return false;
		}
		if (!testAddingArtist("Taylor", "Swift")) {
			return false;
		}
		if (!testAddingArtist("Ed", "Sheeran")) {
			return false;
		}
		if (!testAddingArtist("Lana", "Del Rey")) {
			return false;
		}
		return true;
	}

	public static boolean testAddingEvent(int artistId, String eventName) {
		return testAddingEvent(artistId, eventName, "");
	}
	
	public static boolean testAddingEvent(int artistId, String eventName, String disambig) {
		idEventMain = addUpcomingEvent(artistId, eventName, disambig);
		if(idEventMain < 0) {
			System.out.println("Error adding event.");
			return false;
		}
		
		System.out.println("Added event at: " + artistId + "/" + idEventMain);

		MusicEvent me = getEvent(artistId, idEventMain);
		System.out.println(me);
		return true;
	}

	public static boolean testAddingEvents() {
	    String[][] events = {
	        {"WHERE DO WE GO? WORLD TOUR: PHILADELPHIA",
	        	"New Slang: Billie Eilish",
	        	"An Evening With Billie Eilish",
	        	"I-DAYS Milano 2020: Billie Eilish"
	        },
	        {"Lover Fest East night 1",
	        	"Storytellers: Taylor Swift",
	        	"I Can See You (Taylor’s version) (at GRAMMY Museum)"
	        },
	        {"Ed Sheeran at Círculo de Bellas Artes",
	        	"+–=÷× Tour: Osaka"
	        },
	        {"Paradise Tour: San Francisco",
	        	"Festival de Carcassonne 2014: Lana Del Rey",
	        	"Paradise Tour: Phoenix"
	        }
	    };
	    
	    for (int i = 0; i < events.length; i++) {
	        for (int j = 0; j < events[i].length; j++) {
	            if (!testAddingEvent(i + 1, events[i][j])) return false;
	        }
	    }
	    
	    return true;
	}

	/**
	 * Test the deletetion of all artists.
	 */
	public static void testDeleting() {
		for (int i = 1; i <= 4; i++) {
			deleteArtist(i);
		}
	}

	/**
	 * Read the error code of a response, and show an appropriate message if
	 * necessary.
	 * 
	 * @param r The response instance
	 * @return
	 */
	private static Integer parseErrorCode(Response r) {
		if (r.getStatus() == 400) {
			System.out.println("Oops!");
			return -400;
		}
		if (r.getStatus() == 404) {
			System.out.println("Url not found!");
			return -404;
		}

		if (r.getStatus() >= 400 && r.getStatus() < 500) {
			System.out.println("Client-side error.");
			return -r.getStatus();
		}
		if (r.getStatus() >= 500) {
			System.out.println("Server-side error.");
			return -r.getStatus();
		}
		return 0;
	}

	/**
	 * Adds an artist which does not exist yet.
	 * 
	 * @param artist The artist to add
	 * @return On success, the id of the event. On failure, the negative response
	 *         code
	 */
	private static Integer addArtist(Artist artist) {
		System.out.println("Adding " + artist.getFirstName() + " " + artist.getLastName() + "...");
		WebClient c = WebClient.create(webServiceUrl);
		Response r = c.type(MediaType.APPLICATION_XML).post(artist);
		int response = 0;
		if ((response = parseErrorCode(r)) != 0) {
			return response;
		}

		String uri = r.getHeaderString("Content-Location");
		System.out.println("Ok.");

		c.close();

		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}

	/**
	 * Retrieve an artist given its id.
	 * 
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
	 * 
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
	 * @param idArtist  The id of the artist headlining the event
	 * @param eventName The name of the event to be added
	 * @param disambig A way to disambiguate between two identically named events
	 * @return On success, the id of the event. On failure, the negative response
	 *         code
	 */
	private static Integer addUpcomingEvent(int idArtist, String eventName, String disambig) {
		System.out.println("Adding event: " + eventName);
		WebClient c = WebClient.create(webServiceUrl).path("artist").path(idArtist);

		Artist a = getArtist(idArtist);
		if (a == null) {
			return -1;
		}

		// System.out.println(a);

		MusicEvent bme = new MusicEvent(eventName, disambig, a);

		Response r = c.type(MediaType.APPLICATION_XML).post(bme);

		int response = 0;
		if ((response = parseErrorCode(r)) != 0) {
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
	 * @param eventId  The event's id
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
	 * 
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
