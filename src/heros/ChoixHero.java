package heros;
import Utilitaire.*;


public class ChoixHero {

    public static String choisirHero() {
    	HerosDisponibles[] listeHeros = HerosDisponibles.values();
    	int choix=deroulementChoix(listeHeros);

        HerosDisponibles heroChoisi = listeHeros[choix - 1];
        return heroChoisi.getNom();
    }
    
    
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
