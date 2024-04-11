package com.newmusic.web.data;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MusicEvent {
	private int eventId;
	private String type = "";
	private String eventName = "";
	//private LocalDate startDate = Constants.NULL_DATE, endDate = Constants.NULL_DATE;
	private Artist performer = null;
	private String location = "";
	private int score = 999;
	
	public MusicEvent() {}
	
	public MusicEvent(String name, Artist byWho) {
		eventName = name;
		performer = byWho;
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

	/*public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}*/

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

	/*public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}*/

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
		event += ", at: " + location;
		event += "\nType: " + type;
		event += "\nScore: " + score;
		event += "\nArtist: " + performer;
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
