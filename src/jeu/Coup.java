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
		if (cible.equals(null)) return true;
		if (carte instanceof DebutLimite || carte instanceof Attaque) {
			return !cible.equals(j);
		}
		return cible.equals(j);
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
