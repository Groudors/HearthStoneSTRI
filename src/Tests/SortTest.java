package Tests;

import Cartes.Serviteur;
import Cartes.Sort;
import deroulementPartie.Joueur;
import gestionCartes.Deck;
import gestionEffets.Effet;
import gestionEffets.EffetDegats;
import heros.Hero;

public class SortTest {
    public static void main(String[] args) {
        testJouerSortSurServiteur();
        testJouerSortSurHero();
        testJouerSortPasAssezMana();
    }

    static void testJouerSortSurServiteur() {
        Deck deck = new Deck();
        Joueur joueur = new Joueur(deck);
        Joueur adversaire = new Joueur(deck);

        Serviteur cible = new Serviteur("Cible", 2, 2, 2, null);
        adversaire.getBoard().add(cible);

        Effet effet = new EffetDegats(2);
        Sort sort = new Sort("Boule de Feu", 1, effet);
        joueur.getHand().add(sort);
        joueur.getHero().setManaActuel(10);

        boolean result = joueur.jouerSort(0, cible);

        System.out.println("testJouerSortSurServiteur: " + (result && cible.getHP() == 0 && joueur.getHand().isEmpty() ? "OK" : "ECHEC"));
    }

    static void testJouerSortSurHero() {
        Deck deck = new Deck();
        Joueur joueur = new Joueur(deck);
        Joueur adversaire = new Joueur(deck);

        Effet effet = new EffetDegats(3);
        Sort sort = new Sort("Frappe héroïque", 2, effet);
        joueur.getHand().add(sort);
        joueur.getHero().setManaActuel(10);

        Hero cible = adversaire.getHero();
        int hpAvant = cible.getVie();

        boolean result = joueur.jouerSort(0, cible);

        System.out.println("testJouerSortSurHero: " + (result && cible.getVie() == hpAvant - 3 && joueur.getHand().isEmpty() ? "OK" : "ECHEC"));
    }

    static void testJouerSortPasAssezMana() {
        Deck deck = new Deck();
        Joueur joueur = new Joueur(deck);

        Effet effet = new EffetDegats(2);
        Sort sort = new Sort("Petit sort", 5, effet);
        joueur.getHand().add(sort);
        joueur.getHero().setManaActuel(2);

        boolean result = joueur.jouerSort(0, joueur.getHero());

        System.out.println("testJouerSortPasAssezMana: " + (!result && !joueur.getHand().isEmpty() ? "OK" : "ECHEC"));
    }
}