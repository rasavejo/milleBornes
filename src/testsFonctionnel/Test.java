package testsFonctionnel;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;

public class Test {

	public static void main(String[] args) {
		Carte par = new Parade(3,Type.ACCIDENT);
		Carte att = new Attaque(3,Type.ACCIDENT);
		Carte botte = new Botte(1,Type.ACCIDENT);
		Sabot sabot = new Sabot(110);
		sabot.ajouterFamilleCarte(par,att,botte);
		
		for (int i = 0 ; i < 7; i++) System.out.println((sabot.pioche()).toString());
	}

}
