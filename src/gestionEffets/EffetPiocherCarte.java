package gestionEffets;
import deroulementPartie.Joueur;

public class EffetPiocherCarte implements Effet {
    private int nbCartes;

    public EffetPiocherCarte(int nbCartes) {
        this.nbCartes = nbCartes;
    }

    @Override
    public void appliquer(Cible cible) {
        if (cible instanceof Joueur joueur) {
        	for(int i = 0; i < nbCartes-1; i++) {
            joueur.tirerCarte();
        	}
            System.out.println(joueur.getHero().getNom() + " pioche " + nbCartes + " carte(s)");
        }
    }

    @Override
    public String getDescription() {
        return "Pioche " + nbCartes + " carte(s)";
    }

}
