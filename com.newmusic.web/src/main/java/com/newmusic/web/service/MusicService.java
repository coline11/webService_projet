package com.newmusic.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

import com.newmusic.web.data.Artist;
import com.newmusic.web.data.MusicEvent;

/**
 * Music service that implements the different request methods
 * 
 * @author mattewyang1325@gmail.com
 *
 */
public class MusicService {

	// private static HashMap<Area, MusicEvent> upcomingEventsArea = new
	// HashMap<Area, MusicEvent>();

	// TODO: Make sure that the two arraylists are same order
	private static HashMap<Artist, ArrayList<MusicEvent>> upcomingEventsArtist = new HashMap<Artist, ArrayList<MusicEvent>>();

	private static HashMap<Artist, ArrayList<Integer>> eventIdsByArtist = new HashMap<Artist, ArrayList<Integer>>();
	private static HashMap<Integer, Artist> artistById = new HashMap<Integer, Artist>();

	/**
	 * Generates a new event id that has not already been used yet
	 * 
	 * @return An unused id
	 */
	private int getNewEventId(Artist a) {
		ArrayList<Integer> eventIds = eventIdsByArtist.get(a);

		// Since the event ids are stored in an arraylist, and this list is sorted
		// smallest to biggest, we just need to know the last number added
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
	 * Adds an upcoming event to the list. If the artist is not in the list, they
	 * will be added, along with the event. Otherwise, the event will be added to
	 * the pre-existing list and sorted according to its start date.
	 * 
	 * @param artist The artist headlining the event
	 * @param event  The event to be added
	 */
	public void addUpcomingEvent(Artist artist, MusicEvent event) {
		int id = getNewEventId(artist);
		event.setEventId(id);

		if (!upcomingEventsArtist.containsKey(artist)) {
			addArtist(artist);
		}

		ArrayList<MusicEvent> alme = upcomingEventsArtist.get(artist);
		alme.add(event);

		ArrayList<Integer> ali = eventIdsByArtist.get(artist);
		ali.add(event.getEventId());
		// alme.sort(new SortByDate());
	}

	/**
	 * Adds an artist which does not exist yet.
	 * 
	 * @param artist The artist to add
	 */
	private void addArtist(Artist artist) {
		int id = getNewArtistId();

		upcomingEventsArtist.put(artist, new ArrayList<MusicEvent>());
		eventIdsByArtist.put(artist, new ArrayList<Integer>());
	}

	/**
	 * Deletes the artist from the list of upcoming events
	 * 
	 * @param artist The artist to delete
	 * @return Whether or not the artist was successfully deleted
	 */
	public boolean deleteArtist(Artist artist) {
		boolean wasRemoved = upcomingEventsArtist.remove(artist) != null;
		if(wasRemoved) {
			
		}
		
		return wasRemoved;
	}

	/**
	 * Deletes a specific event from an artist's upcoming event list
	 * 
	 * @param artist The artist headlining the event
	 * @param me     The event to delete
	 * @return Whether or not the event was sucessfully deleted
	 */
	public boolean deleteEvent(Artist artist, MusicEvent me) {
		return upcomingEventsArtist.remove(artist, me);
	}

	public HashMap<Artist, ArrayList<MusicEvent>> getUpcomingEventsArtist() {
		return upcomingEventsArtist;
	}

	/**
	 * Find the {@link MusicEvent} based on the artist who headlined it and the
	 * event's unique identifier
	 * 
	 * @param a  The artist
	 * @param id The music event's identifier
	 * @return The MusicEvent, if it exists, otherwise, null
	 */
	public MusicEvent getEventByArtistAndId(Artist a, Integer id) {
		ArrayList<MusicEvent> artistMusicEvents = upcomingEventsArtist.get(a);
		if (artistMusicEvents == null)
			return null;
		for (MusicEvent me : artistMusicEvents) {
			if (me.getEventId() == id) {
				return me;
			}
		}
		return null;
	}

	/**
	 * A private class to help sort {@link MusicEvent}s by date
	 * 
	 * @author mattewyang1325@gmail.com
	 *
	 */
	private class SortByDate implements Comparator<MusicEvent> {
		public int compare(MusicEvent me1, MusicEvent me2) {
			return me1.getStartDate().compareTo(me2.getStartDate());
		}
	}
}
