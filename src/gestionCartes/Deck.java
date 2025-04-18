package gestionCartes;
import java.util.ArrayList;
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
	/**
     * Liste des serviteurs présents dans le deck.
     */
	private List<Serviteur> DeckCartes = new ArrayList<>(30);
	 /**
     * Identifiant unique du deck (non encore utilisé dans ce contexte, sera utile lors de la sauvegarde)
     */
	private int Id;
	
	
	/**
     * Ajoute un serviteur au deck actuel.
     * 
     * @param ServiteurDeck Le serviteur à ajouter
     */
	public void ajouterCarteDeck(Serviteur ServiteurDeck) {
		this.DeckCartes.add(ServiteurDeck);
        }
	
	 /**
     * Retourne la liste complète des serviteurs du deck.
     * 
     * @return La liste des serviteurs du deck
     */
	public List<Serviteur> getDeckCartes() {
		return DeckCartes;
	}
	
	/**
     * Retourne une chaîne lisible représentant le contenu actuel du deck.
     * 
     * @return Une description des cartes contenues dans le deck
     */
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
