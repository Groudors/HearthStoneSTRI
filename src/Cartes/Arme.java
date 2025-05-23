package Cartes;
import gestionEffets.*;
import heros.Hero;

/**
 * Classe représentant une arme dans le jeu de cartes.
 * Elle hérite de la classe Carte et ajoute des fonctionnalités destinées aux armes
 */
public class Arme extends Carte{
	private int durabilite;
	private int attaque;
	private Hero proprietaire;
	// private ActionSpeciale action spéciale; #A faire dans les étapes suivantes
	
	/**
     * Crée une nouvelle arme avec les caractéristiques spécifiées.
     *
     * @param attaque Les points de dégâts infligés par l'arme
     * @param durabilite La durabilité de l'arme
     */
	
	public Arme(String nom, int attaque, int durabilite, int mana) {
		super(nom,mana);
		this.durabilite=durabilite;
		this.attaque=attaque;
	}
	
	public int getDurabilite() {return durabilite;}
	public int getAttaque() {return attaque;}
	
	/**
	 * Attaque un serviteur avec l'arme.
	 * 
	 * @param cible Le serviteur ennemi à attaquer
	 */
	public void AttaquerServiteur(Serviteur cible) {
		cible.prendreDegats(attaque);
		durabilite--;
		if (estCassee()) {
			detruireArme();
		} else {
			System.out.println("L'arme a été utilisée, il lui reste " + durabilite + " points de durabilité.");
		}
	}
	
	/**
	 * Attaque un héros avec l'arme.
	 * 
	 * @param cible Le héros ennemi à attaquer
	 */
	public void AttaquerHero(Hero cible) {
		cible.prendreDegats(attaque);
		durabilite--;
		if (estCassee()) {
			detruireArme();
		} else {
			System.out.println("L'arme a été utilisée, il lui reste " + durabilite + " points de durabilité.");
		}
	}
	
	/**
	 * Vérifie si l'arme est cassée.
	 * @return true si l'arme est cassée, false sinon
	 */
	public boolean estCassee() {return durabilite <= 0;}
	
	/**
	 * Retourne une chaîne représentant les caractéristiques de l'arme.
	 * 
	 * @return Une description détaillée de l'arme
	 */
	@Override
	public String presentationCarte() {
		return super.presentationCarte() + " [Arme] | Puissance : " + attaque + " | Durabilité : " + durabilite;
	}
	
	/**
	 * Fait équiper l'arme au héro.
	 * @param hero Le héro qui va équiper l'arme
	 */
	public void equiperArme(Hero hero) {
		if (hero == null) {
            throw new IllegalArgumentException("Le héros ne peut pas être nul.");
        }
		else {
			if (hero.getArme() != null) {
				detruireArme();
				return;
			}
			this.proprietaire = hero;
		}
	}
	
	
	/**
	 * Retourne le héros qui possède l'arme.
	 * 
	 * @return Le héros qui possède l'arme
	 */
	public Hero getProprietaire() {return proprietaire;}
	
	
	/**
	 * Détruit l'arme lorsqu'elle est cassée.
	 */
	public void detruireArme() {
		System.out.println("L'arme est détruite et ne peut plus être utilisée.");
		proprietaire.destructionArme();
		proprietaire = null;
	}
	
	/**
	 * Augmente l'attaque de l'arme.
	 * 
	 * @param attaque L'augmentation de l'attaque
	 */
	public void augmenterAttaque(int attaque) {
		this.attaque += attaque;
		System.out.println("L'attaque de l'arme a été augmentée de " + attaque + " points.");
	}
	
	
}
