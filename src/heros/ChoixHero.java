package heros;
import Utilitaire.*;

/**
 * Classe ChoixHero
 * 
 * Cette classe permet de choisir un héros parmi une liste de héros disponibles
 * Elle affiche la liste des héros et demande à l'utilisateur de faire un choix
 * Le choix est validé et on renvoie le nom du héros choisi vers la classe Hero
 * 
 */
public class ChoixHero {

    public static String choisirHero() {
    	HerosDisponibles[] listeHeros = HerosDisponibles.values();
    	int choix=deroulementChoix(listeHeros);

        HerosDisponibles heroChoisi = listeHeros[choix - 1];
        return heroChoisi.getNom();
    }
    
    /**
     * Méthode permettant de gêrer le choix du héros
     * Affiche la liste des héros disponibles et demande à l'utilisateur de faire un choix
     * parmi plusieurs héros disponibles.
     * @param listeHeros
     * @return int
     */
    public static int deroulementChoix(HerosDisponibles[] listeHeros) {
    	int choix;
    	
        System.out.println("Choisissez votre héros :");
        for (int i = 0; i < listeHeros.length; i++) {
            HerosDisponibles h = listeHeros[i];
            System.out.println((i + 1) + ". " + h.getNom() + " (" + h.getClasse() + ")");
        }
        System.out.print("Entrez le numéro du héros choisi : ");
        choix=Clavier.entrerClavierInt();
        while (choix < 1 || choix > listeHeros.length) {
            System.out.print("Numéro invalide, veuillez choisir un numéro de héros : ");
            choix=Clavier.entrerClavierInt();
        }
        return choix;
		
	}
}
