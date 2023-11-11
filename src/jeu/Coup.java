package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

public class Coup {
	Carte carte;
	Joueur cible;

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Joueur getCible() {
		return cible;
	}

	public void setCible(Joueur cible) {
		this.cible = cible;
	}

	public Coup(Carte carte, Joueur cible) {
		this.carte = carte;
		this.cible = cible;
	}

	public boolean estValide(Joueur j) {
		if (cible == null)
			return true;
		if (carte instanceof DebutLimite || carte instanceof Attaque) {
			return !cible.equals(j);
		}
		return cible.equals(j);
	}

	public boolean jouer(Joueur j) {
		j.getMain().jouer(carte);
		if (cible == null) {
			j.getJeu().getSabot().ajouterCarte(carte);
			System.out.println("Le joueur " + j + " se défausse de " + carte);
			return true;
		} else {
			if (carte.appliquer(cible)) {
				System.out.println("Le joueur " + j + " vise " + j + " et : " + carte);
				return true;
			}
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Coup coup)
			return coup.getCarte().equals(carte) && coup.getCible().equals(cible);
		return false;
	}

	@Override
	public int hashCode() {
		return (carte.hashCode() + cible.hashCode()) * 31;
	}

}
