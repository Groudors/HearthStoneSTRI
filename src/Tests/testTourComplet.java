package Tests;

import gestionCartes.*;
import deroulementPartie.*;
import Cartes.*;
import Utilitaire.Clavier;

public class testTourComplet {
    public static void main(String[] args) {
        // Création des decks et des cartes
        listeCartes liste = new listeCartes();
        liste.creeInstanceCarte();

        // Création d'un deck pour chaque joueur
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        // Ajout de cartes variées pour le joueur 1
        Arme arme = new Arme("Lame runique", 3, 2, 2);
        Serviteur serviteur1 = new Serviteur("Acolyte squelletique", 2, 1, 1, null);
        Sort sort = new Sort("Boule de feu", 4, new gestionEffets.EffetDegats(3));
        deck1.ajouterCarteDeck(arme);
        deck1.ajouterCarteDeck(serviteur1);
        deck1.ajouterCarteDeck(sort);

        // Ajout d'un serviteur pour le joueur 2
        Serviteur serviteur2 = new Serviteur("Tank zombie", 3, 2, 2, null);
        deck2.ajouterCarteDeck(serviteur2);

        // Création des joueurs
        Joueur joueur1 = new Joueur(deck1);
        Joueur joueur2 = new Joueur(deck2);

        // Distribution des cartes (on force la main pour le test)
        joueur1.tirerCarte(); // Arme
        joueur1.tirerCarte(); // Serviteur
        joueur1.tirerCarte(); // Sort
        joueur2.tirerCarte(); // Serviteur

        // Joueur 2 invoque son serviteur sur le terrain
        joueur2.invoquerServiteur(0);

        // Début du tour du joueur 1
        System.out.println("\n--- Début du tour du Joueur 1 ---");
        System.out.println("Mana disponible : " + joueur1.getMana());

        System.out.println("\nVotre main :");
        for (int i = 0; i < joueur1.getHand().size(); i++) {
            Carte carte = joueur1.getHand().get(i);
            System.out.println((i+1) + ". " + carte.presentationCarte());
        }
        System.out.println("Entrez le numéro de la carte à jouer (ou 0 pour passer) :");
        int choix = Clavier.entrerClavierInt() - 1;

        if (choix >= 0 && choix < joueur1.getHand().size()) {
            Carte carteChoisie = joueur1.getHand().get(choix);

            if (carteChoisie instanceof Serviteur) {
                if (joueur1.invoquerServiteur(choix)) {
                    System.out.println("Vous avez invoqué : " + carteChoisie.getNom());
                } else {
                    System.out.println("Impossible d'invoquer ce serviteur.");
                }
            } else if (carteChoisie instanceof Arme) {
                if (joueur1.jouerArme(choix)) {
                    System.out.println("Vous avez équipé l'arme : " + carteChoisie.getNom());
                    // Affichage de l'effet de l'arme
                    System.out.println("Effet de l'arme : " + ((Arme)carteChoisie).presentationCarte());
                } else {
                    System.out.println("Impossible d'équiper cette arme.");
                }
            } else if (carteChoisie instanceof Sort) {
                Sort sortChoisi = (Sort) carteChoisie;
                System.out.println("Sur qui voulez-vous lancer le sort ?");
                System.out.println("1. Votre héros");
                System.out.println("2. Héros adverse");
                System.out.println("3. Un de vos serviteurs");
                System.out.println("4. Un serviteur adverse");
                int cible = Clavier.entrerClavierInt();
                switch (cible) {
                    case 1:
                        sortChoisi.activerEffet(joueur1.getHero());
                        break;
                    case 2:
                        sortChoisi.activerEffet(joueur2.getHero());
                        break;
                    case 3:
                        if (joueur1.getBoard().isEmpty()) {
                            System.out.println("Aucun serviteur sur votre terrain.");
                            break;
                        }
                        System.out.println("Choisissez le numéro du serviteur :");
                        for (int i = 0; i < joueur1.getBoard().size(); i++) {
                            System.out.println((i+1) + ". " + joueur1.getBoard().get(i).getNom());
                        }
                        int idxServ = Clavier.entrerClavierInt() - 1;
                        if (idxServ >= 0 && idxServ < joueur1.getBoard().size()) {
                            sortChoisi.activerEffet(joueur1.getBoard().get(idxServ));
                        }
                        break;
                    case 4:
                        if (joueur2.getBoard().isEmpty()) {
                            System.out.println("Aucun serviteur sur le terrain adverse.");
                            break;
                        }
                        System.out.println("Choisissez le numéro du serviteur adverse :");
                        for (int i = 0; i < joueur2.getBoard().size(); i++) {
                            System.out.println((i+1) + ". " + joueur2.getBoard().get(i).getNom());
                        }
                        int idxAdv = Clavier.entrerClavierInt() - 1;
                        if (idxAdv >= 0 && idxAdv < joueur2.getBoard().size()) {
                            sortChoisi.activerEffet(joueur2.getBoard().get(idxAdv));
                        }
                        break;
                    default:
                        System.out.println("Cible invalide.");
                }
                joueur1.utiliserMana(carteChoisie.getCoutMana());
                joueur1.getHand().remove(choix);
                System.out.println("Vous avez joué le sort : " + carteChoisie.getNom());
                // Affichage de l'effet du sort (correction ici)
                System.out.println("Effet du sort : " + sortChoisi.presentationCarte());
            }
        } else if (choix != -1) {
            System.out.println("Choix invalide.");
        }

        // Affichage de l'état après action
        System.out.println("\n--- Etat après action ---");
        System.out.println("Votre terrain :");
        for (Serviteur s : joueur1.getBoard()) {
            System.out.println("- " + s.getNom() + " (" + s.getHP() + " PV)");
        }
        System.out.println("Arme équipée : " + (joueur1.getHero().getArme() != null ? joueur1.getHero().getArme().getNom() : "Aucune"));
        System.out.println("Serviteurs adverses :");
        for (Serviteur s : joueur2.getBoard()) {
            System.out.println("- " + s.getNom() + " (" + s.getHP() + " PV)");
        }
        System.out.println("PV héros adverse : " + joueur2.getHero().getVie());
    }
}