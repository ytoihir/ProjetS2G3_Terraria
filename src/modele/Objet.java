package modele;

import java.util.ArrayList;

public class Objet {

	private String id;
	private String nom;
	private String desc;
	private static int no=0;
	private ArrayList<Ressource> ressources;
	private String valeurPNG;
	

	public Objet(String nom, String description, String valeurPNG, ArrayList<Ressource> r) {
		this.id = "O"+no++;
		this.nom = nom;
		this.desc = description;
		this.valeurPNG=valeurPNG;
		this.ressources=new ArrayList<>();
		this.ressources=r;
	}
	
	public Objet(String nom, String description, String valeurPNG) {
		this.id = "O"+no++;
		this.nom = nom;
		this.desc = description;
		this.valeurPNG=valeurPNG;
	}
	
	public String getNom() {
		
		return this.nom;
		
	}
	
	public String getDesc() {
		
		return this.desc;
		
		
	}
	
	public String toString() {
		
		return this.id +  " " + this.nom + " " + this.desc;
		
	}

	public ArrayList<Ressource> getRessource() {
		
		return ressources;
		
	}
	
	public String getValPNG() {
		return this.valeurPNG;
	}
	
	
}
