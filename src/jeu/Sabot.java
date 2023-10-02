package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	Carte[] cartes;
	int nbCartes = 0;
	int nbOp = 0;

	public Sabot(int nbCartes) {
		cartes = new Carte[nbCartes];
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

	public boolean estVide() {
		return nbCartes == 0;
	}

	private void ajouterCarte(Carte carte) throws IllegalStateException {
		if (nbCartes == cartes.length)
			throw new IllegalStateException();
		cartes[nbCartes] = carte;
		nbCartes++;
		nbOp++;
	}

	public void ajouterFamilleCarte(Carte carte) {
		for (int i = 0; i < carte.getNombre(); i++)
			ajouterCarte(carte);
	}

	public void ajouterFamilleCarte(Carte... cartes) {
		for (int n = 0; n < cartes.length; n++)
			for (int i = 0; i < cartes[n].getNombre(); i++)
				ajouterCarte(cartes[n]);
	}

	public class Iterateur implements Iterator<Carte> {
		private int indice = 0;
		private int nombreCartes = nbCartes;
		private boolean nextEffectue = false;
		private int nbOpRef = nbOp;

		public boolean hasNext() {
			return indice < nbCartes;
		}

		public Carte next() throws NoSuchElementException {
			verificationConcurrence();
			if (hasNext()) {
				nextEffectue = true;
				Carte elt = cartes[indice];
				indice++;
				return elt;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() throws IllegalStateException {
			verificationConcurrence();
			if (nextEffectue) {
				for (int i = indice - 1; i < nombreCartes; i++)
					cartes[i] = cartes[i + 1];
				nextEffectue = false;
				nbCartes --;
				nbOp ++;
			} else
				throw new IllegalStateException();
		}

		private void verificationConcurrence() throws ConcurrentModificationException {
			if (nbOp != nbOpRef)
				throw new ConcurrentModificationException();
		}

	}
}
