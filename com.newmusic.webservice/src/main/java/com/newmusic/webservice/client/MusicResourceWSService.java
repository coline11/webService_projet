package com.newmusic.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.7
 * 2024-04-26T00:33:34.172+02:00
 * Generated source version: 3.5.7
 *
 */
@WebServiceClient(name = "MusicResourceWSService",
                  wsdlLocation = "file:/C:/Users/Etudiant/eclipse-workspace-redo/com.newmusic.webservice/src/main/webapp/wsdl/musicresourcews.wsdl",
                  targetNamespace = "http://www.com.newmusic.webservice.resource")
public class MusicResourceWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.com.newmusic.webservice.resource", "MusicResourceWSService");
    public final static QName MusicResourceWSPort = new QName("http://www.com.newmusic.webservice.resource", "MusicResourceWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/Etudiant/eclipse-workspace-redo/com.newmusic.webservice/src/main/webapp/wsdl/musicresourcews.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MusicResourceWSService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/Etudiant/eclipse-workspace-redo/com.newmusic.webservice/src/main/webapp/wsdl/musicresourcews.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MusicResourceWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MusicResourceWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MusicResourceWSService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public MusicResourceWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MusicResourceWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MusicResourceWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns MusicResourceWS
     */
    @WebEndpoint(name = "MusicResourceWSPort")
    public MusicResourceWS getMusicResourceWSPort() {
        return super.getPort(MusicResourceWSPort, MusicResourceWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MusicResourceWS
     */
    @WebEndpoint(name = "MusicResourceWSPort")
    public MusicResourceWS getMusicResourceWSPort(WebServiceFeature... features) {
        return super.getPort(MusicResourceWSPort, MusicResourceWS.class, features);
    }

}
