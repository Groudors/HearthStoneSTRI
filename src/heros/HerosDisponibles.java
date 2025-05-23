package heros;

/**
 * Enumération représentant les héros disponibles dans le jeu.
 * Chaque héros a un nom et une classe associée.
 * 
 */
public enum HerosDisponibles {
    JAINA("Jaina Portvaillant", "Mage"),
    GARROSH("Garrosh Hurlenfer", "Guerrier"),
    ANDUIN("Anduin Wrynn", "Prêtre"),
    VALEERA("Valeera Sanguinar", "Voleur"),
    MALFURION("Malfurion Hurlorage", "Druide"),
    UTHER("Uther le Porteur de Lumière", "Paladin"),
    REXXAR("Rexxar", "Chasseur");

    private final String nom;
    private final String classe;

    HerosDisponibles(String nom, String classe) {
        this.nom = nom;
        this.classe = classe;
    }

    public String getNom() {
        return nom;
    }

    public String getClasse() {
        return classe;
    }
}
