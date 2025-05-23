package heros;

import gestionEffets.Cible;

/**
 * Classe représentant le pouvoir héroïque du chasseur. Le chasseur inflige 2
 * dégâts au héros adverse.
 */
public class PouvoirChasseur implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
    	// On doit s'assurer que la cible est un héros
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
