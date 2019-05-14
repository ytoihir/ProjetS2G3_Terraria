package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import modele.Tuile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Terrain {

	private String nom;
	private ObservableList<Tuile> terrain = FXCollections.observableArrayList();
	private double taille;
	
	public Terrain(String nom) {
		
		this.nom=nom;
		
		try {
			
			String [][] tabValeur = new String[400][2];
			
			int i=0;
			
			String ligne ;
			
			BufferedReader fichier = new BufferedReader(new FileReader("map2_ground.csv"));
			
			int hauteur=0;
			
			int colonne=0;
			
			while ((ligne = fichier.readLine()) != null) {
				hauteur++;
				colonne=0;
				String[] tab = ligne.split(",");
				
				for (String e : tab) {
					tabValeur[i][0] = e;
					colonne++;
					i++;
				}
			
			}
			
			//affecter l'image ciel aux 180 premières tiles
			
			int cpt=0;
			i=0;
		
			while (cpt!=10) {
				tabValeur[i][1]="images/sky.png";
				terrain.add(new Tuile(hauteur,colonne,tabValeur[i][1],false));
				cpt++;
				i++;
			}
		
			fichier.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public double getTaille() {
		return this.taille;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
}
