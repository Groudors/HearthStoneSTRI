package Tests;

import gestionCartes.*;
import utilisationCarte.*;
import Cartes.*;
import deroulementPartie.*;


class testDeck {
	 public static void main(String[] args) {
	        testCreerDeck();
	        testJoueurHeroNom();
	        System.out.println("Tous les tests ont été exécutés avec succès.");
	    }

	    static void testCreerDeck() {
	        listeCartes testCartes = new listeCartes();
	        testCartes.creeInstanceCarte();

	        Deck deck = new Deck();
	        deck.creerDeck(testCartes);

	        assert deck != null : "Le deck n'a pas été créé.";
	        assert !deck.getDeckCartes().isEmpty() : "Le deck est vide.";
	    }

	    static void testJoueurHeroNom() {
	        listeCartes testCartes = new listeCartes();
	        testCartes.creeInstanceCarte();

	        Deck deck = new Deck();
	        deck.creerDeck(testCartes);

	        Joueur joueur = new Joueur(deck);
	        assert joueur.getHero() != null : "Le héros n'a pas été créé.";
	        assert joueur.getHero().getNom() != null : "Le nom du héros est null.";
	    }
}