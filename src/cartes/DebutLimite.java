package cartes;

import java.util.List;

import jeu.Joueur;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}
	
	public boolean appliquer(Joueur j) {
		List<Limite> limites = j.getLimites();
		
		
		if ((!limites.isEmpty() && limites.get(0).equals(this)) || j.prioritaire()) {
			return false;
		}
		
		limites.add(0,this);
		return true;
	}
	
	@Override
	public String toString() {
		return "Vous êtes désormais limité à 50 km ! ";
	}
	
	@Override
	public boolean equals(Object carte) {
		return (carte instanceof DebutLimite);
	}

}
