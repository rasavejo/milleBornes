package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type t) {
		super(nombre, t);
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
