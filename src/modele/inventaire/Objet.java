package modele.inventaire;

import java.util.ArrayList;

import modele.inventaire.ressource.Fer;

public class Objet {

	private String id;
	private String nom;
	private static int no=0;
	private int nbFerNec;
	private String valeurPNG;
	

	public Objet(String nom, String valeurPNG, int nbFer) {
		this.id = "O"+no++;
		this.nom = nom;
		this.valeurPNG=valeurPNG;
		this.nbFerNec = nbFer;
	}
	
	public Objet(String nom, String valeurPNG) {
		this.id = "O"+no++;
		this.nom = nom;
		this.valeurPNG=valeurPNG;
	}
	
	public String getNom() {
		
		return this.nom;
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String toString() {
		
		return this.id +  " " + this.nom + " ";
		
	}

	public int getFerNecessaires() {
		
		return this.nbFerNec;
		
	}
	
	public String setId() {
		return this.id = "O"+no++;
	}
	
	public String getValPNG() {
		return this.valeurPNG;
	}
	
}

