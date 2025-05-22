package gestionEffets;
import heros.Hero;

public class EffetMana implements Effet {
    private int manaRendu;

    public EffetMana(int manaRendu) {
        this.manaRendu = manaRendu;
    }

    @Override
    public void appliquer(Cible cible) {
        if (cible instanceof Hero) {
            Hero joueur = (Hero) cible;
            joueur.regenererMana(manaRendu);
            System.out.println(joueur.getNom() + " récupère " + manaRendu + " points de mana !");
        }
    }

    @Override
    public String getDescription() {
        return "Rend " + manaRendu + " points de mana";
    }
}

