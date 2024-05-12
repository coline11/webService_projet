
package com.newmusic.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.newmusic.webservice.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddArtist_QNAME = new QName("http://www.com.newmusic.webservice.resource", "AddArtist");
    private final static QName _AddArtistResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "AddArtistResponse");
    private final static QName _AddUpcomingEvent_QNAME = new QName("http://www.com.newmusic.webservice.resource", "AddUpcomingEvent");
    private final static QName _AddUpcomingEventResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "AddUpcomingEventResponse");
    private final static QName _DeleteArtist_QNAME = new QName("http://www.com.newmusic.webservice.resource", "DeleteArtist");
    private final static QName _DeleteArtistResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "DeleteArtistResponse");
    private final static QName _DeleteEvent_QNAME = new QName("http://www.com.newmusic.webservice.resource", "DeleteEvent");
    private final static QName _DeleteEventResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "DeleteEventResponse");
    private final static QName _GetArtist_QNAME = new QName("http://www.com.newmusic.webservice.resource", "GetArtist");
    private final static QName _GetArtistResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "GetArtistResponse");
    private final static QName _GetEvent_QNAME = new QName("http://www.com.newmusic.webservice.resource", "GetEvent");
    private final static QName _GetEventResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "GetEventResponse");
    private final static QName _GetEvents_QNAME = new QName("http://www.com.newmusic.webservice.resource", "GetEvents");
    private final static QName _GetEventsResponse_QNAME = new QName("http://www.com.newmusic.webservice.resource", "GetEventsResponse");
    private final static QName _Artist_QNAME = new QName("http://www.com.newmusic.webservice.resource", "artist");
    private final static QName _MusicEvent_QNAME = new QName("http://www.com.newmusic.webservice.resource", "musicEvent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.newmusic.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddArtist }
     * 
     */
    public AddArtist createAddArtist() {
        return new AddArtist();
    }

    /**
     * Create an instance of {@link AddArtistResponse }
     * 
     */
    public AddArtistResponse createAddArtistResponse() {
        return new AddArtistResponse();
    }

    /**
     * Create an instance of {@link AddUpcomingEvent }
     * 
     */
    public AddUpcomingEvent createAddUpcomingEvent() {
        return new AddUpcomingEvent();
    }

    /**
     * Create an instance of {@link AddUpcomingEventResponse }
     * 
     */
    public AddUpcomingEventResponse createAddUpcomingEventResponse() {
        return new AddUpcomingEventResponse();
    }

    /**
     * Create an instance of {@link DeleteArtist }
     * 
     */
    public DeleteArtist createDeleteArtist() {
        return new DeleteArtist();
    }

    /**
     * Create an instance of {@link DeleteArtistResponse }
     * 
     */
    public DeleteArtistResponse createDeleteArtistResponse() {
        return new DeleteArtistResponse();
    }

    /**
     * Create an instance of {@link DeleteEvent }
     * 
     */
    public DeleteEvent createDeleteEvent() {
        return new DeleteEvent();
    }

    /**
     * Create an instance of {@link DeleteEventResponse }
     * 
     */
    public DeleteEventResponse createDeleteEventResponse() {
        return new DeleteEventResponse();
    }

    /**
     * Create an instance of {@link GetArtist }
     * 
     */
    public GetArtist createGetArtist() {
        return new GetArtist();
    }

    /**
     * Create an instance of {@link GetArtistResponse }
     * 
     */
    public GetArtistResponse createGetArtistResponse() {
        return new GetArtistResponse();
    }

    /**
     * Create an instance of {@link GetEvent }
     * 
     */
    public GetEvent createGetEvent() {
        return new GetEvent();
    }

    /**
     * Create an instance of {@link GetEventResponse }
     * 
     */
    public GetEventResponse createGetEventResponse() {
        return new GetEventResponse();
    }

    /**
     * Create an instance of {@link GetEvents }
     * 
     */
    public GetEvents createGetEvents() {
        return new GetEvents();
    }

    /**
     * Create an instance of {@link GetEventsResponse }
     * 
     */
    public GetEventsResponse createGetEventsResponse() {
        return new GetEventsResponse();
    }

    /**
     * Create an instance of {@link Artist }
     * 
     */
    public Artist createArtist() {
        return new Artist();
    }

    /**
     * Create an instance of {@link MusicEvent }
     * 
     */
    public MusicEvent createMusicEvent() {
        return new MusicEvent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArtist }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddArtist }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "AddArtist")
    public JAXBElement<AddArtist> createAddArtist(AddArtist value) {
        return new JAXBElement<AddArtist>(_AddArtist_QNAME, AddArtist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArtistResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddArtistResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "AddArtistResponse")
    public JAXBElement<AddArtistResponse> createAddArtistResponse(AddArtistResponse value) {
        return new JAXBElement<AddArtistResponse>(_AddArtistResponse_QNAME, AddArtistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUpcomingEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddUpcomingEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "AddUpcomingEvent")
    public JAXBElement<AddUpcomingEvent> createAddUpcomingEvent(AddUpcomingEvent value) {
        return new JAXBElement<AddUpcomingEvent>(_AddUpcomingEvent_QNAME, AddUpcomingEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUpcomingEventResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddUpcomingEventResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "AddUpcomingEventResponse")
    public JAXBElement<AddUpcomingEventResponse> createAddUpcomingEventResponse(AddUpcomingEventResponse value) {
        return new JAXBElement<AddUpcomingEventResponse>(_AddUpcomingEventResponse_QNAME, AddUpcomingEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArtist }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteArtist }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "DeleteArtist")
    public JAXBElement<DeleteArtist> createDeleteArtist(DeleteArtist value) {
        return new JAXBElement<DeleteArtist>(_DeleteArtist_QNAME, DeleteArtist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArtistResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteArtistResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "DeleteArtistResponse")
    public JAXBElement<DeleteArtistResponse> createDeleteArtistResponse(DeleteArtistResponse value) {
        return new JAXBElement<DeleteArtistResponse>(_DeleteArtistResponse_QNAME, DeleteArtistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "DeleteEvent")
    public JAXBElement<DeleteEvent> createDeleteEvent(DeleteEvent value) {
        return new JAXBElement<DeleteEvent>(_DeleteEvent_QNAME, DeleteEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEventResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEventResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "DeleteEventResponse")
    public JAXBElement<DeleteEventResponse> createDeleteEventResponse(DeleteEventResponse value) {
        return new JAXBElement<DeleteEventResponse>(_DeleteEventResponse_QNAME, DeleteEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArtist }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetArtist }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "GetArtist")
    public JAXBElement<GetArtist> createGetArtist(GetArtist value) {
        return new JAXBElement<GetArtist>(_GetArtist_QNAME, GetArtist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArtistResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetArtistResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "GetArtistResponse")
    public JAXBElement<GetArtistResponse> createGetArtistResponse(GetArtistResponse value) {
        return new JAXBElement<GetArtistResponse>(_GetArtistResponse_QNAME, GetArtistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "GetEvent")
    public JAXBElement<GetEvent> createGetEvent(GetEvent value) {
        return new JAXBElement<GetEvent>(_GetEvent_QNAME, GetEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEventResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "GetEventResponse")
    public JAXBElement<GetEventResponse> createGetEventResponse(GetEventResponse value) {
        return new JAXBElement<GetEventResponse>(_GetEventResponse_QNAME, GetEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEvents }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "GetEvents")
    public JAXBElement<GetEvents> createGetEvents(GetEvents value) {
        return new JAXBElement<GetEvents>(_GetEvents_QNAME, GetEvents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEventsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "GetEventsResponse")
    public JAXBElement<GetEventsResponse> createGetEventsResponse(GetEventsResponse value) {
        return new JAXBElement<GetEventsResponse>(_GetEventsResponse_QNAME, GetEventsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Artist }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Artist }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "artist")
    public JAXBElement<Artist> createArtist(Artist value) {
        return new JAXBElement<Artist>(_Artist_QNAME, Artist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MusicEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MusicEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.newmusic.webservice.resource", name = "musicEvent")
    public JAXBElement<MusicEvent> createMusicEvent(MusicEvent value) {
        return new JAXBElement<MusicEvent>(_MusicEvent_QNAME, MusicEvent.class, null, value);
    }

}
