# Documentation Technique du Projet de Gestion de Joueurs et Parties pour un Jeu Vidéo en Ligne

## Table des Matières

1. [Définition des Endpoints](#définition-des-endpoints)
2. [Explication de la Logique Mise en Place](#explication-de-la-logique-mise-en-place)
3. [Définition de la Base de Données](#définition-de-la-base-de-données)
4. [Explication Détaillée du Fonctionnement](#explication-détaillée-du-fonctionnement)

## Définition des Endpoints

### Service de Gestion des Joueurs

#### 1. Ajouter un Joueur
- **URL**: `POST /joueurs`
- **Type de Requête**: POST
- **Paramètres Attendus**:
  ```json
  {
    "nom": "Nom du joueur",
    "pseudonyme": "Pseudonyme du joueur",
    "email": "email@example.com",
    "niveau": 1,
    "pointsTotaux": 0
  }
Réponses Possibles:
Statut: 201 Created
Body:

{
  "id": 1,
  "nom": "Nom du joueur",
  "pseudonyme": "Pseudonyme du joueur",
  "email": "email@example.com",
  "niveau": 1,
  "pointsTotaux": 0
}
2. Obtenir un Joueur
URL: GET /joueurs/{id}
Type de Requête: GET
Paramètres Attendus: id (Path Variable)
Réponses Possibles:
Statut: 200 OK
Body:

{
  "id": 1,
  "nom": "Nom du joueur",
  "pseudonyme": "Pseudonyme du joueur",
  "email": "email@example.com",
  "niveau": 1,
  "pointsTotaux": 0
}
3. Obtenir Tous les Joueurs
URL: GET /joueurs
Type de Requête: GET
Réponses Possibles:
Statut: 200 OK
Body:

[
  {
    "id": 1,
    "nom": "Nom du joueur 1",
    "pseudonyme": "Pseudonyme du joueur 1",
    "email": "email1@example.com",
    "niveau": 1,
    "pointsTotaux": 0
  },
  {
    "id": 2,
    "nom": "Nom du joueur 2",
    "pseudonyme": "Pseudonyme du joueur 2",
    "email": "email2@example.com",
    "niveau": 2,
    "pointsTotaux": 100
  }
]
4. Mettre à Jour un Joueur
URL: PUT /joueurs/{id}
Type de Requête: PUT
Paramètres Attendus:

{
  "nom": "Nouveau nom du joueur",
  "pseudonyme": "Nouveau pseudonyme du joueur",
  "email": "nouvel_email@example.com",
  "niveau": 2,
  "pointsTotaux": 100
}
Réponses Possibles:
Statut: 200 OK
Body:

{
  "id": 1,
  "nom": "Nouveau nom du joueur",
  "pseudonyme": "Nouveau pseudonyme du joueur",
  "email": "nouvel_email@example.com",
  "niveau": 2,
  "pointsTotaux": 100
}
5. Supprimer un Joueur
URL: DELETE /joueurs/{id}
Type de Requête: DELETE
Paramètres Attendus: id (Path Variable)
Réponses Possibles:
Statut: 204 No Content
6. Ajouter un Ami
URL: POST /joueurs/{id}/amis
Type de Requête: POST
Paramètres Attendus:

{
  "idAmi": 2
}
Réponses Possibles:
Statut: 201 Created
Body:

{
  "id": 1,
  "idJoueur": 1,
  "idAmi": 2
}
Service de Gestion des Parties
1. Créer une Partie
URL: POST /parties
Type de Requête: POST
Paramètres Attendus:

{
  "date": "2024-12-12T10:30:00.000+00:00",
  "scoreMax": 15,
  "typePartieId": 1
}
Réponses Possibles:
Statut: 201 Created
Body:

{
  "id": 1,
  "date": "2024-12-12T10:30:00.000+00:00",
  "scoreMax": 15,
  "hote": {
    "id": 1,
    "nom": "Nom du joueur",
    "pseudonyme": "Pseudonyme du joueur",
    "email": "email@example.com",
    "niveau": 1,
    "pointsTotaux": 0
  },
  "typePartie": {
    "id": 1,
    "nom": "Type de partie 1",
    "nombreJoueur": 2
  }
}
2. Obtenir une Partie
URL: GET /parties/{id}
Type de Requête: GET
Paramètres Attendus: id (Path Variable)
Réponses Possibles:
Statut: 200 OK
Body:

{
  "id": 1,
  "date": "2024-12-12T10:30:00.000+00:00",
  "scoreMax": 15,
  "hote": {
    "id": 1,
    "nom": "Nom du joueur",
    "pseudonyme": "Pseudonyme du joueur",
    "email": "email@example.com",
    "niveau": 1,
    "pointsTotaux": 0
  },
  "typePartie": {
    "id": 1,
    "nom": "Type de partie 1",
    "nombreJoueur": 2
  }
}
3. Obtenir Toutes les Parties
URL: GET /parties
Type de Requête: GET
Réponses Possibles:
Statut: 200 OK
Body:

[
  {
    "id": 1,
    "date": "2024-12-12T10:30:00.000+00:00",
    "scoreMax": 15,
    "hote": {
      "id": 1,
      "nom": "Nom du joueur 1",
      "pseudonyme": "Pseudonyme du joueur 1",
      "email": "email1@example.com",
      "niveau": 1,
      "pointsTotaux": 0
    },
    "typePartie": {
      "id": 1,
      "nom": "Type de partie 1",
      "nombreJoueur": 2
    }
  },
  {
    "id": 2,
    "date": "2024-12-12T11:00:00.000+00:00",
    "scoreMax": 20,
    "hote": {
      "id": 2,
      "nom": "Nom du joueur 2",
      "pseudonyme": "Pseudonyme du joueur 2",
      "email": "email2@example.com",
      "niveau": 2,
      "pointsTotaux": 200
    },
    "typePartie": {
      "id": 2,
      "nom": "Type de partie 2",
      "nombreJoueur": 4
    }
  }
]
4. Supprimer une Partie
URL: DELETE /parties/{id}
Type de Requête: DELETE
Paramètres Attendus: id (Path Variable)
Réponses Possibles:
Statut: 204 No Content
5. Enregistrer une Participation
URL: POST /parties/{partieId}/participations
Type de Requête: POST
Paramètres Attendus:

{
  "joueur": {
    "id": 1
  },
  "score": 85,
  "victoire": true
}
Réponses Possibles:
Statut: 201 Created
Body:

{
  "id": 1,
  "partie": {
    "id": 1,
    "date": "2024-12-12T10:30:00.000+00:00",
    "scoreMax": 15,
    "hote": {
      "id": 1,
      "nom": "Nom du joueur",
      "pseudonyme": "Pseudonyme du joueur",
      "email": "email@example.com",
      "niveau": 1,
      "pointsTotaux": 0
    },
    "typePartie": {
      "id": 1,
      "nom": "Type de partie 1",
      "nombreJoueur": 2
    }
  },
  "joueur": {
    "id": 1,
    "nom": "Nom du joueur",
    "pseudonyme": "Pseudonyme du joueur",
    "email": "email@example.com",
    "niveau": 1,
    "pointsTotaux": 0
  },
  "score": 85,
  "victoire": true
}
Explication de la Logique Mise en Place
Logique Métier de l'Application
L'application est divisée en deux microservices principaux : le service de gestion des joueurs et le service de gestion des parties.

Service de Gestion des Joueurs :

Objectif : Gérer les informations des joueurs, leurs amis et leur historique de statistiques.
Fonctionnalités :
Ajouter, modifier, supprimer un joueur.
Récupérer les informations et les statistiques d’un joueur.
Ajouter et gérer les amis d’un joueur.
Logique :
Les joueurs peuvent être ajoutés avec des informations de base telles que le nom, le pseudonyme, l'email, le niveau et les points totaux.
Les joueurs peuvent avoir plusieurs amis (relation One-to-Many).
Les statistiques des joueurs sont mises à jour après chaque partie via un appel REST depuis le service de gestion des parties.
Service de Gestion des Parties :

Objectif : Gérer les informations des parties et l’enregistrement des performances des joueurs.
Fonctionnalités :
Créer, modifier et supprimer une partie.
Récupérer les informations d’une partie spécifique.
Enregistrer la participation d’un joueur et son score.
Logique :
Les parties sont jouées par plusieurs joueurs (relation Many-to-Many via la table Participation).
Les performances des joueurs sont enregistrées après chaque partie et les statistiques sont mises à jour via un appel REST au service de gestion des joueurs.
Décisions Prises et Justifications
Utilisation de Microservices :

Décision : Diviser l'application en deux microservices (gestion des joueurs et gestion des parties).
Justification : Cette approche permet de séparer les responsabilités et de rendre l'application plus modulaire et évolutive. Chaque microservice peut être développé, déployé et mis à jour indépendamment.
Communication via API REST :

Décision : Utiliser des appels REST pour la communication entre les microservices.
Justification : Les API REST sont simples à implémenter et à utiliser, et elles permettent une communication claire et standardisée entre les services.
Structure de la Base de Données :

Décision : Utiliser une base de données relationnelle avec des tables pour les joueurs, les amis, les parties, les participations et les types de parties.
Justification : La structure relationnelle permet de modéliser efficacement les relations entre les entités et de garantir l'intégrité des données.
Définition de la Base de Données
Schéma de la Base de Données
Tables et Relations
Table Joueur :

id (Primary Key)
nom
pseudonyme
email
niveau
pointsTotaux
Table Ami :

id (Primary Key)
idJoueur (Foreign Key référençant Joueur(id))
idAmi (Foreign Key référençant Joueur(id))
Table Partie :

id (Primary Key)
date
scoreMax
idHote (Foreign Key référençant Joueur(id))
idTypePartie (Foreign Key référençant TypePartie(id))
Table Participation :

id (Primary Key)
idPartie (Foreign Key référençant Partie(id))
idJoueur (Foreign Key référençant Joueur(id))
score
victoire
Table TypePartie :

id (Primary Key)
nom
nombreJoueur
Justification de la Structure
Modélisation des Relations :

La relation One-to-Many entre Joueur et Ami permet de gérer efficacement les amis d'un joueur.
La relation Many-to-Many entre Partie et Joueur via la table Participation permet de gérer les participations des joueurs aux parties.
La table TypePartie permet de définir différents types de parties avec des règles spécifiques.
Intégrité des Données :

Les clés étrangères garantissent l'intégrité référentielle entre les tables.
Les contraintes de non-nullité et les types de données appropriés assurent la validité des données.

***Explication Détaillée du Fonctionnement***

**Workflow de l'Application**
Création d'un Joueur :

L'utilisateur envoie une requête POST à /joueurs avec les informations du joueur.
Le service de gestion des joueurs crée un nouveau joueur et le sauvegarde dans la base de données.
Création d'une Partie :

L'utilisateur envoie une requête POST à /parties avec les informations de la partie.
Le service de gestion des parties crée une nouvelle partie et la sauvegarde dans la base de données.
Enregistrement des Participations :

Après la fin d'une partie, les scores des joueurs sont enregistrés via une requête POST à /parties/{partieId}/participations.
Le service de gestion des parties enregistre les participations et met à jour les statistiques des joueurs via un appel REST au service de gestion des joueurs.
Mise à Jour des Statistiques des Joueurs :

Le service de gestion des parties envoie une requête POST à /joueurs/{joueurId}/statistiques avec les nouvelles statistiques.
Le service de gestion des joueurs met à jour les statistiques du joueur dans la base de données.

***Interaction entre les Composants***

Backend :

Les contrôleurs gèrent les requêtes HTTP et interagissent avec les services pour traiter les demandes.
Les services contiennent la logique métier et interagissent avec les DAOs pour accéder aux données.
Les DAOs utilisent les repositories Spring Data JPA pour interagir avec la base de données.

Base de Données :

La base de données stocke les informations des joueurs, des parties, des participations et des types de parties.
Les relations entre les tables garantissent l'intégrité des données et permettent de modéliser efficacement les interactions entre les entités.

![alt text](/Img/Diagramme de classe.png)