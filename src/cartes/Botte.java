package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type t) {
		super(nombre, t);
	}

	@Override
	public String toString() {
		return "Cette botte vous protège de l'avarie " + type.toString() + " ! "; 
	}
}
