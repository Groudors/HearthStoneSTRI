package deroulementPartie;
import heros.*;

import java.util.ArrayList;
import java.util.*;

import Cartes.*;
import gestionCartes.*;

class Joueur {
    private Hero hero;
    private List<Carte> deck;
    private List<Carte> main = new ArrayList<>();
    private List<Serviteur> terrain = new ArrayList<>();

    public Joueur(Hero hero, List<Carte> deck) {
        this.hero = hero;
        this.deck = new ArrayList<>(deck);
        Collections.shuffle(this.deck);
    }

    public Hero getHero() { return hero; }
    public List<Carte> getHand() { return main; }
    public List<Serviteur> getBoard() { return terrain; }
    public int getMana() { return hero.getManaActuel(); }
    public void decreaseMana(int amount) { hero.useMana(amount); }

    public boolean tirerCarte() {
        if (!deck.isEmpty()) {
        	main.add(deck.remove(0));
        	return true;
        }
		return false;
    }

    public void commencerTour() {
        hero.debutTour();
        tirerCarte();
    }
/*
    public void playCard(int index, Joueur opponent) {
        if (index < hand.size()) {
            Carte card = hand.get(index);
            card.play(this, opponent);
            hand.remove(index);
        }
    }
    */
}