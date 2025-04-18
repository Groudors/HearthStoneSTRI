package utilisationCarte;
import Cartes.*;
import gestionCartes.*;
import gestionPlateau.*;
import java.util.Random;

public class CombatServiteurs {
	
	
	public void AffrontementDeuxServiteurs(Serviteur attaquant , Serviteur defenseur) {
		if(!(attaquant.getHP()>0 && defenseur.getHP()>0)) {
			attaquant.Attaquer(defenseur);
		}
		AffrontementDeuxServiteurs(defenseur,attaquant);
	}
	
	public void ChoixServiteurs(Deck deck){
	 Random rand = new Random();
	 int Serviteur1 = rand.nextInt(deck.getDeckCartes().size()); // entre 0 et serviteurs.size() - 1
	 int Serviteur2 = rand.nextInt(deck.getDeckCartes().size()); // entre 0 et serviteurs.size() - 1
	 System.out.println("Ce combat légendaire verra s'affronter le terrible "+ deck.getDeckCartes().get(Serviteur1).getNom() + " et l'infâme " +deck.getDeckCartes().get(Serviteur2).getNom() );
	 AffrontementDeuxServiteurs(deck.getDeckCartes().get(Serviteur1), deck.getDeckCartes().get(Serviteur2));
	}

}
