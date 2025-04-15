package gestionCartes;
import Cartes.*;
import java.util.ArrayList;
import java.util.List;

public class listeCartes {
	List<Serviteur> serviteurs = new ArrayList<>(40);

	public void creerListeCartes() {
		/* Il y a 38 cartes serviteurs, donc on rajoute les 38 cartes à la liste */
		  for (int i = 1; i <= 38; i++) {
	            try {
	                String nomClasse = "Cartes.Serviteur" + i;

	                /* Nous devons créer une instance avec réflexion, nécessite l'utilisation d'un try catch */
	                Class<?> clazz = Class.forName(nomClasse);
	                Serviteur s = (Serviteur) clazz.getDeclaredConstructor().newInstance();

	                serviteurs.add(s);

	            } catch (Exception e) {
	                System.out.println("Impossible de créer Serviteur" + i);
	            }	        }
        }


	public List<Serviteur> getServiteurs() {
		System.out.println("ok");
		return serviteurs;
	}
	
	public String montrerServiteurs() {
		String message="";
		int i = 1;
		for (Serviteur creature : serviteurs) {
			message += "- " + i + " - " + creature.getNom() + " Force : " + creature.getDégats() + " HP : "+ creature.getHP() + " Mana : " + creature.getMana() + ". \n";
			i++;
		}
		return message;
		}
	}


