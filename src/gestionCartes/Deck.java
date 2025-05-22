package gestionCartes;
import java.util.ArrayList;
import java.util.Collections;

import Utilitaire.*;
import java.util.List;
import Cartes.*;


/**
 * Représente un deck de cartes de type {Serviteur} que le joueur peut constituer pour jouer.
 * Un deck peut contenir jusqu'à 30 cartes maximum pour l'instant
 * Cette classe permet d'ajouter des cartes, d'afficher le deck, et de construire un deck via le clavier.
 * 
 * @author Virgile B
 */
public class Deck {
	/*Maximum de 30 cartes par deck */

	private List<Carte> DeckCartes = new ArrayList<>(30);
	private int Id;

	/**
     * Ajoute un serviteur au deck actuel.
     * 
     * @param carte Le serviteur à ajouter
     */
	public void ajouterCarteDeck(Carte carte) {
		this.DeckCartes.add(carte);
        }
	
	 /**
     * Retourne la liste complète des serviteurs du deck.
     * 
     * @return La liste des serviteurs du deck
     */
	public List<Carte> getDeckCartes() {
		return DeckCartes;
	}
	
	/**
     * Retourne une chaîne lisible représentant le contenu actuel du deck.
     * @return Une description des cartes contenues dans le deck
     */
	public String afficherDeck() {
		String message="";
		message +="| Votre deck est le suivant :\n";
		int i = 1;
		for (Carte carte : DeckCartes) {
			message += "- " + i + " " + carte.presentationCarte()+". \n";
			i++;
		}
		return message;
	}
	
	public void melanger() {
		//A Faire
		
	}
	
	/**
     * Permet à l'utilisateur de créer un deck de 30 cartes à partir d'une liste de cartes disponibles.
     * L'utilisateur sélectionne les cartes via le clavier. Il peut s'arrêter à tout moment avec l'entrée 0.
     * 
     * @param liste La source de cartes disponibles pour composer le deck
     */
	public listeCartes creerDeck(listeCartes liste) {
		String message="";
		int i=1;
		int numType;
		message+=("|----                  Bienvenue dans la Création de Deck                          ---- \n");
		message+=("|                 Vous pouvez choisir parmis les cartes suivantes                   \n");
		message+=liste.montrerCartes();
		System.out.println(message);
		
		while (DeckCartes.size()<30) {
			System.out.println("|              Veuillez choisir la carte " + i +"  0 pour sortir de la création de Deck          \n");
			numType = Clavier.entrerClavierInt();
			while((numType > liste.getListeCarte().size()) || numType<0) {
				System.out.println("|             Numéro de carte invalide           |\n");
				numType = Clavier.entrerClavierInt();
			}
			if (numType == 0){
				break;
			}
			ajouterCarteDeck(liste.getCarte(numType-1));
			System.out.println(afficherDeck());
			
			}
		System.out.println("Votre deck est complet, vous pouvez maintenant commencer le combat ! ");
		return liste;
		}

		public Carte piocherCarte(int manaActuel){
    	if (!DeckCartes.isEmpty()){
        Carte carte = DeckCartes.get(0);
        if (manaActuel >= carte.getCoutMana()) {
            return DeckCartes.remove(0);
        } else {
            System.out.println("Pas assez de mana pour piocher cette carte (" + carte.getNom() + ").");
        }
    }
    return null;
}
	public boolean isEmpty() {
    return DeckCartes.isEmpty();
}

}
