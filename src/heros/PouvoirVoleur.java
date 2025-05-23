package heros;

import gestionEffets.Cible;
import Cartes.Arme;

/**
 * Classe représentant le pouvoir héroïque du voleur. Le voleur équipe une arme
 * 1/2.
 */
public class PouvoirVoleur implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        Arme dague = new Arme("Dague", 1, 2,0);
        dague.equiperArme(lanceur);
        lanceur.equiperArme(dague);
    }

    @Override
    public String getNomPouvoir() {
        return "Dague de voleur";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Équipe une arme 1/2.";
    }
}
