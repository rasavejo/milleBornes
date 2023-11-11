package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cartes.*;
import cartes.Probleme.Type;

public class Joueur {
	String nom;
	List<Limite> limites = new ArrayList<>();
	List<Borne> bornes = new ArrayList<>();
	List<Bataille> batailles = new ArrayList<>();
	Set<Botte> bottes = new HashSet<>();
	Main main = new MainAsListe();
	Jeu jeu;
	

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Main getMain() {
		return main;
	}

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public List<Limite> getLimites() {
		return limites;
	}

	public List<Borne> getBornes() {
		return bornes;
	}

	public List<Bataille> getBatailles() {
		return batailles;
	}

	public Set<Botte> getBottes() {
		return bottes;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(List<Carte> sabot) {
		if (sabot.isEmpty())
			return null;
		Carte carte = sabot.get(0);
		donner(carte);
		return carte;
	}

	public int getKM() {
		int total = 0;
		for (int i = 0; i < bornes.size(); i++)
			total += bornes.get(i).getKm();
		return total;
	}

	public boolean prioritaire() {
		boolean verif = false;

		for (Iterator<Botte> it = bottes.iterator(); it.hasNext() && !verif;) {
			Botte botte = it.next();
			verif = botte.equals(new Botte(1, Type.FEU));
		}

		return verif;
	}

	public int getLimite() {
		if (limites.isEmpty() || limites.get(0) instanceof FinLimite || prioritaire())
			return 200;
		return 50;
	}

	public boolean estBloque() {
		if (batailles.isEmpty())
			return !prioritaire();

		Bataille sommet = batailles.get(0);

		if (sommet.equals(new Parade(1, Type.FEU)))
			return false;
		if (sommet instanceof Parade && prioritaire())
			return false;
		if (sommet.equals(new Attaque(1, Type.FEU)) && prioritaire())
			return false;

		Type type = sommet.getType();

		Boolean verif = false;

		for (Iterator<Botte> it = bottes.iterator(); it.hasNext() && (!verif);) {
			Botte botte = it.next();
			verif = botte.equals(new Botte(1, type));
		}

		return !(verif && prioritaire());

	}

	public Set<Coup> coupsPossible(List<Joueur> participants) {
		Set<Coup> possible = new HashSet<>();

		for (Iterator<Joueur> itJoueur = participants.iterator(); itJoueur.hasNext();) {
			Joueur joueur = itJoueur.next();
			for (Iterator<Carte> itCarte = main.iterator(); itCarte.hasNext();) {
				Carte carte = itCarte.next();
				Coup coup = new Coup(carte, joueur);
				if (coup.estValide(this))
					possible.add(coup);
			}
		}

		return possible;
	}

	public Set<Coup> coupsParDefaut() {
		Set<Coup> possible = new HashSet<>();

		for (Iterator<Carte> itCarte = main.iterator(); itCarte.hasNext();) {
			Carte carte = itCarte.next();
			Coup coup = new Coup(carte, null);
			possible.add(coup);
		}

		return possible;

	}
	
	
	public Coup selectionner() {
		Set<Coup> ensemble = coupsPossible(jeu.getJoueurs());
		if (ensemble.isEmpty()) return null;
		Iterator<Coup> it = ensemble.iterator();
		Coup coup = it.next();
		coup.jouer(this);
		return coup;
	}
	
	public Coup rendreCarte() {
		Set<Coup> ensemble = coupsParDefaut();
		if (ensemble.isEmpty()) return null;
		Iterator<Coup> it = ensemble.iterator();
		Coup coup = it.next();
		coup.jouer(this);
		return coup;
	}

	@Override
	public String toString() {
		return nom;
	}

	@Override
	public boolean equals(Object objet) {
		if (objet instanceof Joueur joueur)
			return joueur.getNom().equals(nom);
		return false;
	}

	@Override
	public int hashCode() {
		return nom.hashCode() * 31;
	}

}
