package gestionCartes;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

import Utilitaire.*;
import java.util.List;
import java.util.Scanner;

import Cartes.*;
import Sauvegarde.*;


/**
 * Représente un deck de cartes de type {Serviteur} que le joueur peut constituer pour jouer.
 * Un deck peut contenir jusqu'à 30 cartes maximum pour l'instant
 * Cette classe permet d'ajouter des cartes, d'afficher le deck, et de construire un deck via le clavier.
 * 
 * @author Virgile B
 */
public class Deck implements Serializable {
	/*Maximum de 30 cartes par deck */
	private List<Carte> DeckCartes = new ArrayList<>(30);
	private int Id;
	private String nomDeck;
	private static final String SAUVEGARDE_DECK = "./src/Sauvegarde/";
	/**
     * Ajoute un serviteur au deck actuel.
     * 
     * @param carte Le serviteur à ajouter
     */
	public void ajouterCarteDeck(Carte carte) {
		this.DeckCartes.add(carte);
        }
	
	 /**
     * Retourne la liste complète des serviteurs du deck.
     * 
     * @return La liste des serviteurs du deck
     */
	public List<Carte> getDeckCartes() {
		return DeckCartes;
	}
	
	public String getNomDeck() {return nomDeck;		}
	
	public void setNomDeck(String nomDeck) {this.nomDeck = nomDeck;}
	
	/**
     * Retourne une chaîne lisible représentant le contenu actuel du deck.
     * @return Une description des cartes contenues dans le deck
     */
	public String afficherDeck() {
		String message="";
		message +="| Votre deck est le suivant :\n";
		int i = 1;
		for (Carte carte : DeckCartes) {
			message += "- " + i + " " + carte.presentationCarte()+". \n";
			i++;
		}
		return message;
	}
	
	public void melanger() {
		//A Faire
		
	}
	
	/**
     * Permet à l'utilisateur de créer un deck de 30 cartes à partir d'une liste de cartes disponibles.
     * L'utilisateur sélectionne les cartes via le clavier. Il peut s'arrêter à tout moment avec l'entrée 0.
     * 
     * @param liste La source de cartes disponibles pour composer le deck
     */
	public listeCartes creerDeck(listeCartes liste) {
		Scanner scanner = new Scanner(System.in);
		String message="";
		int i=1;
		int numType;
		message+=("|----                  Bienvenue dans la Création de Deck                          ---- \n");
		message+=("Entrez le nom de votre nouveau deck : ");
		System.out.println(message);
		String nomDeck = scanner.nextLine();
		this.nomDeck = nomDeck;
		message="";
		message+=("|                 Vous pouvez choisir parmis les cartes suivantes                   \n");
		message+=liste.montrerCartes();
		System.out.println(message);
		
		while (DeckCartes.size()<30) {
			System.out.println("|              Veuillez choisir la carte " + i +" ou 0 pour sortir de la création de Deck          \n");
			numType = Clavier.entrerClavierInt();
			while((numType > liste.getListeCarte().size()) || numType<0) {
				System.out.println("|             Numéro de carte invalide           |\n");
				numType = Clavier.entrerClavierInt();
			}
			if (numType == 0){
				break;
			}
			ajouterCarteDeck(liste.getCarte(numType-1));
			System.out.println(afficherDeck());
			
			}
		System.out.println("Votre deck est complet, vous pouvez maintenant commencer le combat ! ");
		sauvegarderDeck(nomDeck);
		return liste;
		}

	public Carte piocherCarte(){
    if (!DeckCartes.isEmpty()){
        return DeckCartes.remove(0);
    	}
    return null;
	}
	
	public boolean isEmpty() {
    return DeckCartes.isEmpty();
}
	/**
	 * Sauvegarde le deck actuel dans un fichier texte.
	 * @param nomFichier
	 */
	public void sauvegarderDeck(String nomDeck) {
		String chemin = "./src/Sauvegarde/" + nomDeck + ".txt";
		File dossier = new File("./src/Sauvegarde/");
		if (!dossier.exists()) {
			dossier.mkdirs();
		}

		Fichier fichier = new Fichier(chemin);
		SupportEcriture support = new SupportEcriture(fichier);

		// Écriture du nom du deck en première ligne
		support.ecrire(nomDeck + "\n");

		// Ensuite, écriture du nom de chaque carte
		for (Carte c : this.DeckCartes) {
			support.ecrire(c.getNom() + "\n");
		}

		System.out.println("Deck \"" + nomDeck + "\" sauvegardé avec succès !");
	}

	
	/**
	 * Charge un deck à partir d'un fichier texte.
	 * Le fichier doit contenir le nom du deck sur la première ligne,
	 * suivi des noms des cartes sur les lignes suivantes.
	 * @param nomFichier
	 * @param bibliotheque
	 */
	public void chargerDeck(String nomDeck, listeCartes cartesDispo) {
		String chemin = "./src/Sauvegarde/" + nomDeck + ".txt";
		this.nomDeck = nomDeck;
		try (BufferedReader lecteur = new BufferedReader(new FileReader(chemin))) {
			// On ignore la première ligne (le nom du deck)
			lecteur.readLine();
			System.out.println("Nom du deck : " + nomDeck);

			String ligne;
			// On lit chaque ligne du fichier et on compare avec les cartes disponibles
			while ((ligne = lecteur.readLine()) != null) {
				for (Carte c : cartesDispo.getListeCarte()) {
					// On compare le nom de la carte avec la ligne lue
					if (c.getNom().equals(ligne)) {
						ajouterCarteDeck(c);
						break;
					}
				}
			}
			System.out.println("Deck \"" + nomDeck + "\" chargé avec succès !");
		} catch (IOException e) {
			System.out.println("Erreur lors du chargement du deck : " + e.getMessage());
		}

	}
	
	/**
	 * Liste tous les decks disponibles dans le répertoire ./src/Sauvegarde/
	 * @return
	 */
	public static ArrayList<String> listerDecksDisponibles() {
		ArrayList<String> nomsDecks = new ArrayList<>();
		File dossier = new File("./src/Sauvegarde/");
		// On vérifie si le dossier existe et s'il est bien un répertoire
		if (dossier.exists() && dossier.isDirectory()) {
			// On récupère tous les fichiers .txt dans le dossier
			File[] fichiers = dossier.listFiles((dir, name) -> name.endsWith(".txt"));
			if (fichiers != null) {
				// On parcourt les fichiers et on ajoute le nom du deck à la liste
				for (File f : fichiers) {
					// On supprime l'extension .txt pour obtenir le nom du deck
					String nomDeck = f.getName().replace(".txt", "");
					nomsDecks.add(nomDeck);
				}
			}
		} else {
			System.out.println("Le dossier ./src/decks/ n'existe pas.");
		}

		return nomsDecks;
	}
	
	/**
	 * Menu principal de gestion de deck
	 */
	public void gererDeck(listeCartes liste) {
		Scanner scanner = new Scanner(System.in);
		while (nomDeck==null) {
			System.out.println("\n ====  Menu  Deck  ==== ");
			System.out.println("1. Créer un nouveau deck");
			System.out.println("2. Choisir un deck existant");
			System.out.println("0. Retour");

			String choix = scanner.nextLine();

			switch (choix) {
				case "1":
					creerDeck(liste);
					break;
				case "2":
					choisirDeck(liste);
					break;
				case "0":
					return; // Retour arrière
				default:
					System.out.println("Choix invalide !");
			}
		}
	}
	/**
	 * Permet de choisir un deck existant parmi ceux disponibles.
	 * L'utilisateur peut annuler le choix en entrant 0.
	 * @param liste
	 * @return
	 */
	public void choisirDeck(listeCartes liste) {
		ArrayList<String> decks = listerDecksDisponibles();
		// On vérifie si la liste de deck est vide 
		if (decks.isEmpty()) {
			System.out.println("Aucun deck disponible. Créez-en un d'abord.");
			return;
		}
		// Affichage des decks disponibles
		System.out.println("Decks disponibles :");
		for (int i = 0; i < decks.size(); i++) {
			System.out.println((i + 1) + ". " + decks.get(i));
		}
		System.out.print("Choisissez un deck (0 pour annuler) : ");
		int choix = Clavier.entrerClavierInt();

		while (choix < 0 || choix > decks.size()) {
			System.out.print("Choix invalide, réessayez : ");
			choix = Clavier.entrerClavierInt();
		}
		if (choix == 0) return;

		String nomDeck = decks.get(choix - 1);
		chargerDeck(nomDeck, liste);
		
        // On affiche le deck chargé
        System.out.println("Vous avez choisi le deck : " + nomDeck);
        System.out.println(afficherDeck());
	}

	

	
	

}
