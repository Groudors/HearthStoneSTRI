package Sauvegarde;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier {
	private String chemin;

	public Fichier(String chemin) {
		this.chemin = chemin;
	}

	public void ecrire(String texte) {
		try (FileWriter fichier = new FileWriter(new File(chemin), true)) {
			fichier.write(texte);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
