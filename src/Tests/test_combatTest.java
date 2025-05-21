import gestionCartes.*;
import utilisationCarte.CombatServiteurs;
import Cartes.*;
import deroulementPartie.*;
import heros.*;
import Utilitaire.Clavier;

// Java
package Tests;


public class test_combat {
    public static void main(String[] args) {
        // Initialisation des cartes et du deck
        listeCartes liste = new listeCartes();
        liste.creeInstanceServiteur();
        Deck deck = new Deck();
        deck.creerDeck(liste);

        // Création du joueur (choix du héros inclus)
        Joueur joueur = new Joueur(deck);
        System.out.println("Votre héros est : " + joueur.getHero().getNom());

        // Vérification du nombre de serviteurs dans le deck
        if (deck.getDeckCartes().size() < 2) {
            System.out.println("Il faut au moins 2 serviteurs dans le deck pour lancer un combat.");
            return;
        }

        // Affichage des serviteurs du deck
        System.out.println("Voici vos serviteurs dans le deck :");
        int i = 1;
        for (Serviteur s : deck.getDeckCartes()) {
            System.out.println(i + ". " + s.getNom() + " (HP: " + s.getHP() + ", Dégâts: " + s.getDegats() + ")");
            i++;
        }

        // Choix des deux serviteurs pour le combat
        System.out.print("Choisissez le numéro du premier serviteur pour le combat : ");
        int idx1 = Clavier.entrerClavierInt() - 1;
        while (idx1 < 0 || idx1 >= deck.getDeckCartes().size()) {
            System.out.print("Numéro invalide, recommencez : ");
            idx1 = Clavier.entrerClavierInt() - 1;
        }

        System.out.print("Choisissez le numéro du second serviteur pour le combat : ");
        int idx2 = Clavier.entrerClavierInt() - 1;
        while (idx2 < 0 || idx2 >= deck.getDeckCartes().size() || idx2 == idx1) {
            System.out.print("Numéro invalide ou identique au premier, recommencez : ");
            idx2 = Clavier.entrerClavierInt() - 1;
        }

        Serviteur s1 = deck.getDeckCartes().get(idx1);
        Serviteur s2 = deck.getDeckCartes().get(idx2);

        System.out.println("Combat entre " + s1.getNom() + " et " + s2.getNom() + " !");
        CombatServiteurs combat = new CombatServiteurs();
        combat.AffrontementDeuxServiteurs(s1, s2);

        System.out.println("Fin du combat.");
    }
}