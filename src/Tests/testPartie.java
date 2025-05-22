package Tests;

import gestionCartes.*;
import deroulementPartie.*;
import Utilitaire.Clavier;

public class testPartie {
    public static void main(String[] args) {
        // Création des decks pour chaque joueur
        listeCartes liste = new listeCartes();
        liste.creeInstanceCarte();

        System.out.println("Création du deck du Joueur 1 :");
        Deck deck1 = new Deck();
        deck1.creerDeck(liste);

        System.out.println("Création du deck du Joueur 2 :");
        Deck deck2 = new Deck();
        deck2.creerDeck(liste);

        // Choix du côté
        System.out.println("Joueur 1, choisissez votre côté (1 = gauche, 2 = droite) : ");
        int coteJ1 = Clavier.entrerClavierInt();
        while (coteJ1 != 1 && coteJ1 != 2) {
            System.out.println("Choix invalide. 1 = gauche, 2 = droite : ");
            coteJ1 = Clavier.entrerClavierInt();
        }
        int coteJ2 = (coteJ1 == 1) ? 2 : 1;

        // Création des joueurs (le choix du héros se fait dans le constructeur)
        Joueur joueur1 = new Joueur(deck1);
        Joueur joueur2 = new Joueur(deck2);

        System.out.println("Joueur 1 (" + (coteJ1 == 1 ? "gauche" : "droite") + ") a choisi le héros : " + joueur1.getHero().getNom());
        System.out.println("Joueur 2 (" + (coteJ2 == 1 ? "gauche" : "droite") + ") a choisi le héros : " + joueur2.getHero().getNom());

        // Ici, on pourrait lancer la partie (non implémenté)
        System.out.println("La partie peut commencer !");
    }
}