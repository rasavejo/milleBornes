package cartes;

import java.util.List;

import jeu.Joueur;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}
	
	public boolean appliquer(Joueur j) {
		List<Limite> limites = j.getLimites();
		
		
		if (limites.isEmpty() || !limites.get(0).equals(this) || j.prioritaire()) {
			return false;
		}
		
		limites.add(0,this);
		return true;
	}
	
	@Override
	public String toString() {
		return "Vous n'êtes désormais plus limité à 50 km ! ";
	}
	
	@Override
	public boolean equals(Object carte) {
		return (carte instanceof FinLimite);
	}
}
