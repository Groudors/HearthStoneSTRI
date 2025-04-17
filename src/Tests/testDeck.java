package Tests;
import gestionCartes.*;
import Cartes.*;

public class testDeck {
	public static void main(String[] args) {
		listeCartes Test= new listeCartes();
		Deck deck= new Deck();
		Test.creeInstanceServiteur();
		deck.creerDeck(Test);
		
	}
}
