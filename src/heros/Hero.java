package heros;
import Cartes.*;
import gestionEffets.*;

public class Hero implements Cible {
    private String nom;
    private int vie = 30;
    private int manaActuel = 1;
    private int manaMax = 1;
    private Arme arme;

    public Hero() {this.nom = ChoixHero.choisirHero();}
    
    public int getManaActuel() {return manaActuel;}
    public String getNom() {return nom;}
    public int getVie() {return vie;}

    public boolean prendreDegats(int dgt) {
        vie -= dgt;
        return vie<=0;
    }

	public void soigner(int soin) {
		vie += soin;
	}
	public void regenererMana(int mana) {
		manaActuel += mana;
		if (manaActuel > manaMax) {
			manaActuel = manaMax;
		}
	}

    public boolean estMort() {
        return vie <= 0;
    }

    public void debutTour() {
        if (manaMax < 10) manaMax ++;
        manaActuel = manaMax ;
    }

    public void utiliseMana(int cout) {
        manaActuel -= cout;
    }

	public void setManaActuel(int manaActuel) {
    this.manaActuel = manaActuel;
    }
    
	/**
	 * Methode permettant d'equiper une arme au hero
	 * 
	 * @param arme
	 * @return
	 */
	public void equiperArme(Arme arme) {
		this.arme = arme;
		arme.equiperArme(this);
	}
	
	public Arme getArme() {
		return arme;
	}
	
	public void destructionArme() {
		arme = null;
	}
    
   

}
