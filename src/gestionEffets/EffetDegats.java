package gestionEffets;

public class EffetDegats implements Effet {
    private int degats;

    public EffetDegats(int degats) {
        this.degats = degats;}

    @Override
    public void appliquer(Cible cible) {
        cible.prendreDegats(degats);
    }

    @Override
    public String getDescription() {
        return "Inflige " + degats + " points de dégâts à la cible";
    }
}
