package cartes;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Vous n'�tes d�sormais plus limit� � 50 km ! ";
	}
}
