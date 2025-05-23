package heros;
import gestionEffets.*;

/**
 * Classe représentant le pouvoir héroïque du mage. Le mage inflige 1 dégât à
 * une cible adverse.
 */
public class PouvoirMage implements PouvoirHeroique {
    public void activer(Hero lanceur, Cible cible) {
    	// On doit s'assurer que la cible est un serviteur ennemi ou un héros ennemi.
        cible.prendreDegats(1);
    }

    public String getNomPouvoir() {
        return "Explosion de feu";
    }

    public String getDescriptionPouvoir() {
        return "Inflige 1 dégât à une cible adverse.";
    }
}

