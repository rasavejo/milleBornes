package cartes;

public abstract class Probleme extends Carte {
	enum Type { FEU,ESSENCE,CREVAISON,ACCIDENT};
	Type type;

	public Probleme(int nombre,Type t) {
		super(nombre);
		this.type = t;
	}

}
