package com.newmusic.webservice.resource;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.newmusic.webservice.data.Artist;
import com.newmusic.webservice.data.MusicEvent;

@WebService(targetNamespace = "http://www.com.newmusic.webservice.resource")
public class MusicResourceWS {
    MusicService service = new MusicService();

    @WebMethod(operationName = "AddUpcomingEvent")
    @WebResult(name = "Response")
    public Integer addUpcomingEvent(
        @WebParam(name = "ArtistId") int artistId,
        @WebParam(name = "Event") MusicEvent event
    ) {
        MusicEvent eventAdded = service.addUpcomingEvent(artistId, event);
        if (eventAdded == null) {
            return -1;
        } else {
            return eventAdded.getEventId();
        }
    }

    @WebMethod(operationName = "AddArtist")
    @WebResult(name = "Response")
    public Integer addArtist(@WebParam(name = "Artist") Artist artist) {
        Artist artistAdded = service.addArtist(artist);
        if (artistAdded == null) {
            return -1;
        } else {
            return artist.getArtistId();
        }
    }

    @WebMethod(operationName = "DeleteArtist")
    @WebResult(name = "Response")
    public boolean deleteArtist(@WebParam(name = "ArtistId") int id) {
    	return service.deleteArtist(id);
    }

    @WebMethod(operationName = "GetArtist")
    @WebResult(name = "Artist")
    public Artist getArtist(@WebParam(name = "ArtistId") int id) {
        return service.getArtist(id);
    }

    @WebMethod(operationName = "GetEvents")
    @WebResult(name = "Events")
    public Artist getEvents(@WebParam(name = "ArtistId") int artistId) {
        return service.getArtistEvents(artistId);
    }

    @WebMethod(operationName = "GetEvent")
    @WebResult(name = "Event")
    public MusicEvent getEvent(
        @WebParam(name = "ArtistId") int artistId,
        @WebParam(name = "EventId") int eventId
    ) {
        return service.getEventByArtistAndId(artistId, eventId);
    }

    @WebMethod(operationName = "DeleteEvent")
    @WebResult(name = "Response")
    public boolean deleteEvent(
        @WebParam(name = "ArtistId") int artistId,
        @WebParam(name = "EventId") int musicId
    ) {
    	return service.deleteEvent(artistId, musicId);
    }
}
