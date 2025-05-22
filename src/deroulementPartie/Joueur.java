package deroulementPartie;
import heros.*;

import java.util.ArrayList;
import java.util.*;

import Cartes.*;
import gestionCartes.*;

public class Joueur {
    private Hero hero;
    private Deck deck;
    private List<Carte> main = new ArrayList<>();
    private List<Serviteur> terrain = new ArrayList<>();

    public Joueur(Deck deck) {
    	this.hero = new Hero(); 
        this.deck = deck;
    }

    public Hero getHero() { return hero; }
    public List<Carte> getHand() { return main; }
    public List<Serviteur> getBoard() { return terrain; }
    public int getMana() { return hero.getManaActuel(); }
    public void utiliserMana(int amount) { hero.utiliseMana(amount); }
    
   public boolean tirerCarte() {
    Carte carte = deck.piocherCarte(getMana());
        if (carte != null) {
            utiliserMana(carte.getCoutMana());
            main.add(carte);
            return true;
        }
        return false;
    }

    public void distribuerCartesInitialesPremierJoueur() {
        for (int i = 0; i < 3; i++) {
            tirerCarte();
        }
    }

    public void distribuerCartesInitialesSecondJoueur() {
        for (int i = 0; i < 4; i++) {
            tirerCarte();
        }
    }

    public void commencerTour() {
    hero.debutTour();
    tirerCarte();
    }

public void attaquerServiteur(int indexAttaquant, Joueur adversaire, int indexDefenseur) {
    if (indexAttaquant < 0 || indexAttaquant >= terrain.size()) {
        System.out.println("Aucun serviteur à cette position sur votre terrain !");
        return;
    }
    if (indexDefenseur < 0 || indexDefenseur >= adversaire.getBoard().size()) {
        System.out.println("Aucun serviteur à cette position sur le terrain adverse !");
        return;
    }
    Serviteur attaquant = terrain.get(indexAttaquant);
    Serviteur defenseur = adversaire.getBoard().get(indexDefenseur);

    defenseur.prendreDegats(attaquant.getDegats());
    attaquant.prendreDegats(defenseur.getDegats());

    if (defenseur.getHP() <= 0) adversaire.getBoard().remove(indexDefenseur);
    if (attaquant.getHP() <= 0) terrain.remove(indexAttaquant);
}

    public void attaquerHero(int indexAttaquant, Joueur adversaire) {
        if (!adversaire.getBoard().isEmpty()) {
            System.out.println("Vous ne pouvez pas attaquer le héros tant qu'il y a des serviteurs !");
            return;
        }
        Serviteur attaquant = terrain.get(indexAttaquant);
        adversaire.getHero().prendreDegats(attaquant.getDegats());
    }

    public boolean invoquerServiteur(int indexMain) {
        if (indexMain < 0 || indexMain >= main.size()) return false;
        Carte carte = main.get(indexMain);
        if (!(carte instanceof Serviteur)) return false;
        if (getMana() < carte.getCoutMana()) return false;
        utiliserMana(carte.getCoutMana());
        terrain.add((Serviteur) carte);
        main.remove(indexMain);
        return true;
    }

    /**
     * Permet au joueur de jouer une carte Arme depuis sa main.
     * @param indexMain L'index de la carte dans la main
     * @return true si l'arme a été jouée et équipée, false sinon
     */
    public boolean jouerArme(int indexMain) {
        if (indexMain < 0 || indexMain >= main.size()) return false;
        Carte carte = main.get(indexMain);
        if (!(carte instanceof Arme)) return false;
        if (getMana() < carte.getCoutMana()) {
            System.out.println("Pas assez de mana pour jouer cette arme !");
            return false;
        }
        utiliserMana(carte.getCoutMana());
        Arme arme = (Arme) carte;
        hero.equiperArme(arme);
        main.remove(indexMain);
        System.out.println("Vous avez équipé l'arme : " + arme.getNom());
        return true;
    }

    // Dans Joueur.java
    public boolean getDeckIsEmpty() {
    return deck.getDeckCartes().isEmpty();
}
public Deck getDeck() {
    return deck;
}

    /**
     * Permet au héros d'attaquer un serviteur adverse avec son arme.
     * @param adversaire Le joueur adverse
     * @param indexServiteur L'index du serviteur adverse à attaquer
     * @return true si l'attaque a eu lieu, false sinon
     */
    public boolean attaquerAvecArmeServiteur(Joueur adversaire, int indexServiteur) {
        Arme arme = hero.getArme();
        if (arme == null) {
            System.out.println("Aucune arme équipée !");
            return false;
        }
        if (indexServiteur < 0 || indexServiteur >= adversaire.getBoard().size()) {
            System.out.println("Aucun serviteur à cette position !");
            return false;
        }
        Serviteur cible = adversaire.getBoard().get(indexServiteur);
        arme.AttaquerServiteur(cible);
        System.out.println("Le héros attaque " + cible.getNom() + " avec son arme (" + arme.getNom() + ") !");
        if (cible.getHP() <= 0) {
            adversaire.getBoard().remove(indexServiteur);
            System.out.println(cible.getNom() + " est détruit !");
        }
        if (arme.estCassee()) {
            System.out.println("L'arme est cassée !");
        }
        return true;
    }

    /**
     * Permet au héros d'attaquer le héros adverse avec son arme.
     * @param adversaire Le joueur adverse
     * @return true si l'attaque a eu lieu, false sinon
     */
    public boolean attaquerAvecArmeHero(Joueur adversaire) {
        Arme arme = hero.getArme();
        if (arme == null) {
            System.out.println("Aucune arme équipée !");
            return false;
        }
        if (!adversaire.getBoard().isEmpty()) {
            System.out.println("Impossible d'attaquer le héros adverse tant qu'il reste des serviteurs !");
            return false;
        }
        arme.AttaquerHero(adversaire.getHero());
        System.out.println("Le héros attaque le héros adverse avec son arme (" + arme.getNom() + ") !");
        if (adversaire.getHero().estMort()) {
            System.out.println("Le héros adverse est vaincu !");
        }
        if (arme.estCassee()) {
            System.out.println("L'arme est cassée !");
        }
        return true;
    }
}
