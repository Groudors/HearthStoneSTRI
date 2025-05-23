package heros;

import gestionEffets.Cible;

/**
 * Classe représentant le pouvoir héroïque du prêtre. Le prêtre soigne une cible alliée ou lui même de 2 points de vie.
 */
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
