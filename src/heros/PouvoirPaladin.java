package heros;

import gestionEffets.Cible;
import Cartes.Serviteur;

/**
 * Classe représentant le pouvoir héroïque du paladin.Le paladin invoque une
 * recrue 1/1.
 */
public class PouvoirPaladin implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        Serviteur recrue = new Serviteur("Recrue de la Main d'argent", 1, 1, 1,null);
        // On doit faire apparaitre la recrue sur le plateau qui se trouve dans le propriétaire de Hero
        if (lanceur.getProprietaire() != null) {
            lanceur.getProprietaire().ajouterServiteurAuPlateau(recrue);
            System.out.println("Une Recrue de la Main d'argent (1/1) a été invoquée.");
        } else {
            System.out.println("Erreur : Le héros n'a pas de propriétaire.");
        }    }

    @Override
    public String getNomPouvoir() {
        return "Renfort";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Invoque une Recrue 1/1.";
    }
}
