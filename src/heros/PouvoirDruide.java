package heros;

import Cartes.*;
import gestionEffets.Cible;

/**
 * Classe représentant le pouvoir héroïque du druide.
 *  Le druide gagne 1 armure et +1 attaque temporaire.
 */
public class PouvoirDruide implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        lanceur.gagneArmure(1);
        // Si le druide possède déjà une arme, on augmente l'attaque de l'arme de 1.
        // Sinon, on lui donne une arme de base avec une attaque de 1.
		if (lanceur.getArme() != null) {
			lanceur.getArme().augmenterAttaque(1);
		} else {
			// On lui donne une arme de base avec une attaque de 1. Elle ne sera pas détruite à la fin du tour, mais possède une durabilité de 1.
			lanceur.equiperArme(new Arme("Griffes", 1,1,0));
		}
        System.out.println("Gagne 1 armure et +1 attaque temporaire (non encore implémentée).");
    }

    @Override
    public String getNomPouvoir() {
        return "Griffes";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Gagne 1 armure et +1 attaque ce tour.";
    }
}
