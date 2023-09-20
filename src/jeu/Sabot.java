package jeu;

import cartes.Carte;

public class Sabot {
	Carte cartes[];
	int nbCartes;

	public Sabot(int nbCartes) {
		cartes = new Carte[nbCartes];
		this.nbCartes =  nbCartes;
	}
	
	
	
	public boolean estVide( ) {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte) throws IllegalStateException {
		if (nbCartes == cartes.length) throw new IllegalStateException();
		cartes[nbCartes] = carte;
		nbCartes ++;
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for (int i = 0; i < carte.getNombre();i++) ajouterCarte(carte);
	}
	
	public void ajouterFamilleCarte(Carte... cartes) {
		for (int n = 0;n < cartes.length;n++)
		for (int i = 0; i < cartes[n].getNombre();i++) 
			ajouterCarte(cartes[n]);
	}

}
