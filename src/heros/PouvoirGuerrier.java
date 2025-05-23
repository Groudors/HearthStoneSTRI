package heros;
import gestionEffets.Cible;

/**
 * Classe représentant le pouvoir héroïque du guerrier. Le guerrier gagne 2
 * points d'armure.
 */
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
