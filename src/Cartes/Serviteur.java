package Cartes;

/**
 * Représente une carte de type Serviteur dans le jeu.
 * Un serviteur possède des points de vie, des dégâts, un coût en mana, 
 * et un nom. Il peut attaquer un autre serviteur et subir des dégâts.
 * Certains serviteurs peuvent avoir une action spéciale
 * 
 * @author Virgile B
 */

public class Serviteur {
	private int HP;
	private int degats;
	private int mana;
	// private ActionSpeciale action spéciale; #A faire dans les étapes suivantes
	private String nom;
	
	/**
     * Crée un nouveau serviteur avec les caractéristiques spécifiées.
     *
     * @param nom Le nom du serviteur
     * @param HP Les points de vie du serviteur
     * @param degats Les points de dégâts infligés par le serviteur
     * @param mana Le coût en mana du serviteur
     */
	public Serviteur(String nom,int HP, int dégats, int mana) {
		this.nom=nom;
		this.HP=HP;
		this.degats=dégats;
		this.mana=mana;
	}
	
	public String getNom() {
		return nom;
	}
	public int getMana() {
		return mana;
	}
	public int getHP() {
		return HP;
	}
	public int getDégats() {
		return degats;
	}
	
	
	 /**
     * Applique des dégâts au serviteur.
     *
     * @param coupsubi Le nombre de points de dégâts subis
     * @return true si le serviteur meurt (HP <= 0), false sinon
     */
	public Boolean subirDegats(int coupsubi) {
		HP=HP-coupsubi;
		return HP<=0;
		
	}
	 /**
     * Méthode appelée lorsque le serviteur meurt.
     * À implémenter : effets visuels/logiques sur le plateau.
     */
	public void mourir() {
		//Changement graphique sur le plateau de jeu et faire disparaitre le serviteur
		
	}
	
	/**
     * Fait attaquer ce serviteur contre un autre serviteur.
     *
     * @param ennemie Le serviteur ennemi à attaquer
     * @return true si l'ennemi meurt lors de l'échange, false sinon
     */
	public boolean Attaquer(Serviteur ennemie) {
		if(ennemie.subirDegats(degats)) {
			System.out.println("Le " + ennemie.getNom()+" subit "+ degats +" dégats, et ne peut supporter cette assaut. Il s'effrondre. Mort!");
			ennemie.mourir();
			return true;
		}
		else {
			System.out.println("Le " + ennemie.getNom()+" subit "+ degats + " dégats, mais parvient à rester debout. Il lui reste "+ennemie.getHP() +" points de vie.");
			return false;
		}
	}

}
