package com.newmusic.webservice.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.newmusic.webservice.data.Artist;
import com.newmusic.webservice.data.MusicEvent;

/**
 * Music service that implements the different request methods.
 * 
 * @author mattewyang1325@gmail.com
 *
 */
public class MusicService {

	// private static HashMap<Area, MusicEvent> upcomingEventsArea = new
	// HashMap<Area, MusicEvent>();

	private static HashMap<Artist, ArrayList<MusicEvent>> upcomingEventsArtist = new HashMap<Artist, ArrayList<MusicEvent>>();

	private static HashMap<Artist, ArrayList<Integer>> eventIdsByArtist = new HashMap<Artist, ArrayList<Integer>>();
	private static HashMap<Integer, Artist> artistById = new HashMap<Integer, Artist>();
	private static HashMap<Integer, HashMap<Integer, MusicEvent>> eventByIdByArtistId = new HashMap<Integer, HashMap<Integer, MusicEvent>>();

	/**
	 * Generates a new event id that has not already been used yet
	 * 
	 * @return An unused id
	 */
	private int getNewEventId(Artist a) {
		ArrayList<Integer> eventIds = eventIdsByArtist.get(a);

		// Since the event ids are stored in an arraylist, and this list is sorted
		// smallest to biggest, we just need to know the last number added
		if(eventIds.size() == 0) return 1;
		int newId = eventIds.get(eventIds.size() - 1) + 1;
		return newId;
	}

	/**
	 * Generates a new artist id that has not already been used yet
	 * 
	 * @return An unused id
	 */
	private int getNewArtistId() {
		Set<Integer> artistIds = artistById.keySet();
		int newId = 0;
		for (int id : artistIds) {
			if (newId < id) {
				newId = id;
			}
		}
		return ++newId;
	}

	/**
	 * Adds an upcoming event to the list. The event will be added to
	 * the pre-existing list and sorted according to its start date.
	 * 
	 * @param artistId The artist headlining the event
	 * @param event  The event to be added
	 * @return The {@link MusicEvent} added
	 */
	public MusicEvent addUpcomingEvent(int artistId, MusicEvent event) {
		Artist artist = artistById.get(artistId);
		if(eventByIdByArtistId.get(artistId).containsValue(event)) {
			return null;
		}
		
		int id = getNewEventId(artist);
		event.setEventId(id);
		
		upcomingEventsArtist.get(artist).add(event);
		eventIdsByArtist.get(artist).add(event.getEventId());
		eventByIdByArtistId.get(artist.getArtistId()).put(id, event);
		return event;
		// alme.sort(new SortByDate());
	}
	
	/**
	 * Adds an artist which does not exist yet, and sets its id.
	 * 
	 * @param artist The artist to add
	 * @return The Artist added
	 */
	public Artist addArtist(Artist artist) {
		artist = DistantWSAccess.getArtist(artist, !artist.getAlias().equals(""));
		
		if(artistById.containsValue(artist)) {
			return null;
		}
		
		int id = getNewArtistId();
		artist.setArtistId(id);

		upcomingEventsArtist.put(artist, new ArrayList<MusicEvent>());
		eventIdsByArtist.put(artist, new ArrayList<Integer>());
		eventByIdByArtistId.put(id, new HashMap<Integer, MusicEvent>());
		artistById.put(id, artist);
		return artist;
	}

	/**
	 * Deletes the artist from the list of upcoming events
	 * 
	 * @param artistId The id of the artist to delete
	 * @return Whether or not the artist was successfully deleted
	 */
	public boolean deleteArtist(int artistId) {
		Artist artist = artistById.remove(artistId);
		eventByIdByArtistId.remove(artistId);
		eventIdsByArtist.remove(artist);
		boolean wasRemoved = upcomingEventsArtist.remove(artist) != null;
		return wasRemoved;
	}
	
	/**
	 * Deletes a specific event from an artist's upcoming event list
	 * 
	 * @param artistId The id of the artist headlining the event
	 * @param musicId The id of the event to delete
	 *  @return Whether or not the event was sucessfully deleted
	 */
	public boolean deleteEvent(Integer artistId, Integer musicId) {
		if(!artistById.containsKey(artistId)) {
			return false;
		}
		if(!eventByIdByArtistId.get(artistId).containsKey(musicId)) {
			return false;
		}
		Artist eventsArtist = artistById.get(artistId);
		MusicEvent event = eventByIdByArtistId.get(artistId).get(musicId);
		
		boolean allDeleted = true;
		allDeleted = allDeleted && upcomingEventsArtist.get(eventsArtist).remove(event);
		allDeleted = allDeleted && eventIdsByArtist.get(eventsArtist).remove(musicId);
		allDeleted = allDeleted && eventByIdByArtistId.get(artistId).remove(musicId, event);
		
		return allDeleted;
	}

	/**
	 * Find the {@link MusicEvent} based on the artist who headlined it and the
	 * event's unique identifier
	 * 
	 * @param artistId  The id of the artist
	 * @param eventId The music event's identifier
	 * @return The MusicEvent, if it exists, otherwise, null
	 */
	public MusicEvent getEventByArtistAndId(Integer artistId, Integer eventId) {
		//System.out.println(artistId + "; " + eventId);
		//System.out.println(eventByIdByArtistId);
		
		HashMap<Integer, MusicEvent> musicEvents = eventByIdByArtistId.get(artistId);
		
		//System.out.println(musicEvents);
		if(musicEvents == null) return null;
		return musicEvents.get(eventId);
	}
	
	/**
	 * Get all of an artist's events.
	 * @param artistId The id of the artist.
	 * @return All of the artist's events.
	 */
	public Artist getArtistEvents(int artistId){
		Artist a = artistById.get(artistId);
		a.setEvents(new ArrayList<MusicEvent>(eventByIdByArtistId.get(artistId).values()));
		return a;
		
	}

	/**
	 * Get all events across all artists
	 * @return A {@link HashMap} associating an {@link Artist} to their {@link MusicEvent}s.
	 */
	public HashMap<Artist, ArrayList<MusicEvent>> getUpcomingEventsArtist() {
		return upcomingEventsArtist;
	}
	
	/**
	 * Get a specific {@link Artist}
	 * @param id The id of the {@link Artist}
	 * @return The {@link Artist}, or null if it doesn't exist
	 */
	public Artist getArtist(int id) {
		return artistById.get(id);
	}
}
