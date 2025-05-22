package Cartes;
import gestionEffets.*;
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

