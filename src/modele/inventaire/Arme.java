package modele.inventaire;

public class Arme extends Objet{
	
	private int degatsCausés;

	public Arme(int id, String nom, int degats) {
		super(id, nom);
		this.degatsCausés = degats;
		
	}
	

	public int getDegatsCausés() {
		return this.degatsCausés;
	}
}
