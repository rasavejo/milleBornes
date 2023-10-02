package testsfonctionnel;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCarte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;
import jeu.Sabot.Iterateur;

public class Test {

	public static void main(String[] args) {
		Carte par = new Parade(3,Type.ACCIDENT);
		Carte att = new Attaque(3,Type.ACCIDENT);
		Carte botte = new Botte(1,Type.ACCIDENT);
		Sabot sabot = new Sabot(110);
		sabot.ajouterFamilleCarte(par,att,botte);
		
		for (int i = 0 ; i < 7; i++)  {
			System.out.println((sabot.pioche()).toString());
		}
		
		sabot.ajouterFamilleCarte(par,att,botte);
		Carte carte;
		Iterateur it = sabot.iterator();

		for (int i = 0 ; i < 7; i++)  {
			carte = it.next();
			System.out.println(carte.toString());
		}
		
		
		sabot.ajouterFamilleCarte(botte);
		System.out.println(sabot.pioche());
		
		
		
		Carte par2 = new Parade(5,Type.ACCIDENT);
		System.out.println(par2.equals(par));
		
		Carte lim = new DebutLimite(1);
		Carte lim2 = new DebutLimite(2);
		Carte lim3 = new FinLimite(3);
		
		System.out.println(lim.equals(lim2));
		System.out.println(lim.equals(lim3));
		
		Borne borne = new Borne(5,50);
		Borne borne2 = new Borne(5,100);
		
		System.out.println(borne.equals(borne2));
		
		JeuDeCarte jeu = new JeuDeCarte();
		Carte[] liste = jeu.getListeCartes();
		
		for (int i = 0;i<liste.length;i++) {
			System.out.println(liste[i]);
		}
		System.out.println(jeu.checkCounts());
	}

}
