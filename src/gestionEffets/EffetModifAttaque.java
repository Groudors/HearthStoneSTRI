package gestionEffets;

import Cartes.*;

public class EffetModifAttaque implements Effet {
    private int modif;

    public EffetModifAttaque(int modif) {
        this.modif = modif;
    }

    @Override
    public void appliquer(Cible cible) {
        if (cible instanceof Serviteur) {
            ((Serviteur) cible).modifierDegats(modif);
        }
    }

    @Override
    public String getDescription() {
        return "Modifie l'attaque de la cible de " + modif;
    }
}
