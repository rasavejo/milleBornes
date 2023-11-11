package jeu;

import java.util.List;
import java.util.ArrayList;


public class Jeu {
	List<Joueur> joueurs = new ArrayList<>();
	Sabot sabot;
	
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	public Sabot getSabot() {
		return sabot;
	}
	public void setSabot(Sabot sabot) {
		this.sabot = sabot;
	}
	
	
}
