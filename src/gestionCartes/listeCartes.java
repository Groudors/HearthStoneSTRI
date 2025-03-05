package gestionCartes;

import java.util.ArrayList;
import java.util.List;

import Cartes.Serviteur;

public class listeCartes {
	private List<Serviteur> ListeServiteur = new ArrayList<>(200);
	
	public void ajouterCarte(Serviteur serviteur) {
		ListeServiteur.add(serviteur);
	}
	
	public void afficherListe() {
		System.out.println("Voici la liste des Serviteurs disponibles : \n ");
		for (int i=0;i<(ListeServiteur).size();i++) {
			System.out.println("Nom : "+ ListeServiteur[i].getnom() + "");
		}
		
	}

}
