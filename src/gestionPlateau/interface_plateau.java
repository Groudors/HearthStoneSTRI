package gestionPlateau;

import deroulementPartie.Joueur;
import Cartes.Serviteur;
import Cartes.Carte;
import java.util.List;

public class interface_plateau {

    public static void afficherPlateau(Joueur joueur1, Joueur joueur2) {
        System.out.println("==============================================");
        System.out.println("                PLATEAU DE JEU                ");
        System.out.println("==============================================");

        afficherJoueur("Joueur 1 (Gauche)", joueur1);
        System.out.println("----------------------------------------------");
        afficherJoueur("Joueur 2 (Droite)", joueur2);
        System.out.println("==============================================\n");
    }

    private static void afficherJoueur(String titre, Joueur joueur) {
        System.out.println(titre + " - Héros : " + joueur.getHero().getNom());
        System.out.println("Vie : " + joueur.getHero().getVie() + " | Mana : " + joueur.getHero().getManaActuel());
        System.out.println("Cartes sur le terrain :");
        List<Serviteur> board = joueur.getBoard();
        if (board.isEmpty()) {
            System.out.println("  (Aucun serviteur)");
        } else {
            for (int i = 0; i < board.size(); i++) {
                Serviteur s = board.get(i);
                System.out.println("  [" + (i+1) + "] " + s.getNom() + " (HP: " + s.getHP() + ", Dégâts: " + s.getDegats() + ", Mana: " + s.getCoutMana() + ")");
            }
        }
        System.out.println("Cartes en main :");
        List<Carte> main = joueur.getHand();
        if (main.isEmpty()) {
            System.out.println("  (Aucune carte)");
        } else {
            for (int i = 0; i < main.size(); i++) {
                Carte c = main.get(i);
                System.out.println("  [" + (i+1) + "] " + c.getNom() + " (Mana: " + c.getCoutMana() + ")");
            }
        }
        System.out.println("Cartes restantes dans le deck : " + joueur.getDeck().getDeckCartes().size());
    }
}
