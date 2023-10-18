package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Utils {

	public static <C> C extraire(List<C> liste) {
		Random rand = new Random();
		int alea = rand.nextInt(liste.size());

		// C elt = liste.get(alea);
		// liste.remove(alea);

		C elt = null;
		Iterator<C> it = liste.iterator();
		for (int i = 0; i <= alea; i++)
			elt = it.next();
		it.remove();

		return elt;
	}

	public static <C> List<C> melanger(List<C> liste) {
		List<C> retour = new ArrayList<>();
		int n = liste.size();
		for (int i = 0; i < n; i++) {
			retour.add(extraire(liste));
		}
		return retour;
	}
	
/*	private <C> int frequence(List<C> liste, C elt) {
		int total = 0;
		for (int i = 0;i <liste.size();i++)
			if (liste.get(i) == elt) total ++;
		return total;
	}
*/

	public static <C> boolean verifierMelange(List<C> liste1, List<C> liste2) {
		boolean verif = true;
		for (int i = 0; i < liste1.size() && verif; i++) {
			C elt = liste1.get(i);
			verif = (Collections.frequency(liste1, elt) == Collections.frequency(liste2, elt));
		}
		for (int i = 0; i < liste2.size() && verif; i++) {
			C elt = liste2.get(i);
			verif = (Collections.frequency(liste1, elt) == Collections.frequency(liste2, elt));
		}
		return verif;
	}

	public static <C> List<C> rassembler(List<C> liste) {
		List<C> retour = new ArrayList<>();
		for (int i = 0; i < liste.size(); i++) {
			C elt = liste.get(i);
			if (!retour.contains(elt)) {
				retour.add(elt);
				for (int j = i + 1; j < liste.size(); j++) {
					C elt2 = liste.get(j);
					if (elt == elt2) {
						retour.add(elt2);
					}
				}
			}

		}
		return retour;
	}

	public static <C> boolean verifierRassemblement(List<C> liste) {
		Iterator<C> it = liste.iterator();

		boolean verif = true;

		for (int i = 0; i < liste.size() && verif; i++) {
			C elt = it.next();
			Iterator<C> it2 = liste.iterator();
			C elt2;
			if (it2.hasNext()) {
				do {
					elt2 = it2.next();
				} while (elt != elt2);
			}
			if (it2.hasNext()) {
				do {
					elt2 = it2.next();
				} while (elt == elt2);
			}

			while (it2.hasNext() && verif) {
				elt2 = it2.next();
				verif = (elt != elt2);
			}
		}
		return verif;

	}

}
