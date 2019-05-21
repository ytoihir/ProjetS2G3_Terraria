package application;

public class Arme extends Objet{
	
	private int degatsCausés;

	public Arme(int id, String nom, String desc, int degats) {
		super(id, nom, desc);
		this.degatsCausés = degats;
		
	}

	public int getDegatsCausés() {
		return this.degatsCausés;
	}
}
