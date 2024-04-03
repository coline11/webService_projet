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


