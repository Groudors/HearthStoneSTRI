package gestionCartes;
import Cartes.*;
import java.util.ArrayList;
import java.util.List;
import gestionEffets.*;

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
	List<Carte> listecarte = new ArrayList<>(100);

	/**
     * Crée les instances de tous les serviteurs disponibles dans le jeu et les ajoute à la liste principale.
     * Cette méthode est appelée une seule fois à l'initialisation de listeCartes.
     */
	public void creeInstanceCarte() {
		List<Serviteur> transition1 = List.of(
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
		for(Serviteur s : transition1) {
			ajouterCartesListe(s);
		}
	
		List<Arme> transition2 = List.of(
				new Arme("Lame runique horrible", 2, 2, 2),
		        new Arme("Brisâme", 3, 2, 3),
		        new Arme("Deuillemousse", 5, 1, 5),
		        new Arme("Deuillegivre", 4, 3, 6),
		        new Arme("Tranche-défenses", 1, 2, 1),
		        new Arme("Agrafeuse infernale", 3, 3, 3),
		        new Arme("Lames de guerre des Aldrachi", 2, 2, 3),
		        new Arme("Emprise de l'arbitre", 3, 2, 4),
		        new Arme("Lance souillé", 2, 3, 4),
		        new Arme("Grappin d'escalade", 5, 2, 6),
		        new Arme("Télécommande", 1, 3, 2),
		        new Arme("Blaster stellaire", 2, 3, 3),
		        new Arme("Crosse du berger", 3, 2, 3),
		        new Arme("Maillet-ball", 3, 2, 3),
		        new Arme("Tranche-étoile interstellaire", 3, 2, 3),
		        new Arme("Cendrépée", 1, 2, 1),
		        new Arme("Canon à eau", 3, 3, 4),
		        new Arme("Hache de guerre embrasée", 3, 2, 2),
		        new Arme("Rempart d'Azzinoth", 1, 4, 3),
		        new Arme("Tranchemie", 4, 2, 5));
		for(Arme a : transition2) {
			ajouterCartesListe(a);
		}
		
		List<Sort> sorts = List.of(
		        new Sort("Boule de Feu", 4, new EffetDegats(6)),
		        new Sort("Soin Divin", 2, new EffetSoins(4)),
		        new Sort("Cor de l'hiver", 0, new EffetMana(2)),
		        new Sort("Siphon de vie", 2, new EffetDegats(2)),
		        new Sort("Moral en Berne", 1, new EffetModifAttaque(-2)),
		        new Sort("Cri de guerre", 1, new EffetModifAttaque(2)));
		
		    for (Sort s : sorts) {
		        ajouterCartesListe(s);
		    }
	}

	/**
     * Ajoute un serviteur à la liste des cartes disponibles.
     *
     * @param nouveauServiteur Le serviteur à ajouter à la liste
     */
	public void ajouterCartesListe(Carte carte) {
		this.listecarte.add(carte);
        }
	
	/**
     * Retourne la liste complète des serviteurs.
     *
     * @return Liste d'objets {Serviteur}
     */
	public List<Carte> getListeCarte() {
		return listecarte;
	}
	
	/**
     * Retourne un serviteur à une position donnée dans la liste.
     *
     * @param x L'index du serviteur (à partir de 0)
     * @return Le serviteur correspondant
     * @throws IndexOutOfBoundsException si x est hors limites (de 0 à 38 pour l'instant)
     */
	public Carte getCarte(int x) {
		return listecarte.get(x);
	}
	
	/**
     * Retourne une chaîne représentant toutes les cartes disponibles dans un format lisible.
     * @return Une description détaillée de chaque carte avec son index, nom, force, HP et coût en mana
     */
	public String montrerCartes() {
		String message="";
		int i = 1;
		for (Carte carte : listecarte) {
			message += "- " + i +" "+ carte.presentationCarte()+". \n";
			i++;
		}
		return message;
		}
	}


