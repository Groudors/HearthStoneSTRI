package deroulementPartie;
import heros.*;

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
    List<Serviteur> cartesDeck = deck.getDeckCartes();
    if (!cartesDeck.isEmpty()) {
        // On pioche la première carte du deck
        Serviteur cartePiochee = cartesDeck.remove(0);
        main.add(cartePiochee);
        System.out.println("Vous piochez : " + cartePiochee.getNom());
        return true;
    }
    System.out.println("Le deck est vide, impossible de piocher !");
    return false;
}
    /*
    public boolean tirerCarte() {
        if (!deck.isEmpty()) {
        	main.add(deck.remove(0));
        	return true;
        }
		return false;
    }

    public void commencerTour() {
        hero.debutTour();
        if (!tirerCarte()) {
        	System.out.println("Vous avez perdu la partie");
        	//A faire
        }
    }

    public void playCard(int index, Joueur opponent) {
        if (index < hand.size()) {
            Carte card = hand.get(index);
            card.play(this, opponent);
            hand.remove(index);
        }
    }
    */
}