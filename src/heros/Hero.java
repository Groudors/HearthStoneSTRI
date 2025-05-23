package heros;
import Cartes.*;
import gestionEffets.*;

public class Hero implements Cible {
    private String nom;
    private int vie = 30;
    private int manaActuel = 1;
    private int manaMax = 1;
    private Arme arme;
    private int armure=0;
    private PouvoirHeroique pouvoir;

    public Hero() {
    	this.nom = ChoixHero.choisirHero();
    	this.pouvoir= assignerPouvoirHeroique(nom);
    }
    
    //Partie Getteurs
    public int getManaActuel() {return manaActuel;}
    public String getNom() {return nom;}
    public int getVie() {return vie;}
    public PouvoirHeroique getPouvoir() {return pouvoir;}
	public Arme getArme() {return arme;}
	public int getArmure() {return armure;}
	public int getManaMax() {return manaMax;}
	
	
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
    
	public void gagneArmure(int armure) {
		this.armure += armure;
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
	
	
	public void destructionArme() {
		arme = null;
	}
	
	private PouvoirHeroique assignerPouvoirHeroique(String classe) {
	    return switch (classe) {
	        case "Jaina Portvaillant" -> new PouvoirMage();
	        case "Anduin Wrynn" -> new PouvoirPretre();
	        case "Garrosh Hurlenfer" -> new PouvoirGuerrier();
	        case "Valeera Sanguinar" -> new PouvoirVoleur();
	        case "Uther le Porteur de Lumière" -> new PouvoirPaladin();
	        case "Rexxar" -> new PouvoirChasseur();
	        case "Malfurion Hurlorage" -> new PouvoirDruide();
	        default -> null;
	    };
	}

    
   

}
