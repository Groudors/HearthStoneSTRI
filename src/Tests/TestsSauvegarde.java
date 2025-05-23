package Tests;
import Cartes.*;
import gestionEffets.*;
import gestionPlateau.*;
import heros.*;
import java.util.ArrayList;
import java.util.List;
import gestionCartes.*;
import deroulementPartie.*;


public class TestsSauvegarde {
	public static void main(String[] args) {
        // Initialisation de la liste de cartes disponibles
        listeCartes liste = new listeCartes();
        liste.creeInstanceCarte(); 

        // Création d'un deck
        Deck monDeck = new Deck();

        // Lancement du menu de gestion des decks
        monDeck.gererDeck(liste);

        // Optionnel : tester pioche
        Carte piochee = monDeck.piocherCarte();
        if (piochee != null) {
            System.out.println("Vous avez pioché : " + piochee.presentationCarte());
        } else {
            System.out.println("Le deck est vide !");
        }
    }
}
