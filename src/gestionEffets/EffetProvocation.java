package gestionEffets;

import Cartes.Serviteur;

public class EffetProvocation implements Effet {
	@Override
	public void appliquer(Cible cible) {
		if (cible instanceof Serviteur) {
			((Serviteur) cible).setProvocation(true);
	        System.out.println(((Serviteur) cible).getNom() + " obtient Provocation.");
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
