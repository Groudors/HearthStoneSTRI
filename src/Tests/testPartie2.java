package Tests;

import gestionCartes.*;
import deroulementPartie.*;
import Utilitaire.Clavier;
import Cartes.*;

public class testPartie2 {
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

        // Distribution initiale
        joueur1.distribuerCartesInitialesPremierJoueur();
        joueur2.distribuerCartesInitialesSecondJoueur();

        System.out.println("=== Début de la partie ===");
        System.out.println("Main joueur 1 : " + joueur1.getHand().size());
        System.out.println("Main joueur 2 : " + joueur2.getHand().size());

        int tour = 1;
        boolean partieFinie = false;
        while (!partieFinie) {
            System.out.println("\n--- Tour " + tour + " : Joueur 1 ---");
            joueur1.commencerTour();
            System.out.println("Mana joueur 1 : " + joueur1.getMana());
            // Invocation automatique du premier serviteur possible
            for (int i = 0; i < joueur1.getHand().size(); i++) {
                if (joueur1.invoquerServiteur(i)) {
                    System.out.println("Joueur 1 invoque : " + joueur1.getBoard().get(joueur1.getBoard().size()-1).getNom());
                    break;
                }
            }
            // Attaque automatique
            for (int i = 0; i < joueur1.getBoard().size(); i++) {
                if (!joueur2.getBoard().isEmpty()) {
                    joueur1.attaquerServiteur(i, joueur2, 0);
                    System.out.println("Joueur 1 attaque un serviteur de Joueur 2 !");
                } else {
                    joueur1.attaquerHero(i, joueur2);
                    System.out.println("Joueur 1 attaque le héros de Joueur 2 !");
                    if (joueur2.getHero().getVie() <= 0) {
                        System.out.println("Joueur 1 a gagné !");
                        partieFinie = true;
                        break;
                    }
                }
            }
            if (partieFinie) break;

            System.out.println("\n--- Tour " + tour + " : Joueur 2 ---");
            joueur2.commencerTour();
            System.out.println("Mana joueur 2 : " + joueur2.getMana());
            for (int i = 0; i < joueur2.getHand().size(); i++) {
                if (joueur2.invoquerServiteur(i)) {
                    System.out.println("Joueur 2 invoque : " + joueur2.getBoard().get(joueur2.getBoard().size()-1).getNom());
                    break;
                }
            }
            for (int i = 0; i < joueur2.getBoard().size(); i++) {
                if (!joueur1.getBoard().isEmpty()) {
                    joueur2.attaquerServiteur(i, joueur1, 0);
                    System.out.println("Joueur 2 attaque un serviteur de Joueur 1 !");
                } else {
                    joueur2.attaquerHero(i, joueur1);
                    System.out.println("Joueur 2 attaque le héros de Joueur 1 !");
                    if (joueur1.getHero().getVie() <= 0) {
                        System.out.println("Joueur 2 a gagné !");
                        partieFinie = true;
                        break;
                    }
                }
            }

            // Condition d'arrêt supplémentaire : plus de cartes à jouer et plus de serviteurs
            boolean joueur1Bloque = joueur1.getHand().isEmpty() && joueur1.getBoard().isEmpty() && joueur1.getDeck().isEmpty();
            boolean joueur2Bloque = joueur2.getHand().isEmpty() && joueur2.getBoard().isEmpty() && joueur2.getDeck().isEmpty();
            if (joueur1Bloque && joueur2Bloque) {
                System.out.println("Plus aucun joueur ne peut jouer. Match nul !");
                break;
            }

            tour++;
            // Affichage état
            System.out.println("PV héros joueur 1 : " + joueur1.getHero().getVie());
            System.out.println("PV héros joueur 2 : " + joueur2.getHero().getVie());
            System.out.println("Serviteurs joueur 1 : " + joueur1.getBoard().size());
            System.out.println("Serviteurs joueur 2 : " + joueur2.getBoard().size());
        }
        System.out.println("\n=== Fin de la partie ===");
    }
}