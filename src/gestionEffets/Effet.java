package gestionEffets;

/**
 * Interface représentant un effet de carte. Chaque effet peut être appliqué à une cible
 * et peut avoir une description pour l'affichage.
 */
public interface Effet {
    public void appliquer(Cible cible);  // Cible = Serviteur, Héros, etc.
    String getDescription();      // Pour l'affichage
}
