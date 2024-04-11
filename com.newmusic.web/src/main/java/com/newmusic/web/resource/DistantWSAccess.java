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
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.newmusic.web.data.Artist;

/**
 * Class that handles the API calls to MusicBrainz and fills out the Artist instance.
 * @author Yang Mattew & Wu Jingyi
 *
 */
public class DistantWSAccess {
	
	private static String searchByArtistAlias(Artist a) {
		return searchByArtist(a.getAlias());
	}
	
	private static String searchByArtistName(Artist a) {
		String firstName = a.getFirstName();
		String lastName = a.getLastName();
		
		String searchQuery = firstName+" "+lastName;
		
		return searchByArtist(searchQuery);
	}
	
	private static String searchByArtist(String artistInfo) {
		try {
			artistInfo = URLEncoder.encode(artistInfo, "UTF-8");
			artistInfo = artistInfo.replaceAll("\\+", "%20"); // 'Cause encoding translates space into + and not %20
			String artistSearch = "artist:%22" + artistInfo + "%22";
			return search("artist", artistSearch);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	private static String searchEvent(String eventName) {
		String searchTerm = "";
		try {
			searchTerm = URLEncoder.encode(eventName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return search("event", "event:%22" + searchTerm + "%22"); // test
	}
	
	private static String searchPlace(String placeName) {
		String searchTerm = "";
		try {
			searchTerm = URLEncoder.encode(placeName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return search("place", "place:%22" + searchTerm + "%22"); // test
	}
	
	public static String search(String type, String query) {
		String webServiceResponse = "";
		try {
			String searchQuery = "https://musicbrainz.org/ws/2/"+ type +"/?query="+query+"&fmt=xml";
			//System.out.println(searchQuery);
			URL url = new URL(searchQuery); // URL of the online web service
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
	 * Create an instance of the {@link Artist} class based on the xml results gotten from the API request.
	 * @param xmlData The results from the API request
	 * @return The {@link Artist} instance
	 */
    public static Artist setFromXML(Artist artist, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlData));
            Document document = builder.parse(is);

            // Get artist element
            Element artistElement = (Element) document.getElementsByTagName("artist").item(0);

         // Get name elements
            NodeList nameNodes = artistElement.getElementsByTagName("name");
            if (nameNodes.getLength() > 0) {
                String fullName = nameNodes.item(0).getTextContent();
                // Assuming the full name is "Billie Eilish" format
                String[] nameParts = fullName.split(" ");
                if (nameParts.length == 2) {
                	artist.setFirstName(nameParts[0]);
                	artist.setLastName(nameParts[1]);
                }
            }

            // We're looking for official names
            NodeList aliasList = artistElement.getElementsByTagName("alias");
            String type = "";
            for (int i = 0; i < aliasList.getLength() && !type.equals("Legal name"); i++) {
                Element aliasElement = (Element) aliasList.item(i);
                type = aliasElement.getAttribute("type");
                if (type.equals("Legal name")) {
                	if(!artist.getAlias().equals("")) {
                		String flName[] = aliasElement.getTextContent().split(" ");
                		artist.setFirstName(flName[0]);
                		artist.setLastName(flName[1]);
                	} else {
                		artist.setAlias(aliasElement.getTextContent());
                	}
                }
            }

            // Get country element
            // Check first for detailled information, otherwise fall back on acronym

            NodeList areaNode = artistElement.getElementsByTagName("area");
            if(areaNode != null && areaNode.getLength() > 0) {
            	Element areaElement = (Element) areaNode.item(0);
            	artist.setCountry(areaElement.getElementsByTagName("name").item(0).getTextContent());
            } else {
	            NodeList countryNodes = artistElement.getElementsByTagName("country");
	            if (countryNodes.getLength() > 0) {
	                artist.setCountry(countryNodes.item(0).getTextContent());
	            }
            }

            // Get gender element
            NodeList genderNodes = artistElement.getElementsByTagName("gender");
            if (genderNodes.getLength() > 0) {
                artist.setGender(genderNodes.item(0).getTextContent());
            }

            // Set isDead based on life-span element
            NodeList lifeSpanNodes = artistElement.getElementsByTagName("life-span");
            if (lifeSpanNodes.getLength() > 0) {
                Element lifeSpanElement = (Element) lifeSpanNodes.item(0);
                String ended = lifeSpanElement.getElementsByTagName("ended").item(0).getTextContent();
                artist.setDead("true".equals(ended));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

	/**
	 * Fill out an artist's details by making a call to the MusicBrainz API.
	 * 
	 * @param a       The artist in question.
	 * @param byAlias Whether or not we're searching by the artist's alias or their
	 *                first and last name.
	 * @return The artist instance with the details filled out.
	 */
	public static Artist getArtist(Artist a, boolean byAlias) {
		String result = "";
		if (byAlias) {
			result = searchByArtistAlias(a);
		} else {
			result = searchByArtistName(a);
		}
		return setFromXML(a, result);
	}

    /*
    public static void main(String[] args) {
    	Artist a = new Artist("Billie", "Eilish");
    	String result = searchByArtistName(a);
    	//System.out.println(result);
    	a = setFromXML(a, result);
    	
    	System.out.println(a);
    }*/
}
