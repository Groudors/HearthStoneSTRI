package heros;

import gestionEffets.Cible;
import Cartes.Arme;

public class PouvoirVoleur implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        Arme dague = new Arme("Dague", 1, 2,0);
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
