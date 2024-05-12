
package com.newmusic.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeleteEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteEvent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ArtistId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EventId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteEvent", propOrder = {
    "artistId",
    "eventId"
})
public class DeleteEvent {

    @XmlElement(name = "ArtistId")
    protected int artistId;
    @XmlElement(name = "EventId")
    protected int eventId;

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
     * Gets the value of the eventId property.
     * 
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     */
    public void setEventId(int value) {
        this.eventId = value;
    }

}
