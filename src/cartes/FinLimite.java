package cartes;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Vous n'êtes désormais plus limité à 50 km ! ";
	}
}
