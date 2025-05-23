package heros;
import gestionEffets.*;

/**
 * Interface représentant un pouvoir héroïque. Chaque héros a un pouvoir héroïque unique
 */
public interface PouvoirHeroique {
    void activer(Hero lanceur, Cible cible);
    
    String getNomPouvoir();
    
    String getDescriptionPouvoir();
    
}
