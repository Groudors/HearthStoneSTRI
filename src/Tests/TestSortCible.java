package Tests;
import deroulementPartie.Joueur;
import gestionCartes.*;
import Cartes.*;
import gestionEffets.*;
import Utilitaire.Clavier;

public class TestSortCible {
public static void main(String[] args) {
        // Création des decks et des joueurs
        listeCartes liste = new listeCartes();
        liste.creeInstanceCarte();

        Deck deck1 = new Deck();
        deck1.ajouterCarteDeck(new Sort("Boule de Feu", 4, new EffetDegats(6)));
        deck1.ajouterCarteDeck(new Sort("Soin Divin", 2, new EffetSoins(4)));
        deck1.ajouterCarteDeck(new Serviteur("Acolyte squelletique", 2, 1, 1, null));
        Joueur joueur1 = new Joueur(deck1);

        Deck deck2 = new Deck();
        deck2.ajouterCarteDeck(new Serviteur("Tank zombie titubant", 3, 2, 2, null));
        Joueur joueur2 = new Joueur(deck2);

        // Distribution des cartes
        joueur1.tirerCarte();
        joueur1.tirerCarte();
        joueur1.tirerCarte();
        joueur2.tirerCarte();

        // Invoquer un serviteur pour chaque joueur
        joueur1.invoquerServiteur(2);
        joueur2.invoquerServiteur(0);

        // Ajouter du mana au joueur 1 pour pouvoir jouer un sort
        joueur1.getHero().setManaActuel(40);

        // Affichage de la main
        System.out.println("Main du joueur 1 :");
        for (int i = 0; i < joueur1.getHand().size(); i++) {
            Carte carte = joueur1.getHand().get(i);
            System.out.println((i+1) + ". " + carte.presentationCarte());
        }

        // Choix du sort
        System.out.print("Choisissez le numéro du sort à jouer : ");
        int indexSort = Clavier.entrerClavierInt() - 1;
        if (indexSort < 0 || indexSort >= joueur1.getHand().size() || !(joueur1.getHand().get(indexSort) instanceof Sort)) {
            System.out.println("Choix invalide.");
            return;
        }

        // Choix de la cible
        System.out.println("Choisissez la cible :");
        System.out.println("1. Héros adverse");
        System.out.println("2. Serviteur adverse");
        int choixCible = Clavier.entrerClavierInt();

        Cible cible = null;
        if (choixCible == 1) {
            cible = joueur2.getHero();
        } else if (choixCible == 2 && !joueur2.getBoard().isEmpty()) {
            cible = joueur2.getBoard().get(0);
        } else {
            System.out.println("Cible invalide.");
            return;
        }

        boolean res = joueur1.jouerSort(indexSort, cible);
        if (res) {
            System.out.println("Sort joué avec succès !");
        } else {
            System.out.println("Le sort n'a pas pu être joué.");
        }
    }
}
