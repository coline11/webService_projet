package com.newmusic.web.resource;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.newmusic.web.data.Artist;

public class DistantWSAccess {
	
	public static String searchByArtistAlias(Artist a) {
		return searchByArtist(a.getAlias());
	}
	
	public static String searchByArtistName(Artist a) {
		String firstName = a.getFirstName();
		String lastName = a.getLastName();
		
		String searchQuery = firstName+"%20"+lastName;
		
		return searchByArtist(searchQuery);
	}
	
	public static String searchByArtist(String artistInfo) {
		return search("artist:%22" + artistInfo + "%22");
	}
	
	public static String searchEvent(String eventName) {
		String searchTerm = "";
		try {
			searchTerm = URLEncoder.encode(eventName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return search("event:%22" + searchTerm + "%22"); // test
	}
	
	public static String searchPlace(String placeName) {
		String searchTerm = "";
		try {
			searchTerm = URLEncoder.encode(placeName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return search("place:%22" + searchTerm + "%22"); // test
	}
	
	public static String search(String query) {
		String webServiceResponse = "";
		try {
            // Replace "http://example.com/api" with the actual URL of the web service
            URL url = new URL("https://musicbrainz.org/ws/2/event/?query="+query+"&fmt=xml"); // URL of the online web service
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Reading response from the web service
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder responseBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                responseBuilder.append(scanner.nextLine());
            }
            scanner.close();

            // Process the response as needed
            webServiceResponse = responseBuilder.toString();
            
            //System.out.println(webServiceResponse);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return webServiceResponse;
	}
	
	/**
	 * Method to test XML parsing
	 * @param xmlString
	 */
	private static void parseXML(String xmlString) {
		try {
			// Parse the XML string
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        InputSource is = new InputSource(new StringReader(xmlString));
	        Document document = builder.parse(is);
	
	        // Get the root element
	        Element root = document.getDocumentElement();
	
	        // Print root element
	        System.out.println("Root element: " + root.getNodeName());
	
	        // Access child nodes or process the XML as needed
	        // In this example, assuming a simple structure with one person
	        Node eventElement = root.getElementsByTagName("event-list").item(0);
	        NamedNodeMap eventNodes = eventElement.getAttributes();
	        
	        String nbAmount = eventNodes.item(0).getNodeValue();
	        
	        System.out.println(nbAmount);
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
