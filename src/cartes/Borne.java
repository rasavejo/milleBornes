package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre,int km) {
		super(nombre);
		this.km = km;
	}

	@Override
	public String toString() {
		return "Avancez de " + km + " km !";
	}
}
