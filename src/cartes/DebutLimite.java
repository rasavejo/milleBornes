package cartes;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Vous �tes d�sormais limit� � 50 km ! ";
	}

}
