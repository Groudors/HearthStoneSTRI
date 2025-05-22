package heros;
import gestionEffets.Cible;

public class PouvoirGuerrier implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        lanceur.gagneArmure(2);
    }

    @Override
    public String getNomPouvoir() {
        return "Armure renforcée";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Confère 2 points d'armure.";
    }
}
