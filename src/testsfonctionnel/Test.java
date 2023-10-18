package testsfonctionnel;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCarte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Joueur;
import jeu.Sabot;
import jeu.Sabot.Iterateur;

public class Test {

	public static void main(String[] args) {
		Carte par = new Parade(3,Type.ACCIDENT);
		Carte att = new Attaque(3,Type.ACCIDENT);
		Carte botte = new Botte(1,Type.ACCIDENT);
		Sabot sabot = new Sabot(110);
		sabot.ajouterFamilleCarte(par,att,botte);
		
		System.out.println("TEST SABOT\n");
		
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
		
		
		System.out.println("\nTEST EQUALS\n");
		
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
		
		System.out.println("\nTEST JEU/UTILS\n");
		
		JeuDeCarte jeu = new JeuDeCarte();
		List<Carte> liste = jeu.getListeCartes();
		
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i));
		}
		System.out.println(jeu.checkCounts());
		
		
		List<Integer> l = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
	
		
		System.out.println(Utils.extraire(l));

		
		
		for (int i = 0;i<4;i++) System.out.println(l.get(i));
		
		for (int i = 0;i<4;i++) l3.add(l.get(i));
		l2 = Utils.melanger(l);
		
		System.out.println("\nMELANGE\n");
		
		for (int i = 0;i<4;i++) System.out.println(l2.get(i));
		
		System.out.println(Utils.verifierMelange(l2,l3));
		
		Utils.extraire(l2);
		
		System.out.println(Utils.verifierMelange(l2,l3));
		
		List<Integer> lis = new ArrayList<>();
		lis.add(1);
		lis.add(1);
		lis.add(2);
		lis.add(1);
		lis.add(3);
		
		List<Integer> lis2 = new ArrayList<>();
		
		lis2 = Utils.rassembler(lis);
		for (int i = 0;i<5;i++) System.out.println(lis2.get(i));
		
		System.out.println(Utils.verifierRassemblement(lis));
		System.out.println(Utils.verifierRassemblement(lis2));
		
		System.out.println("\n TEST GET KM\n");
		
		Joueur joueur = new Joueur("MOI");
		
		joueur.donner(borne);
		
		
	}

}
