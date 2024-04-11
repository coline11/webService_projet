package com.newmusic.web.data;

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
	
	public MusicEvent() {}
	
	public MusicEvent(String name, Artist byWho) {
		eventName = name;
		performer = byWho;
	}
	
	public MusicEvent(String name, String disambig, Artist byWho) {
		this(name, byWho);
		this.disambiguation = disambig;
	}
	
	public MusicEvent(String name) {
		eventName = name;
	}
	
	public MusicEvent(Artist byWho) {
		performer = byWho;
	}

	public int getEventId() {
		return eventId;
	}

	public String getType() {
		return type;
	}

	public String getEventName() {
		return eventName;
	}

	public String getDisambiguation() {
		return disambiguation;
	}

	public Artist getPerformer() {
		return performer;
	}

	public String getLocation() {
		return location;
	}

	public int getScore() {
		return score;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public void setType(String type) {
		this.type = type;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public void setDisambiguation(String disambiguation) {
		this.disambiguation = disambiguation;
	}

	public void setPerformer(Artist performer) {
		this.performer = performer;
	}

	public void setLocation(String location) {
		this.location = location;
	}

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
