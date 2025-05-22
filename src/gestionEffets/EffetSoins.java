package gestionEffets;

public class EffetSoins implements Effet {
    private int soin;

    public EffetSoins(int soin) {
        this.soin = soin;
    }

    @Override
    public void appliquer(Cible cible) {
        cible.soigner(soin);
    }

    @Override
    public String getDescription() {
        return "Soigne " + soin + " points de vie";
    }
}
