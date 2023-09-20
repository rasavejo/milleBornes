package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	Carte cartes[];
	int nbCartes;
	int nbOp;

	public Sabot(int nbCartes) {
		cartes = new Carte[nbCartes];
		this.nbCartes =  0;
	}
	
	public Carte pioche() {
		Iterateur it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;
	}
	
	public Iterateur iterator() {
		return new Iterateur();
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
	
	
	public class Iterateur implements Iterator<Carte> {
		private int indice = 0;
		private int nombreCartes = nbCartes;
		private boolean nextEffectue = false;
		private int nbOpRef = nbOp;
		
		public Iterateur() {
			
		}
		
		public boolean hasNext() {
			return indice < nbCartes;
		}
		
		public Carte next() throws IllegalStateException,ConcurrentModificationException {
			if (nbOp == nbOpRef)
				if (hasNext()) {
				nextEffectue = true;
				Carte elt = cartes[indice];
				indice ++;
				return elt;
				}
				else throw new IllegalStateException();
			else throw new ConcurrentModificationException();
		}
		
		public void remove() throws IllegalStateException,ConcurrentModificationException {
			if (nbOp == nbOpRef)
				if (nextEffectue) { 
					for (int i = indice-1;i<nombreCartes;i++) cartes[i] = cartes[i+1];
					nextEffectue = false;
				}
					
				else throw new IllegalStateException();
			else throw new ConcurrentModificationException();
		}
		
	}
}
