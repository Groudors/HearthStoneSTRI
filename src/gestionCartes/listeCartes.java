package gestionCartes;
import Cartes.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une liste prédéfinie de serviteurs disponibles pour créer un deck.
 * Cette classe permet d'initialiser, d'afficher et de récupérer les cartes de type {@link Serviteur}.
 * Elle agit comme une bibliothèque de cartes.
 * 
 * @author Virgile B
 */
public class listeCartes {
	 /**
     * Liste de tous les serviteurs disponibles.
     */
	List<Serviteur> serviteurs = new ArrayList<>(40);

	/**
     * Crée les instances de tous les serviteurs disponibles dans le jeu et les ajoute à la liste principale.
     * Cette méthode est appelée une seule fois à l'initialisation de listeCartes.
     */
	public void creeInstanceServiteur() {
		List<Serviteur> transition = List.of(
				new Serviteur("Acolyte squelletique", 2, 1, 1),
		        new Serviteur("Moustique monstrueux", 2, 1, 1),
		        new Serviteur("Nécrorateur auchenaï", 3, 1, 1),
		        new Serviteur("Ramasse-cadavres", 3, 1, 1),
		        new Serviteur("Figure de proue", 2, 3, 2),
		        new Serviteur("Fossoyeuse nécrotique", 3, 2, 2),
		        new Serviteur("Hématurge", 3, 2, 2),
		        new Serviteur("Maître-chien de l'effroi", 1, 2, 2),
		        new Serviteur("Messagère de l'hiver", 2, 3, 2),
		        new Serviteur("Nécromancien belliciste", 2, 2, 2),
		        new Serviteur("Pirate os-vermoulu", 4, 1, 2),
		        new Serviteur("Porte-froid de la mort", 3, 2, 2),
		        new Serviteur("Tank zombie titubant", 2, 3, 2),
		        new Serviteur("Acolute de la mort", 4, 2, 3),
		        new Serviteur("Baron Chute-des-Froids", 2, 2, 3),
		        new Serviteur("Chevalier Dess Métal", 4, 3, 3),
		        new Serviteur("Couturière arc-en-ciel", 3, 3, 3),
		        new Serviteur("Falric", 4, 2, 3),
		        new Serviteur("Fleur putrescente", 5, 0, 3),
		        new Serviteur("Flèche des âmes", 2, 2, 3),
		        new Serviteur("Infestateur", 2, 4, 3),
		        new Serviteur("Boutons", 4, 4, 4),
		        new Serviteur("Eliza Lametripe", 3, 4, 4),
		        new Serviteur("Garde-essaim nérubien", 3, 1, 4),
		        new Serviteur("Horreur malveillante", 4, 2, 4),
		        new Serviteur("Thassarian", 3, 3, 4),
		        new Serviteur("Vipère", 3, 5, 4),
		        new Serviteur("Porte-mort Saurcroc", 6, 4, 5),
		        new Serviteur("Marionnettiste en herbe", 6, 2, 5),
		        new Serviteur("Agent de sécurité", 2, 2, 6),
		        new Serviteur("Carcasse repoussante", 5, 3, 6),
		        new Serviteur("Croque-gnomes", 6, 5, 6),
		        new Serviteur("Exarque Maladaar", 5, 5, 6),
		        new Serviteur("Nythendra", 7, 7, 7),
		        new Serviteur("Les 8 mains de l'Au-delà", 8, 8, 8),
		        new Serviteur("Géant raccommodé", 8, 8, 9),
		        new Serviteur("Ursoc", 14, 6, 9),
		        new Serviteur("Eveilleur d'âmes", 7, 8, 10)
		);
		for(Serviteur s : transition) {
			ajouterCartesListe(s);
		}
	}

	/**
     * Ajoute un serviteur à la liste des cartes disponibles.
     *
     * @param nouveauServiteur Le serviteur à ajouter à la liste
     */
	public void ajouterCartesListe(Serviteur nouveauServiteur) {
		this.serviteurs.add(nouveauServiteur);
        }
	
	/**
     * Retourne la liste complète des serviteurs.
     *
     * @return Liste d'objets {Serviteur}
     */
	public List<Serviteur> getListeServiteurs() {
		return serviteurs;
	}
	
	/**
     * Retourne un serviteur à une position donnée dans la liste.
     *
     * @param x L'index du serviteur (à partir de 0)
     * @return Le serviteur correspondant
     * @throws IndexOutOfBoundsException si x est hors limites (de 0 à 38 pour l'instant)
     */
	public Serviteur getServiteurs(int x) {
		return serviteurs.get(x);
	}
	
	/**
     * Retourne une chaîne représentant toutes les cartes disponibles dans un format lisible.
     * @return Une description détaillée de chaque carte avec son index, nom, force, HP et coût en mana
     */
	public String montrerServiteurs() {
		String message="";
		int i = 1;
		for (Serviteur creature : serviteurs) {
			message += "- " + i + " - " + creature.getNom() + " Force : " + creature.getDegats() + " HP : "+ creature.getHP() + " Mana : " + creature.getCoutMana() + ". \n";
			i++;
		}
		return message;
		}
	}


