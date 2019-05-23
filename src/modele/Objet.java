package modele;

import java.util.ArrayList;

public class Objet {

	private String id;
	private String nom;
	private String desc;
	private static int no=0;
	private ArrayList<Ressource> ressources;
	

	public Objet(String nom, String description) {
		this.id = "O"+no++;
		this.nom = nom;
		this.desc = description;
		ressources=new ArrayList<>();
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
	
}















