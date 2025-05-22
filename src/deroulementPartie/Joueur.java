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
    Serviteur carte = deck.piocherCarte(getMana());
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

    defenseur.subirDegats(attaquant.getDegats());
    attaquant.subirDegats(defenseur.getDegats());

    if (defenseur.getHP() <= 0) adversaire.getBoard().remove(indexDefenseur);
    if (attaquant.getHP() <= 0) terrain.remove(indexAttaquant);
}

    public void attaquerHero(int indexAttaquant, Joueur adversaire) {
        if (!adversaire.getBoard().isEmpty()) {
            System.out.println("Vous ne pouvez pas attaquer le héros tant qu'il y a des serviteurs !");
            return;
        }
        Serviteur attaquant = terrain.get(indexAttaquant);
        adversaire.getHero().prendreDgt(attaquant.getDegats());
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

    // Dans Joueur.java
    public boolean getDeckIsEmpty() {
    return deck.getDeckCartes().isEmpty();
}
public Deck getDeck() {
    return deck;
}
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
