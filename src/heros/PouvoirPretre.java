package heros;

import gestionEffets.Cible;

public class PouvoirPretre implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        cible.soigner(2);
    }

    @Override
    public String getNomPouvoir() {
        return "Soins";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Rend 2 points de vie à une cible alliée.";
    }
}
