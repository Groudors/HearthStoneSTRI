package Tests;
import gestionCartes.*;
import utilisationCarte.CombatServiteurs;
import Cartes.*;

public class testDeck {
	public static void main(String[] args) {
		listeCartes Test= new listeCartes();
		Deck deck= new Deck();
		Test.creeInstanceServiteur();
		deck.creerDeck(Test);
		CombatServiteurs combat= new CombatServiteurs();
		combat.ChoixServiteurs(deck);
		
		
	}
}
