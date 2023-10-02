package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type t) {
		super(nombre, t);
	}

	@Override
	public String toString() {
		return "Oh non ! Vous subissez un(e) " + getType().toString() + " ! ";
	}
	
	@Override
	public boolean equals(Object carte) {
		if (carte instanceof Attaque attaque)
			return attaque.getType() == getType();
		else return false;
	}
	
}
