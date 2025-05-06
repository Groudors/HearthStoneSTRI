package heros;

public enum HerosDisponibles {
    JAINA("Jaina Portvaillant", "Mage"),
    GARROSH("Garrosh Hurlenfer", "Guerrier"),
    ANDUIN("Anduin Wrynn", "Prêtre"),
    VALEERA("Valeera Sanguinar", "Voleur"),
    THRALL("Thrall", "Chaman"),
    MALFURION("Malfurion Hurlorage", "Druide"),
    UTHER("Uther le Porteur de Lumière", "Paladin"),
    REXXAR("Rexxar", "Chasseur"),
    GULDAN("Gul'dan", "Démoniste");

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
