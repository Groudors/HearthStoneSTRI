package Cartes;

public class Serviteur {
	private int HP;
	private int dégats;
	private int mana;
	// private ActionSpeciale action spéciale; #A faire dans les étapes suivantes
	private String nom;
	
	public Serviteur(String nom,int HP, int dégats, int mana) {
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
		return HP<=0;
		
	}
	
	public void mourir() {
		//Changement graphique sur le plateau de jeu et faire disparaitre le serviteur
		
	}
	
	public void Attaquer(Serviteur ennemie) {
		if(ennemie.subirDegats(dégats)) {
			System.out.println("Le " + ennemie.getNom()+" ne peut supporter cette assaut, et s'effrondre");
			ennemie.mourir();
		}
		else {
			System.out.println("Le " + ennemie.getNom()+", mais parvient à rester debout");
		}
	}
	
	public static void main(String[] args) {
		
		
	}

	
	
}
