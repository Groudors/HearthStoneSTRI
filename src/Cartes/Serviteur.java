package Cartes;

public class Serviteur {
	private int HP;
	private int degats;
	private int mana;
	// private ActionSpeciale action spéciale; #A faire dans les étapes suivantes
	private String nom;
	
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
	
	public Boolean subirDegats(int coupsubi) {
		HP=HP-coupsubi;
		return HP<=0;
		
	}
	
	public void mourir() {
		//Changement graphique sur le plateau de jeu et faire disparaitre le serviteur
		
	}
	
	public void Attaquer(Serviteur ennemie) {
		if(ennemie.subirDegats(degats)) {
			System.out.println("Le " + ennemie.getNom()+" subit "+ degats +" dégats, et ne peut supporter cette assaut. Il s'effrondre. Mort!");
			ennemie.mourir();
		}
		else {
			System.out.println("Le " + ennemie.getNom()+" subit "+ degats + " dégats, mais parvient à rester debout. Il lui reste "+ennemie.getHP() +" points de vie.");
		}
	}
	
	public static void main(String[] args) {
		
		
	}

	
	
}
