
package com.newmusic.webservice.resource.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.7
 * Thu Apr 25 23:45:55 CEST 2024
 * Generated source version: 3.5.7
 */

@XmlRootElement(name = "DeleteArtist", namespace = "http://www.com.newmusic.webservice.resource")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteArtist", namespace = "http://www.com.newmusic.webservice.resource")

public class DeleteArtist {

    @XmlElement(name = "ArtistId")
    private int ArtistId;

    public int getArtistId() {
        return this.ArtistId;
    }

    public void setArtistId(int newArtistId)  {
        this.ArtistId = newArtistId;
    }

}

