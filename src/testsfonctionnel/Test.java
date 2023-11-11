package testsfonctionnel;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCarte;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme;
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
		
		Limite lim = new DebutLimite(1);
		Carte lim2 = new DebutLimite(2);
		Limite lim3 = new FinLimite(3);
		
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
		lis.add(3);
		lis.add(1);
		lis.add(2);
		lis.add(1);
		lis.add(3);
		lis.add(3);
		lis.add(4);
		
		List<Integer> lis2 = new ArrayList<>();
		
		lis2 = Utils.rassembler(lis);
		for (int i = 0;i<8;i++) System.out.println(lis2.get(i));
		
		System.out.println(Utils.verifierRassemblement(lis));
		System.out.println(Utils.verifierRassemblement(lis2));
		
		System.out.println("\n TEST GET KM\n");
		
		Joueur joueur = new Joueur("MOI");
		
		List<Borne> bornes = joueur.getBornes();
		
		bornes.add(borne);
		
		System.out.println(joueur.getKM());
		
		bornes.add(borne);
		bornes.add(borne);
		bornes.add(borne);
		
		System.out.println(joueur.getKM() == 200);
		
		System.out.println("\n TEST GET LIMITE\n");
		
		System.out.println(joueur.getLimite());
		
		List<Limite> limites = joueur.getLimites();
		
		limites.add(0,lim);
		
		System.out.println(joueur.getLimite());
		
		limites.add(0,lim3);
		
		System.out.println(joueur.getLimite());
		
		limites.add(0,lim);
		
		System.out.println(joueur.getLimite());
		
		Set<Botte> bottes = joueur.getBottes();
		
		Botte botteFeu = new Botte(1,Type.FEU);
		
		bottes.add(botteFeu);
		
		System.out.println(joueur.getLimite());
		
		
		
		System.out.println("\n TEST EST BLOQUE\n");
		
		Joueur j = new Joueur("Rasa");
		
		List<Bataille> bat = j.getBatailles();
		Set<Botte> bot = j.getBottes();
		
		System.out.println(j.estBloque());
		
		bat.add(new Attaque(1,Type.FEU));
		
		System.out.println(j.estBloque());
		
		bot.add(botteFeu);
		
		System.out.println(j.estBloque());
		
		bat.add(0,new Attaque(1,Type.ACCIDENT));
		
		System.out.println(j.estBloque());
		
		
		Botte as = new Botte(1,Type.ACCIDENT);
		bot.add(as);
		
		System.out.println(j.estBloque());
		
		bat.add(0, new Attaque(1,Type.ESSENCE));
		
		System.out.println(j.estBloque());
		
		bat.add(0,new Parade(1,Type.ESSENCE));
		
		System.out.println(j.estBloque());
		
		bot.remove(botteFeu);
		bot.remove(as);
		
		System.out.println(j.estBloque());
		
		bat.add(0,new Parade(1,Type.FEU));
		
		System.out.println(j.estBloque());
		
		System.out.println("\n TEST APPLIQUER \n");
		
		Joueur jou = new Joueur("J");
		Carte c1 = new Parade(0,Probleme.Type.FEU);
		System.out.println("appliquer "+c1+":"+c1.appliquer(jou));
		System.out.println("appliquer "+c1+":"+c1.appliquer(jou));
		Carte c2 = new Attaque(0,Probleme.Type.FEU);
		System.out.println("appliquer "+c2+":"+c2.appliquer(jou));
		System.out.println("appliquer "+borne2+":"+borne2.appliquer(jou));
		System.out.println("appliquer "+botteFeu+":"+botteFeu.appliquer(jou));
		System.out.println("appliquer "+borne2+":"+borne2.appliquer(jou));
		System.out.println("appliquer "+borne2+":"+borne2.appliquer(jou));
		System.out.println("appliquer "+lim+":"+lim.appliquer(jou));
		Carte c3 = new Attaque(0,Probleme.Type.ESSENCE);
		System.out.println("appliquer "+c3+":"+c3.appliquer(jou));
		System.out.println("appliquer "+borne2+":"+borne2.appliquer(jou));
		System.out.println("appliquer "+par+":"+par.appliquer(jou));
		Carte c4 = new Parade(0,Probleme.Type.ESSENCE);
		System.out.println("appliquer "+c4+":"+c4.appliquer(jou));
		
	}

}
