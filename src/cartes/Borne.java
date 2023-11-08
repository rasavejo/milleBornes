package cartes;

import jeu.Joueur;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre,int km) {
		super(nombre);
		this.km = km;
	}
	
	

	public int getKm() {
		return km;
	}
	
	public boolean appliquer(Joueur j) {
		int limite = j.getLimite();
		if (!j.estBloque() && km <= limite && j.getKM() + km <= 1000) {
			j.getBornes().add(this);
			return true;
		}
		return false;
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
