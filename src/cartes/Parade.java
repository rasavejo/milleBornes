package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type t) {
		super(nombre, t);
	}

	
	@Override
	public String toString() {
		return "Heureusement, vous �vitez un(e) " + type.toString() + ", c'est reparti ! " ;
	}
}
