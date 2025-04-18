# HearthSTRI
HearthStone version STRI, Projet L3 Java
Présentation

Ce projet Java est une simulation de jeu de cartes inspirée des mécaniques de Hearthstone. 
Le joueur peut pour l'instant :

    - Créer un deck personnalisé à partir d'une liste de cartes,

    - Simuler un combat entre deux serviteurs choisis aléatoirement.

Structure du projet :

/Cartes              --> Classes représentant les cartes (ex: Serviteur.java)
/gestionCartes       --> Deck, listeCartes, etc.
/utilisationCarte    --> Combat entre cartes, future gestion de mana, des effets (sorts, armes et serviteurs) et équipement des objets.
/Utilitaire          --> Classe Clavier (lecture terminal)
/gestionPlateau      --> Pas encore dévelopée, contiendra la gestion graphique du plateau de combat

Fonctionnalités principales :

    - Création d'un deck jusqu'à 30 cartes

    - Sélection d’un serviteur via le clavier

    - Combat automatisé entre deux cartes du deck (avec dégâts / HP)

    - Gestion des points de vie et de la mort d’un serviteur