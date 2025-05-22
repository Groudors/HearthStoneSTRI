package heros;
import gestionEffets.*;

public class PouvoirMage implements PouvoirHeroique {
    public void activer(Hero lanceur, Cible cible) {
        cible.prendreDegats(1);
    }

    public String getNomPouvoir() {
        return "Explosion de feu";
    }

    public String getDescriptionPouvoir() {
        return "Inflige 1 dégât à une cible adverse.";
    }
}

