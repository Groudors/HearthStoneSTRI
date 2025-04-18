package gestionCartes;
import java.util.ArrayList;
import Utilitaire.*;

import java.util.List;

import Cartes.*;

public class Deck {
	/*Maximum de 30 cartes par deck */
	private List<Serviteur> DeckCartes = new ArrayList<>(30);
	private int Id;
	
	public void ajouterCarteDeck(Serviteur ServiteurDeck) {
		this.DeckCartes.add(ServiteurDeck);
        }
	
	public List<Serviteur> getDeckCartes() {
		return DeckCartes;
	}
	
	public String afficherDeck() {
		String message="";
		message +="| Votre deck est le suivante :\n";
		int i = 1;
		for (Serviteur creature : DeckCartes) {
			message += "- " + i + " - " + creature.getNom() + " Force : " + creature.getDégats() + " HP : "+ creature.getHP() + " Mana : " + creature.getMana() + ". \n";
			i++;
		}
		return message;
	}
	
	
	public void creerDeck(listeCartes liste) {
		String message="";
		int i=1;
		int numType;
		message+=("|----                  Bienvenue dans la Création de Deck                          ---- \n");
		message+=("|                 Vous pouvez choisir parmis les cartes suivantes                   \n");
		message+=liste.montrerServiteurs();
		System.out.println(message);
		
		while (DeckCartes.size()<30) {
			System.out.println("|              Veuillez choisir la carte " + i +"  0 pour sortir de la création de Deck          \n");
			numType = Clavier.entrerClavierInt();
			while((numType > liste.getListeServiteurs().size()) || numType<0) {
				System.out.println("|             Numéro de carte invalide           |\n");
				numType = Clavier.entrerClavierInt();
			}
			if (numType == 0){
				break;
			}
			ajouterCarteDeck(liste.getServiteurs(numType-1));
			System.out.println(afficherDeck());
			
			}
		System.out.println("Votre deck est complet, vous pouvez maintenant commencer le combat ! ");
		
		}
}
