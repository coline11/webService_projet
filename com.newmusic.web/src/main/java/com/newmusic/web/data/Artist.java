package com.newmusic.web.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data class for to store information on an artist
 * @author Yang Mattew
 *
 */
@XmlRootElement
public class Artist {
	private int artistId;
    private String artistFirstName = "";
    private String artistLastName = "";
    private String artistAlias = "";
    private String artistCountry = "";
    private String artistGender = "";
    private String artistDisambiguation = "";
    private boolean artistIsDead = false;

	private ArrayList<MusicEvent> events = new ArrayList<MusicEvent>();
	
	public Artist() {}
	
	public Artist(String fName, String lName) {
		artistFirstName = fName;
		artistLastName = lName;
	}
	
	public Artist(String a) {
		artistAlias = a;
	}

	public int getArtistsId() {
		return artistId;
	}

	public String getFirstName() {
		return artistFirstName;
	}

	public String getLastName() {
		return artistLastName;
	}
	
	public String[] getName() {
		String ans[] = {artistFirstName, artistLastName};
		return ans;
	}

	public String getAlias() {
		return artistAlias;
	}

	public String getCountry() {
		return artistCountry;
	}

	public String getGender() {
		return artistGender;
	}

	public String getDisambiguation() {
		return artistDisambiguation;
	}

	public boolean isDead() {
		return artistIsDead;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public void setFirstName(String firstName) {
		this.artistFirstName = firstName;
	}

	public void setLastName(String lastName) {
		this.artistLastName = lastName;
	}
	
	public void setName(String fName, String lName) {
		artistFirstName = fName;
		artistLastName = lName;
	}

	public void setAlias(String alias) {
		this.artistAlias = alias;
	}

	public void setCountry(String country) {
		this.artistCountry = country;
	}

	public void setGender(String gender) {
		this.artistGender = gender;
	}
	
	public void setDisambiguation(String disambiguation) {
		this.artistDisambiguation = disambiguation;
	}

	public void setDead(boolean isDead) {
		this.artistIsDead = isDead;
	}
    
	public void setEvents(ArrayList<MusicEvent> alme) {
		events = alme;
	}
	
	public ArrayList<MusicEvent> getEvents(){
		return events;
	}
	
	
	@Override
	public String toString() {
		String name = artistFirstName + " " + artistLastName;
		if(!artistAlias.isEmpty()) name += " (AKA " + artistAlias + ")";
		if(!artistCountry.isEmpty()) name += ":\nBorn in: " + artistCountry;
		if(!artistGender.isEmpty()) name += "\nGender: " + artistGender;
		if(!artistDisambiguation.isEmpty()) name += "\nDisambig: " + artistDisambiguation;
		name += "\nIs dead: " + artistIsDead;
		return name;
	}
	
	public String toStringWithEvents() {
		String regularOutput = toString();
		return regularOutput + "\nEvents saved: " + getEvents();
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
		// Ignoring isDead, country, and gender because they may not have been filled in
		Artist comparing = (Artist) o;
		boolean isSame = true;
		// isSame = isSame && ( comparing.isDead == this.isDead );
		isSame = isSame && (comparing.getAlias().equals(this.getAlias()));
		// isSame = isSame && ( comparing.getCountry().equals(this.getCountry()));
		isSame = isSame && (comparing.getDisambiguation().equals(this.getDisambiguation()));
		isSame = isSame && (comparing.getFirstName().equals(this.getFirstName()));
		// isSame = isSame && ( comparing.getGender().equals(this.getGender()));
		isSame = isSame && (comparing.getLastName().equals(this.getLastName()));
		return isSame;
	}
}
