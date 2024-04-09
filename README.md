# webService_projet

## membres

- WU Jingyi (Email: wjycoline@gmail.com)
- YANG Mattew (Email: emailecolematty@gmail.com)

## Introduction

### Service Web d'Événements Musicaux

Le Service Web d'Événements Musicaux est un projet de service web développé en Java, conçu pour enregistrer et fournir des informations sur les événements musicaux à venir, et permettre aux utilisateurs de rechercher ces informations par région ou par artiste. Ce projet comprend deux composants principaux : le service web et le client.

### Services’ description
La partie service web est développée à l'aide des frameworks JAX-WS et JAX-RS, offrant des interfaces en REST et WS-*. Il contient au moins deux opérations, l'une pour enregistrer de nouveaux événements musicaux et l'autre pour récupérer des informations sur les événements. De plus, nous essayerons de stocker les données dans une base de données pour une gestion plus efficace des informations sur les événements.

### Clients’ description
Le client est une application Java capable d'appeler toutes les opérations du service web. Il peut créer de nouveaux événements musicaux et artistes, et afficher les informations sur les événements regroupés par artiste. De plus, le client appelle également un service web musical externe, tel que l'API MusicBrainz ou l'API Web Spotify, pour obtenir des informations sur la nationalité des artistes et enrichir l'affichage des informations sur les événements.

### use case demonstrating
L'objectif de ce projet est de créer un système de gestion des événements musicaux simple et convivial, permettant aux utilisateurs de rechercher et de découvrir facilement les événements musicaux à venir, tout en affichant des informations pertinentes sur les artistes, offrant ainsi une expérience musicale plus enrichissante.

#### Features

- Utilize the `searchByArtist(artistInfo)` method to search for music events related to an artist.
- Use the `searchPlace(placeName)` method to search for music events at a specific address.
- Use the `searchEvent(eventName)` method to search for music events with a specific name.
...

#### How to Use

1. **Search for Music Events Related to an Artist for example "Billie Eilish"**

   ```java
   String artistInfo = "Billie Eilish";
   String s = searchByArtist(artistInfo);
   System.out.println(s);

2. **Search for Music Events Related to a Place for example "Studio 104, Radio France"**

   ```java
   String s = DistantWSAccess.searchPlace("Studio 104, Radio France");
   System.out.println(s);
   
3. **Search the Artists**

   ```java
   // Search for information about the artist
	    String artistInfo = "Billie Eilish";
	    String s = searchByArtist(artistInfo);

  // Create an Artist instance
	    Artist artist = new Artist();

  // Use the setFromXML method to set the attributes of the Artist instance
	    artist.setFromXML(s);

  // Print the attributes of the Artist instance to verify correctness
	    System.out.println("First Name: " + artist.getFirstName());
	    System.out.println("Last Name: " + artist.getLastName());
	    System.out.println("Alias: " + artist.getAlias());
	    System.out.println("Country: " + artist.getCountry());
	    System.out.println("Gender: " + artist.getGender());
	    System.out.println("Is Dead: " + artist.isDead());

