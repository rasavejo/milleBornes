package cartes;

import cartes.Probleme.Type;

public class JeuDeCarte {
	Carte[] typesDeCarte = new Carte[19];
	Carte[] listeCartes = new Carte[106];

	public JeuDeCarte() {
		typesDeCarte[0] = new Botte(1, Type.FEU);
		typesDeCarte[1] = new Botte(1, Type.ESSENCE);
		typesDeCarte[2] = new Botte(1, Type.CREVAISON);
		typesDeCarte[3] = new Botte(1, Type.ACCIDENT);
		typesDeCarte[4] = new Attaque(5, Type.FEU);
		typesDeCarte[5] = new Attaque(3, Type.ESSENCE);
		typesDeCarte[6] = new Attaque(3, Type.CREVAISON);
		typesDeCarte[7] = new Attaque(3, Type.ACCIDENT);
		typesDeCarte[8] = new Parade(14, Type.FEU);
		typesDeCarte[9] = new Parade(6, Type.ESSENCE);
		typesDeCarte[10] = new Parade(6, Type.CREVAISON);
		typesDeCarte[11] = new Parade(6, Type.ACCIDENT);
		typesDeCarte[12] = new DebutLimite(4);
		typesDeCarte[13] = new FinLimite(6);
		typesDeCarte[14] = new Borne(10, 25);
		typesDeCarte[15] = new Borne(10, 50);
		typesDeCarte[16] = new Borne(10, 75);
		typesDeCarte[17] = new Borne(12, 100);
		typesDeCarte[18] = new Borne(4, 200);

		int n = 0;

		for (int i = 0; i < 19; i++) {
			Carte type = typesDeCarte[i];
			for (int j = 0; j < type.getNombre(); j++) {
				listeCartes[n] = type;
				n++;
			}
		}

	}

	public Carte[] getListeCartes() {
		return listeCartes;
	}
	
	public boolean checkCounts() {
		boolean verif = true;
		for (int i = 0;i<19 && verif;i++) {
			int compteur = 0;
			Carte carte = typesDeCarte[i];
			for (int j = 0;j<106;j++) {
				if (listeCartes[j].equals(carte)) compteur ++;
			}
			verif = verif && (compteur == carte.getNombre());
		}
		return verif;
	}

}
