package Cartes;
import gestionEffets.*;

/**
 * Classe représentant une carte de type sort. Un sort a un coût en mana et un effet
 * associé. Il peut être utilisé pour infliger des dégâts, soigner, ou appliquer
 * d'autres effets à une cible
 */
public class Sort extends Carte {
    private Effet effet;

    public Sort(String nom, int coutMana, Effet effet) {
        super(nom, coutMana);
        this.effet = effet;
    }

    public void activerEffet(Cible cible) {
        effet.appliquer(cible);
    }

    @Override
    public String presentationCarte() {
        return super.presentationCarte() + " [Sort] - Effet : " + effet.getDescription();
    }
}

