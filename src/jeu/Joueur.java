package jeu;

import java.util.ArrayList;
import java.util.HashSet;
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
		 if (sabot.isEmpty()) return null;
		 Carte carte = sabot.get(0);
		 donner(carte);
		 return carte;
	}
	
	public int getKM() {
		int total = 0;
		for (int i = 0; i<bornes.size();i++) 
			total += bornes.get(i).getKm();
		return total;
	}
	
	private boolean prioritaire() {
		return bottes.contains(new Botte(1,Type.FEU));
	}
	
	public int getLimite() {
		if (limites.size() == 0 || limites.get(0) instanceof FinLimite || prioritaire()) return 200;
		return 50;
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

}
