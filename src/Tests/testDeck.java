package Tests;
import gestionCartes.*;
import utilisationCarte.CombatServiteurs;
import Cartes.*;
import deroulementPartie.*;

public class testDeck {
	public static void main(String[] args) {
		listeCartes Test= new listeCartes();
		Deck deck= new Deck();
		
		Test.creeInstanceServiteur();
		deck.creerDeck(Test);
		
		//CombatServiteurs combat= new CombatServiteurs();
		//combat.ChoixServiteurs(deck);
		
		Joueur joueur= new Joueur(deck);
		System.out.println(joueur.getHero().getNom());
		
		
	}
}
