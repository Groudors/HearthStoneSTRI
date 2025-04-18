package utilisationCarte;
import Cartes.*;
import gestionCartes.*;
import gestionPlateau.*;
import java.util.Random;


/**
 * Gère les combats entre deux serviteurs issus d'un deck.
 * Fournit les méthodes nécessaires pour simuler un affrontement entre deux cartes.
 * 
 * @author Virgile B
 */
public class CombatServiteurs {
	
	/**
     * Fait s'affronter deux serviteurs jusqu'à ce que l'un d'eux meure.
     * Si le défenseur survit à l'attaque, il contre-attaque automatiquement.
     *
     * @param attaquant Le serviteur qui initie l'attaque
     * @param defenseur Le serviteur qui subit l'attaque
     */
	public void AffrontementDeuxServiteurs(Serviteur attaquant , Serviteur defenseur) {
		if(!(attaquant.Attaquer(defenseur))) {
			AffrontementDeuxServiteurs(defenseur,attaquant);
		}

	}
	
	/**
     * Sélectionne deux serviteurs différents au hasard dans le deck
     * et les fait s'affronter.
     *
     * @param deck Le deck contenant les cartes de type Serviteur
     * @return true si l'affrontement a pu être réalisé, false sinon
     */
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
