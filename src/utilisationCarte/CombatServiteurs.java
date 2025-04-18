package utilisationCarte;
import Cartes.*;
import gestionCartes.*;
import gestionPlateau.*;
import java.util.Random;

public class CombatServiteurs {
	
	
	public void AffrontementDeuxServiteurs(Serviteur attaquant , Serviteur defenseur) {
		if((attaquant.getHP()>0 && defenseur.getHP()>0)) {
			attaquant.Attaquer(defenseur);
			AffrontementDeuxServiteurs(defenseur,attaquant);
		}

	}
	
	public boolean ChoixServiteurs(Deck deck){
	 Random rand = new Random();
	 if(deck.getDeckCartes().size()<2) {
		 System.out.println("Deck non valide");
		 return false;
	 }
	 else {
		 int Serviteur1 = rand.nextInt(deck.getDeckCartes().size()); // entre 0 et serviteurs.size() - 1
		 int Serviteur2 = rand.nextInt(deck.getDeckCartes().size()); // entre 0 et serviteurs.size() - 1
		 while (Serviteur2==Serviteur1) {
			 Serviteur2 = rand.nextInt(deck.getDeckCartes().size()); // entre 0 et serviteurs.size() - 1
		 }
		 Serviteur s1=deck.getDeckCartes().get(Serviteur1);
		 Serviteur s2=deck.getDeckCartes().get(Serviteur2);
		 System.out.println("Ce combat légendaire verra s'affronter le terrible "+ s1.getNom() + " et l'infâme " +s2.getNom() );
		 AffrontementDeuxServiteurs(deck.getDeckCartes().get(Serviteur1), deck.getDeckCartes().get(Serviteur2));
		 return true;
	 }
	}

}
