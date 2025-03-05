package Cartes;

public class Serviteur {
	private int HP;
	private int dégats;
	private int mana;
	// private ActionSpeciale actionspéciale; #A faire dans les étapes suivantes
	private String nom;
	
	private Serviteur(String nom,int HP, int dégats, int mana) {
		this.nom=nom;
		this.HP=HP;
		this.dégats=dégats;
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
		return dégats;
	}
	
	public Boolean subirDegats(int dégats) {
		HP=HP-dégats;
		return HP==0;
		
	}
	
	public void mourir() {
		//Changement graphique sur le plateau de jeu et faire disparaitre le serviteur
		
	}
	
	public void Attaquer(Serviteur ennemie) {
		if(ennemie.subirDegats(dégats)==true) {
			System.out.println("Le serviteur prends bagdad, et s'effrondre");
			ennemie.mourir();
		}
		else {
			System.out.println("Le serviteur ne prends pas bagdad, et ne s'effondre pas");
		}
	}

	
	
}
