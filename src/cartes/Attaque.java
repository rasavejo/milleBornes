package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type t) {
		super(nombre, t);
	}

	public boolean appliquer(Joueur j) {
		List<Bataille> batailles = j.getBatailles();
		Set<Botte> bottes = j.getBottes();

		if (bottes.contains(new Botte(1, this.getType()))) {
			return false;
		}

		if ((batailles.isEmpty() && !j.prioritaire()) || batailles.get(0) instanceof Attaque) {
			return false;
		}
		batailles.add(0, this);
		return true;

	}

	@Override
	public String toString() {
		return "Oh non ! Vous subissez un(e) " + getType().toString() + " ! ";
	}

	@Override
	public boolean equals(Object carte) {
		if (carte instanceof Attaque attaque)
			return attaque.getType() == getType();
		else
			return false;
	}

}
