package modele.personnage;

import modele.deplacement.Deplacement;

public class Personnage {

	private String nom;
	private int id;
	private Deplacement mouvement;
	
	public Personnage(int id, String nom, Deplacement mvt) {
		this.id = id;
		this.nom = nom;
		this.mouvement = mvt;
	}
}
