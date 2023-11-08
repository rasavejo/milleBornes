package cartes;

import java.util.List;

import jeu.Joueur;

public class Parade extends Bataille {

	public Parade(int nombre, Type t) {
		super(nombre, t);
	}
	
	public boolean appliquer(Joueur j) {
		List<Bataille> batailles = j.getBatailles();

		
		if (batailles.isEmpty()) {
			if (this.getType() == Type.FEU) {
				batailles.add(0,this);
				return true;
			}
			return false;
		}
	
		
		if (batailles.get(0).getType() == this.getType() && batailles.get(0) instanceof Attaque) {
			batailles.add(0, this);
			return true;
		}
		
		return false;
		
	}

	
	@Override
	public String toString() {
		return "Heureusement, vous évitez un(e) " + getType().toString() + ", c'est reparti ! " ;
	}
	
	@Override
	public boolean equals(Object carte) {
		if (carte instanceof Parade parade)
			return parade.getType() == getType();
		else return false;
	}
}
