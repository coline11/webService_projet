
package com.newmusic.webservice.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for artist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="artist"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dead" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="disambiguation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="events" type="{http://www.com.newmusic.webservice.resource}musicEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artist", propOrder = {
	"artistId",
    "alias",
    "country",
    "dead",
    "disambiguation",
    "events",
    "firstName",
    "gender",
    "lastName"
})
public class Artist {

	protected int artistId;
    protected String alias;
    protected String country;
    protected boolean dead;
    protected String disambiguation;
    @XmlElement(nillable = true)
    protected List<MusicEvent> events;
    protected String firstName;
    protected String gender;
    protected String lastName;
    
    public int getArtistsId() {
    	return artistId;
    }
    
    public void setArtistId(int value) {
    	artistId = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the dead property.
     * 
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Sets the value of the dead property.
     * 
     */
    public void setDead(boolean value) {
        this.dead = value;
    }

    /**
     * Gets the value of the disambiguation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisambiguation() {
        return disambiguation;
    }

    /**
     * Sets the value of the disambiguation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisambiguation(String value) {
        this.disambiguation = value;
    }

    /**
     * Gets the value of the events property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the events property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MusicEvent }
     * 
     * 
     */
    public List<MusicEvent> getEvents() {
        if (events == null) {
            events = new ArrayList<MusicEvent>();
        }
        return this.events;
    }
    
    public void setEvents(List<MusicEvent> value) {
    	events = new ArrayList<MusicEvent>(value);
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }
    
	@Override
	public String toString() {
		String name = firstName + " " + lastName;
		if(!alias.isEmpty()) name += " (AKA " + alias + ")";
		if(!country.isEmpty()) name += ": Born in: " + country;
		if(!gender.isEmpty()) name += "; Gender: " + gender;
		if(!disambiguation.isEmpty()) name += "; Disambig: " + disambiguation;
		name += "; Is dead: " + dead;
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
