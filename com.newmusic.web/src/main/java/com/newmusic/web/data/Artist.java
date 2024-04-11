package com.newmusic.web.data;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artist {
	private int artistId;
	private String firstName = "", lastName = "", alias = "";
	//private LocalDate birthdate = Constants.NULL_DATE;
	private String country = "";
	private String gender = "";
	private String disamiguation = "";
	private boolean isDead = false;
	
	public Artist() {}
	
	public Artist(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	
	public Artist(String a) {
		alias = a;
	}

	public int getArtistsId() {
		return artistId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String[] getName() {
		String ans[] = {firstName, lastName};
		return ans;
	}

	public String getAlias() {
		return alias;
	}

	public String getCountry() {
		return country;
	}

	public String getGender() {
		return gender;
	}

	public String getDisamiguation() {
		return disamiguation;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setName(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDisamiguation(String disamiguation) {
		this.disamiguation = disamiguation;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	@Override
	public String toString() {
		String name = firstName + " " + lastName;
		if(!alias.isEmpty()) name += " (AKA " + alias + ")";
		if(!country.isEmpty()) name += ":\nBorn in: " + country;
		if(!gender.isEmpty()) name += "\nGender: " + gender;
		if(!disamiguation.isEmpty()) name += "\nDisambig: " + disamiguation;
		name += "\nIs dead: " + isDead;
		return name;
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
		isSame = isSame && (comparing.getDisamiguation().equals(this.getDisamiguation()));
		isSame = isSame && (comparing.getFirstName().equals(this.getFirstName()));
		// isSame = isSame && ( comparing.getGender().equals(this.getGender()));
		isSame = isSame && (comparing.getLastName().equals(this.getLastName()));
		return isSame;
	}
}
