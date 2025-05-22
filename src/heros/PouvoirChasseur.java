package heros;

import gestionEffets.Cible;

public class PouvoirChasseur implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        cible.prendreDegats(2);
    }

    @Override
    public String getNomPouvoir() {
        return "Tir assuré";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Inflige 2 dégâts au héros adverse .";
    }
}
