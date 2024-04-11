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
	
	/**
	 * Empty constructor for running RESTful service
	 */
	public Artist() {}
	
	/**
	 * Declare artist using their name
	 * @param fName The artist's first name
	 * @param lName The artist's last name
	 */
	public Artist(String fName, String lName) {
		artistFirstName = fName;
		artistLastName = lName;
	}
	
	/**
	 * Declare artist using their alias
	 * @param a The artist's alias
	 */
	public Artist(String a) {
		artistAlias = a;
	}
    /**
     * Gets the ID of the artist.
     * @return The artist's ID.
     */
    public int getArtistsId() {
        return artistId;
    }

    /**
     * Gets the first name of the artist.
     * @return The artist's first name.
     */
    public String getFirstName() {
        return artistFirstName;
    }

    /**
     * Gets the last name of the artist.
     * @return The artist's last name.
     */
    public String getLastName() {
        return artistLastName;
    }

    /**
     * Gets an array containing the first and last name of the artist.
     * @return An array containing the first and last name of the artist.
     */
    public String[] getName() {
        String ans[] = {artistFirstName, artistLastName};
        return ans;
    }

    /**
     * Gets the alias of the artist.
     * @return The artist's alias.
     */
    public String getAlias() {
        return artistAlias;
    }

    /**
     * Gets the country of the artist.
     * @return The artist's country.
     */
    public String getCountry() {
        return artistCountry;
    }

    /**
     * Gets the gender of the artist.
     * @return The artist's gender.
     */
    public String getGender() {
        return artistGender;
    }

    /**
     * Gets the disambiguation information of the artist.
     * @return The artist's disambiguation information.
     */
    public String getDisambiguation() {
        return artistDisambiguation;
    }

    /**
     * Checks if the artist is dead.
     * @return True if the artist is dead, otherwise false.
     */
    public boolean isDead() {
        return artistIsDead;
    }

    /**
     * Sets the ID of the artist.
     * @param artistId The artist's ID.
     */
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    /**
     * Sets the first name of the artist.
     * @param firstName The artist's first name.
     */
    public void setFirstName(String firstName) {
        this.artistFirstName = firstName;
    }

    /**
     * Sets the last name of the artist.
     * @param lastName The artist's last name.
     */
    public void setLastName(String lastName) {
        this.artistLastName = lastName;
    }

    /**
     * Sets the name of the artist.
     * @param fName The artist's first name.
     * @param lName The artist's last name.
     */
    public void setName(String fName, String lName) {
        artistFirstName = fName;
        artistLastName = lName;
    }

    /**
     * Sets the alias of the artist.
     * @param alias The artist's alias.
     */
    public void setAlias(String alias) {
        this.artistAlias = alias;
    }

    /**
     * Sets the country of the artist.
     * @param country The artist's country.
     */
    public void setCountry(String country) {
        this.artistCountry = country;
    }

    /**
     * Sets the gender of the artist.
     * @param gender The artist's gender.
     */
    public void setGender(String gender) {
        this.artistGender = gender;
    }

    /**
     * Sets the disambiguation information of the artist.
     * @param disambiguation The artist's disambiguation information.
     */
    public void setDisambiguation(String disambiguation) {
        this.artistDisambiguation = disambiguation;
    }

    /**
     * Sets whether the artist is dead or alive.
     * @param isDead True if the artist is dead, otherwise false.
     */
    public void setDead(boolean isDead) {
        this.artistIsDead = isDead;
    }

    /**
     * Sets the list of events associated with the artist.
     * @param alme ArrayList of MusicEvent objects representing the events.
     */
    public void setEvents(ArrayList<MusicEvent> alme) {
        events = alme;
    }

    /**
     * Gets the list of events associated with the artist.
     * @return ArrayList of MusicEvent objects representing the events.
     */
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
	
	/**
	 * The toString, but with the saved events
	 * @return The toString, but with the saved events
	 */
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
