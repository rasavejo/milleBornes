package cartes;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
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
