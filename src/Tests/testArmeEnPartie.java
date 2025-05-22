package Tests;

import gestionCartes.*;
import deroulementPartie.*;
import Cartes.*;
import Utilitaire.Clavier;

public class testArmeEnPartie {
    public static void main(String[] args) {
        // Création des decks et des cartes
        listeCartes liste = new listeCartes();
        liste.creeInstanceCarte();

        // Création d'un deck pour chaque joueur
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        // Ajout manuel d'une arme et d'un serviteur pour le joueur 1
        Arme arme = new Arme("Lame runique horrible", 3, 2, 2);
        Serviteur serviteur1 = new Serviteur("Acolyte squelletique", 2, 1, 1);
        deck1.ajouterCarteDeck(arme);
        deck1.ajouterCarteDeck(serviteur1);

        // Ajout d'un serviteur pour le joueur 2
        Serviteur serviteur2 = new Serviteur("Tank zombie titubant", 3, 2, 2);
        deck2.ajouterCarteDeck(serviteur2);

        // Création des joueurs
        Joueur joueur1 = new Joueur(deck1);
        Joueur joueur2 = new Joueur(deck2);

        // Distribution des cartes (on force la main pour le test)
        joueur1.tirerCarte(); // Arme
        joueur1.tirerCarte(); // Serviteur
        joueur2.tirerCarte(); // Serviteur

        // Joueur 1 équipe l'arme
        System.out.println("\n--- Joueur 1 équipe son arme ---");
        int indexArme = -1;
        for (int i = 0; i < joueur1.getHand().size(); i++) {
            if (joueur1.getHand().get(i) instanceof Arme) {
                indexArme = i;
                break;
            }
        }
        if (indexArme != -1) {
            joueur1.jouerArme(indexArme);
        } else {
            System.out.println("Aucune arme en main !");
            return;
        }

        // Joueur 2 invoque son serviteur sur le terrain
        joueur2.invoquerServiteur(0);

        // Joueur 1 attaque le serviteur adverse avec son arme
        System.out.println("\n--- Joueur 1 attaque le serviteur adverse avec son arme ---");
        joueur1.attaquerAvecArmeServiteur(joueur2, 0);

        // Affichage de l'état final
        System.out.println("\nEtat final :");
        System.out.println("PV du serviteur adverse : " + (joueur2.getBoard().isEmpty() ? "Mort" : joueur2.getBoard().get(0).getHP()));
        System.out.println("Durabilité de l'arme de Joueur 1 : " + (joueur1.getHero().getArme() != null ? joueur1.getHero().getArme().getDurabilite() : "Aucune arme équipée"));
    }
}