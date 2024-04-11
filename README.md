# Projet de services web

## Membres

- WU Jingyi (Email: wjycoline@gmail.com)
- YANG Mattew (Email: emailecolematty@gmail.com)

## Introduction

### Service Web d'Événements Musicaux

Le Service Web d'Événements Musicaux est un projet de service web développé en Java, conçu pour enregistrer et fournir des informations sur les événements musicaux à venir, et permettre aux utilisateurs de rechercher ces informations par région ou par artiste. Ce projet comprend deux composants principaux : le service web et le client.

### Description du service
La partie service web est développée à l'aide des frameworks JAX-WS et JAX-RS, offrant des interfaces en REST et WS-*. Il contient au moins deux opérations, l'une pour enregistrer de nouveaux événements musicaux et l'autre pour récupérer des informations sur les événements. De plus, nous essayerons de stocker les données dans une base de données pour une gestion plus efficace des informations sur les événements.

### Description du client
Le client est une application Java capable d'appeler toutes les opérations du service web. Il peut créer de nouveaux événements musicaux et artistes, et afficher les informations sur les événements regroupés par artiste. De plus, le client appelle également un service web musical externe, tel que l'API MusicBrainz ou l'API Web Spotify, pour obtenir des informations sur la nationalité des artistes et enrichir l'affichage des informations sur les événements.

### Cas d'utilisation
L'objectif de ce projet est de créer un système de gestion des événements musicaux simple et convivial, permettant aux utilisateurs de rechercher et de découvrir facilement les événements musicaux à venir, tout en affichant des informations pertinentes sur les artistes, offrant ainsi une expérience musicale plus enrichissante.

#### Features

- Utilisez la méthode `searchByArtist(artistInfo)` pour rechercher des événements musicaux liés à un artiste.
- Utilisez la méthode `searchPlace(placeName)` pour rechercher des événements musicaux à une adresse spécifique.
- Utilisez la méthode `searchEvent(eventName)` pour rechercher des événements musicaux avec un nom spécifique.
...

#### Comment utiliser

1. **Recherchez un événement musicaux lié à un artiste, par exemple "Paradise Tour: San Francisco"**

   ```java
		Artist artist = new Artist("Ed", "Sheeran");
		idArtistMain = addArtist(artist);
   
		idEventMain = addUpcomingEvent(idArtistMain, "Paradise Tour: San Francisco", "");
		System.out.println("Ajout d'un événement au numéro de l'artiste " + artistId + " à " + idEventMain);

		MusicEvent me = getEvent(artistId, idEventMain);
		System.out.println(me);

2. **Rechercher des événements musicaux liés à un artiste, par exemple "Taylor Swift"**

   ```java
		Artist artist = new Artist("Taylor", "Swift");
		idArtistMain = addArtist(artist);
		Artist artistEvents = getEvents(idArtistMain);
		System.out.println(artistEvents.toStringWithEvents());
   
3. **Ajouter et rechercher un artiste, par exemple, Billie Eilish**

   ```java
		Artist a;

		Artist artist = new Artist("Billie", "Eilish");
		idArtistMain = addArtist(artist);
		System.out.println("Ajout d'un artiste au numéro: " + idArtistMain);
		a = getArtist(idArtistMain);
		System.out.println("Artiste: ");
		System.out.println(a + "\n");


