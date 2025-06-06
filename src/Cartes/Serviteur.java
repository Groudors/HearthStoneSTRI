package Cartes;
import gestionEffets.*;

/**
 * Représente une carte de type Serviteur dans le jeu.
 * Un serviteur possède des points de vie, des dégâts, un coût en mana, 
 * et un nom. Il peut attaquer un autre serviteur et subir des dégâts.
 * Certains serviteurs peuvent avoir une action spéciale à leur entrée en jeu
 * 
 */
public class Serviteur extends Carte implements Cible{
	private int HP;
	private int degats;
	private Effet effetEntreeJeu;
    private boolean provocation = false;
	
	/**
     * Crée un nouveau serviteur avec les caractéristiques spécifiées.
     *
     * @param nom Le nom du serviteur
     * @param HP Les points de vie du serviteur
     * @param degats Les points de dégâts infligés par le serviteur
     * @param mana Le coût en mana du serviteur
     */
	public Serviteur(String nom,int HP, int dégats, int coutmana, Effet effetEntreeJeu) {
		super(nom,coutmana);
		this.HP=HP;
		this.degats=dégats;
		this.effetEntreeJeu = effetEntreeJeu;
	}
	// Partie Getters :
	public int getHP() {return HP;}
	public int getDegats() {return degats;}
    public Effet getEffetEntreeJeu() { return effetEntreeJeu; }

    
    
	/**
	 * Retourne une chaîne représentant les caractéristiques du serviteur.
	 *
	 * @return Une description détaillée du serviteur
	 */
	@Override
	public String presentationCarte() {
		return super.presentationCarte() + " [Serviteur] | Force : " + degats + " | HP : " + HP + " | Effet : " + (effetEntreeJeu != null ? effetEntreeJeu.getDescription() : "Aucun effet");
	}
	
	 /**
     * Applique des dégâts au serviteur.
     *
     * @param coupsubi Le nombre de points de dégâts subis
     * @return true si le serviteur meurt (HP <= 0), false sinon
     */
	@Override
	public boolean prendreDegats(int coupsubi) {
		HP=HP-coupsubi;
		return HP<=0;
	}
	
	public void modifierDegats(int degats) {
		this.degats = this.degats +degats;
		return;
	}
	
	public void soigner(int soins) {
		HP = HP + soins;
		return;
	}
	 /**
     * Méthode appelée lorsque le serviteur meurt.
     * À implémenter : effets visuels/logiques sur le plateau.
     */
	public void mourir(Cible cible) {
		//Changement graphique sur le plateau de jeu et faire disparaitre le serviteur
	}
	
	/**
     * Fait attaquer ce serviteur contre un autre serviteur.
     *
     * @param ennemie Le serviteur ennemi à attaquer
     * @return true si l'ennemi meurt lors de l'échange, false sinon
     */
	public boolean Attaquer(Serviteur ennemie) {
		System.out.println("Le " + this.getNom() + " attaque le " + ennemie.getNom());
		if(ennemie.prendreDegats(degats)) {
			System.out.println("Le " + ennemie.getNom()+" subit "+ degats +" dégats, et ne peut supporter cette assaut. Il s'effrondre. Mort!");
			ennemie.mourir(ennemie);
			return true;
		}
		else {
			System.out.println("Le " + ennemie.getNom()+" subit "+ degats + " dégats, mais parvient à rester debout. Il lui reste "+ennemie.getHP() +" points de vie.");
			return false;
		}
	}
	
	/**
	 * Applique l'effet d'entrée en jeu du serviteur sur la cible spécifiée.
	 *
	 * @param cible La cible sur laquelle appliquer l'effet
	 */
    public void entrerEnJeu(Cible cible) {
        if (effetEntreeJeu != null)
            effetEntreeJeu.appliquer(cible);
    }
    
	public Effet getEffet() {
		return effetEntreeJeu;
	}
    
	public boolean getProvocation() {
		return provocation;
	}

	public void setProvocation(boolean provocation) {
		this.provocation = provocation;
	}

}
