package Cartes;

public abstract class Carte {
    protected String nom;
    protected int coutMana;

    public Carte(String nom, int coutMana) {
        this.nom = nom;
        this.coutMana = coutMana;
    }

    public String getNom() {
        return nom;
    }

    public int getCoutMana() {
        return coutMana;
    }
    
    public String presentationCarte() {
        return nom + " Mana : " + coutMana + " ";
    }

}