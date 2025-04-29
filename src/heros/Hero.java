package heros;

public class Hero {
    private String nom;
    private int vie = 30;
    private int manaActuel = 1;
    private int manaMax = 1;

    public Hero(String nom) {
        this.nom = nom;
    }
    public int getManaActuel() {
        return manaActuel;
    }
    public String getNom() {
		return nom;
	}

    public void prendreDgt(int dgt) {
        this.vie -= dgt;
    }

    public boolean estMort() {
        return vie <= 0;
    }

    public void debutTour() {
        if (manaMax < 10) manaMax ++;
        manaActuel = manaMax ;
    }

    public void useMana(int cout) {
        manaActuel -= cout;
    }

    public String getName() {
        return nom;
    }

    public int getHealth() {
        return vie;
    }
}
