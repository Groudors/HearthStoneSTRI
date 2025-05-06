package heros;

public class Hero {
    private String nom;
    private int vie = 30;
    private int manaActuel = 1;
    private int manaMax = 1;

    public Hero() {
        this.nom = ChoixHero.choisirHero();
    }
    
    public int getManaActuel() {return manaActuel;}
    public String getNom() {return nom;}
    public int getVie() {return vie;}

    public void prendreDgt(int dgt) {
        vie -= dgt;
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
    
    public void choisirHero() {
    	
    	
    }

}
