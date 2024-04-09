package com.newmusic.web.data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

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
	
	public String toString() {
		String name = firstName + " " + lastName;
		if(!alias.isEmpty()) name += " (AKA " + alias + ")";
		if(!country.isEmpty()) name += "\nBorn in: " + country;
		if(!gender.isEmpty()) name += "\nGender: " + gender;
		if(!disamiguation.isEmpty()) name += "\nDisambig: " + disamiguation;
		name += "\nIs dead: " + isDead;
		return name;
	}
	
    public void setFromXML(String xmlData) {
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
                    this.firstName = nameParts[0];
                    this.lastName = nameParts[1];
                }
            }


            // Get alias elements
            NodeList aliasNodes = artistElement.getElementsByTagName("alias");
            if (aliasNodes.getLength() > 0) {
                this.alias = aliasNodes.item(0).getTextContent();
            }

            // Get country element
            NodeList countryNodes = artistElement.getElementsByTagName("country");
            if (countryNodes.getLength() > 0) {
                this.country = countryNodes.item(0).getTextContent();
            }

            // Get gender element
            NodeList genderNodes = artistElement.getElementsByTagName("gender");
            if (genderNodes.getLength() > 0) {
                this.gender = genderNodes.item(0).getTextContent();
            }

            // Set isDead based on life-span element
            NodeList lifeSpanNodes = artistElement.getElementsByTagName("life-span");
            if (lifeSpanNodes.getLength() > 0) {
                Element lifeSpanElement = (Element) lifeSpanNodes.item(0);
                String ended = lifeSpanElement.getElementsByTagName("ended").item(0).getTextContent();
                this.isDead = "true".equals(ended);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
