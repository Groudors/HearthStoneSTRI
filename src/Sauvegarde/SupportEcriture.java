package Sauvegarde;

public class SupportEcriture {
	private Fichier fichier;
	
	public SupportEcriture(Fichier fichier) {
		this.fichier=fichier;
		}

	
		public void ecrire(String texte) {
			fichier.ecrire(texte);
		}
}