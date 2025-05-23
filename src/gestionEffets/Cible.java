package gestionEffets;

/**
 * Interface représentant une cible d'effet. Chaque cible peut recevoir des dégâts
 * ,être soignée ou avoir d'autres effets appliqués. Les cibles sont
 * des héros ou des serviteurs.
 */
public interface Cible {
    boolean prendreDegats(int degats);
    void soigner(int soin);
}
