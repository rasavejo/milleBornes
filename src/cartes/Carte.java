package cartes;

import jeu.Joueur;

public abstract class Carte {
	private int nombre;

	protected Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}
	
	public abstract boolean appliquer(Joueur j);

	@Override
	public abstract boolean equals(Object obj);
	
}
