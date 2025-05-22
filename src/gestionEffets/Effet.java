package gestionEffets;

public interface Effet {
    public void appliquer(Cible cible);  // Cible = Serviteur, Héros, etc.
    String getDescription();      // Pour l'affichage
}
