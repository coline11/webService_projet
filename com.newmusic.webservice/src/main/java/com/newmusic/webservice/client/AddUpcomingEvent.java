
package com.newmusic.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddUpcomingEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddUpcomingEvent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ArtistId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Event" type="{http://www.com.newmusic.webservice.resource}musicEvent" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpcomingEvent", propOrder = {
    "artistId",
    "event"
})
public class AddUpcomingEvent {

    @XmlElement(name = "ArtistId")
    protected int artistId;
    @XmlElement(name = "Event")
    protected MusicEvent event;

    /**
     * Gets the value of the artistId property.
     * 
     */
    public int getArtistId() {
        return artistId;
    }

    /**
     * Sets the value of the artistId property.
     * 
     */
    public void setArtistId(int value) {
        this.artistId = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link MusicEvent }
     *     
     */
    public MusicEvent getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link MusicEvent }
     *     
     */
    public void setEvent(MusicEvent value) {
        this.event = value;
    }

}
