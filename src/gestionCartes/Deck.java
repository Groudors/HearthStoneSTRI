package gestionCartes;
import java.util.ArrayList;
import Utilitaire.*;

import java.util.List;

import Cartes.*;

public class Deck {
	/*Maximum de 30 cartes par deck */
	private List<Serviteur> Deck = new ArrayList<>(30);
	private int Id;
	
	public void creerDeck(listeCartes liste) {
		String message="";
		int i=2;
		int numType;
		message+=("|----     Bienvenue dans la Création de Deck     ----|");
		message+=("|  Vous pouvez choisir parmis les cartes suivantes   |");
		message+=liste.montrerServiteurs();
		message+=("|         Veuillez choisir la première carte         |" );
		System.out.println(message);
		while (Deck.size()<30) {
			message+=("|         Veuillez choisir la carte " +i+"       |" );
			numType = Clavier.entrerClavierInt();
			while(!(numType < liste.size() + 1))
				
				return compagnons.get(numero - 1);
			} else {
				return null;
			}
		}
		
		
	}
	
	
	
	public void name() {
		
	}
}
