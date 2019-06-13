package modele.inventaire.arme;

import java.util.ArrayList;

import modele.inventaire.Objet;
import modele.inventaire.ressource.Fer;

public class Arme extends Objet{
	
	private int degatsCausés;

	public Arme(String nom, int degats, String valPNG, int r) {
		super(nom, valPNG, r);
		this.degatsCausés = degats;
	}
	
	public int getDegatsCausés() {
		return this.degatsCausés;
	}
}
