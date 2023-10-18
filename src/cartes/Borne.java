package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre,int km) {
		super(nombre);
		this.km = km;
	}
	
	

	public int getKm() {
		return km;
	}



	@Override
	public String toString() {
		return "Avancez de " + km + " km !";
	}
	
	@Override
	public boolean equals(Object carte) {
		if (carte instanceof Borne borne) {
			return borne.km == this.km;
		}
		return false;
	}
}
