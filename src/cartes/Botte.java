package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class Botte extends Probleme {

	public Botte(int nombre, Type t) {
		super(nombre, t);
	}
	
	public boolean appliquer(Joueur j) {
		Set<Botte> bottes = j.getBottes();
		if (bottes.contains(this)) {
			return false;
		}
		bottes.add(this);
		
		List<Bataille> batailles = j.getBatailles();
		Bataille sommet = batailles.get(0);
		
		if (sommet.getType() == this.getType()) {
			batailles.remove(0);
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cette botte vous prot�ge de l'avarie " + getType().toString() + " ! "; 
	}
	
	@Override
	public boolean equals(Object carte) {
		if (carte instanceof Botte botte)
			return botte.getType() == getType();
		else return false;
	}
}
