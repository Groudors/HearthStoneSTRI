package Tests;
import gestionCartes.*;
import Cartes.*;

public class testDeck {
	public static void main(String[] args) {
		listeCartes Test= new listeCartes();
		Test.creeInstanceServiteur();
		System.out.println(Test.montrerServiteurs());
	}
}
