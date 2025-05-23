package heros;
import gestionEffets.*;

public interface PouvoirHeroique {
    void activer(Hero lanceur, Cible cible);
    String getNomPouvoir();
    String getDescriptionPouvoir();
}
