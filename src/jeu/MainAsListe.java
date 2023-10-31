package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements Main {
	List<Carte> cartes = new ArrayList<>();
	Iterator<Carte> it = cartes.iterator();

	public MainAsListe() {
   // Constructeurs toujours identique donc vide.
 }

	@Override
	public void prendre(Carte carte) {
		cartes.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		if (!cartes.contains(carte)) 
			throw new IllegalArgumentException("Vous n'avez pas cette carte");
		cartes.remove(carte);
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartes.iterator();
	}

}
