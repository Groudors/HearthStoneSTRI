package heros;

import gestionEffets.Cible;

public class PouvoirDruide implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        lanceur.gagneArmure(1);
        // TODO : ajouter un système d’attaque temporaire ou +1 si déjà une arme
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
