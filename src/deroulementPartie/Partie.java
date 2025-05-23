package deroulementPartie;
import gestionCartes.*;
import gestionEffets.Cible;
import utilisationCarte.*;
import Cartes.*;
import Utilitaire.Clavier;
import heros.*;

public class Partie {

    public static void sortCible(Joueur joueur, Joueur adversaire) {
        // Affichage des sorts dans la main
        System.out.println("Votre main :");
        for (int i = 0; i < joueur.getHand().size(); i++) {
            Carte carte = joueur.getHand().get(i);
            if (carte instanceof Sort) {
                System.out.println((i+1) + " : " + carte.presentationCarte());
            }
        }
        System.out.print("Choisissez l'index du sort à jouer (ou 0 pour annuler) : ");
        int indexSort = Clavier.entrerClavierInt() - 1;
        if (indexSort < 0 || indexSort >= joueur.getHand().size() || !(joueur.getHand().get(indexSort) instanceof Sort)) {
            System.out.println("Choix invalide ou annulé.");
            return;
        }

        // Choix de la cible
        System.out.println("Choisissez la cible :");
        System.out.println("0 : Héros adverse (" + adversaire.getHero().getNom() + ")");
        for (int i = 0; i < adversaire.getBoard().size(); i++) {
            Serviteur s = adversaire.getBoard().get(i);
            System.out.println((i+1) + " : Serviteur adverse (" + s.getNom() + ", HP: " + s.getHP() + ")");
        }
        int choixCible = Clavier.entrerClavierInt();

        Cible cible;
        if (choixCible == 0) {
            cible = adversaire.getHero();
        } else if (choixCible > 0 && choixCible <= adversaire.getBoard().size()) {
            cible = adversaire.getBoard().get(choixCible - 1);
        } else {
            System.out.println("Cible invalide.");
            return;
        }

        boolean res = joueur.jouerSort(indexSort, cible);
        if (!res) {
            System.out.println("Le sort n'a pas pu être joué.");
        }
}
}
