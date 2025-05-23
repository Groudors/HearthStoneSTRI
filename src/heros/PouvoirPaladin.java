package heros;

import gestionEffets.Cible;
import Cartes.Serviteur;

public class PouvoirPaladin implements PouvoirHeroique {
    @Override
    public void activer(Hero lanceur, Cible cible) {
        Serviteur recrue = new Serviteur("Recrue de la Main d'argent", 1, 1, 1,null);
        // TODO : ajouter la recrue au plateau du joueur
        System.out.println("Une Recrue de la Main d'argent (1/1) a été invoquée.");
    }

    @Override
    public String getNomPouvoir() {
        return "Renfort";
    }

    @Override
    public String getDescriptionPouvoir() {
        return "Invoque une Recrue 1/1.";
    }
}
