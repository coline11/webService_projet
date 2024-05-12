package com.newmusic.webservice.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data class for to store information on an event
 * @author Yang Mattew
 *
 */
@XmlRootElement
public class MusicEvent {
	private int eventId;
	private String type = "";
	private String eventName = "";
	private String disambiguation = "";
	private Artist performer = null;
	private String location = "";
	private int score = 999;

	/**
	 * Empty constructor for running RESTful service
	 */
	public MusicEvent() {}

    /**
     * Constructs a MusicEvent with a name and performer.
     *
     * @param name   The name of the event.
     * @param byWho  The performer of the event.
     */
    public MusicEvent(String name, Artist byWho) {
        eventName = name;
        performer = byWho;
    }

    /**
     * Constructs a MusicEvent with a name, disambiguation, and artist.
     *
     * @param name      The name of the event.
     * @param disambig  The disambiguation of the event.
     * @param byWho     The performer of the event.
     */
    public MusicEvent(String name, String disambig, Artist byWho) {
        this(name, byWho);
        this.disambiguation = disambig;
    }

    /**
     * Constructs a MusicEvent with only the event's name.
     *
     * @param name  The name of the event.
     */
    public MusicEvent(String name) {
        eventName = name;
    }

    /**
     * Constructs a MusicEvent with only an artist.
     *
     * @param byWho  The artist of the event.
     */
    public MusicEvent(Artist byWho) {
        performer = byWho;
    }

    /**
     * Returns the event ID.
     *
     * @return The event ID.
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Returns the type of the event.
     *
     * @return The type of the event.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the name of the event.
     *
     * @return The name of the event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Returns the disambiguation of the event.
     *
     * @return The disambiguation of the event.
     */
    public String getDisambiguation() {
        return disambiguation;
    }

    /**
     * Returns the performer of the event.
     *
     * @return The performer of the event.
     */
    public Artist getPerformer() {
        return performer;
    }

    /**
     * Returns the location of the event.
     *
     * @return The location of the event.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the score of the event.
     *
     * @return The score of the event.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the event ID.
     *
     * @param eventId The event ID to set.
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * Sets the type of the event.
     *
     * @param type The type of the event to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the name of the event.
     *
     * @param eventName The name of the event to set.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Sets the disambiguation of the event.
     *
     * @param disambiguation The disambiguation of the event to set.
     */
    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    /**
     * Sets the performer of the event.
     *
     * @param performer The performer of the event to set.
     */
    public void setPerformer(Artist performer) {
        this.performer = performer;
    }

    /**
     * Sets the location of the event.
     *
     * @param location The location of the event to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the score of the event.
     *
     * @param score The score of the event to set.
     */
    public void setScore(int score) {
        this.score = score;
    }
	
	@Override
	public String toString() {
		String event = eventName;
		if(!location.equals("")) event += ", at: " + location;
		if(!type.equals("")) event += "\nType: " + type;
		if(score != 999) event += "\nScore: " + score;
		return event;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		// Ignoring id because it's not an inherent property of the artist
		MusicEvent comparing = (MusicEvent) o;
		boolean isEqual = true;
		isEqual = isEqual && (comparing.getType().equals(getType()));
		isEqual = isEqual && (comparing.getEventName().equals(getEventName()));
		isEqual = isEqual && (comparing.getPerformer().equals(getPerformer()));
		isEqual = isEqual && (comparing.getLocation().equals(getLocation()));
		isEqual = isEqual && (comparing.getScore() == getScore());
		return isEqual;
	}
}
