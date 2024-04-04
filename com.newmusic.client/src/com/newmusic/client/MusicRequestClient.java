package com.newmusic.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.newmusic.web.data.Artist;
import com.newmusic.web.data.MusicEvent;

public class MusicRequestClient {
	private static final String webServiceUrl = "https://localhost:8080/web.newmusic.com/api/music";

	public static void main(String[] args) {
		Artist billie = new Artist("Billie", "Eilish");
		addUpcomingEvent(billie, "WHERE DO WE GO? WORLD TOUR: PHILADELPHIA");
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
		
		if(r.getStatus() == 400) {
			System.out.println("Oops! Bad request.");
			return null;
		}
		
		String uri = r.getHeaderString("Content-Location");
		System.out.println("OK.");
		
		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}
}
