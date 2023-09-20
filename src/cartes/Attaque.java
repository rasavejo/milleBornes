package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type t) {
		super(nombre, t);
	}

	@Override
	public String toString() {
		return "Oh non ! Vous subissez un(e) " + type.toString() + " ! ";
	}
}
