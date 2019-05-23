package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import modele.Tile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Map {
	
	private ObservableList<Tile> map;
	
	private String [] tabMapValue;
	
	private int hauteur, colonne;
	
	private String nom;
	
	public Map(String nom) {
		
		this.nom=nom;
		
		map = FXCollections.observableArrayList();
	
		/*
		 * Le tableau tabMapValue va stocker l'image.png du tile, par ex qu'on si on
		 * veut appeler l'image correspond au tile numéro 2 on fait :
		 * tabMapValue[2] et on à "imagesMap/map_2.png"
		 */

		tabMapValue = new String[32];
		
		int i;
		
		for (i=0; i<tabMapValue.length; i++) {
			tabMapValue[i]="imagesMap/map_"+i+".png";
		}
		
		// La dernière valeur du tableau (ici la 31ième) est égale au tile invisible
		
		tabMapValue[31]="imagesMap/-1Tile.png";
		
		getTab(tabMapValue);
			
		try {
				
			// on ouvre le fichier map.csv et on cr�er des tiles qu'on ajoute � la liste observable map
			
			String ligne ;
			
			BufferedReader fichier = new BufferedReader(new FileReader("CSV/map.csv"));
			
			// On parcourt le fichier map.csv
			
			while ((ligne = fichier.readLine()) != null) {
				hauteur++;
				colonne=0;
				String[] tab = ligne.split(",");

				/*
				 *  On parcourt chaque élement du fichier.csv que l'on est entrain de lire
				 *  si dans le fichier.csv la valeur lue est égale à 0 par exemple
				 *  on cherche dans le tableau tabMapValue la valeur correspondant à l'indice 0
				 *  donc tabMapValue[0], 
				 *  on récupère l'image correspondant à la valeur 0 
				 *  on créer ensuite une tuile avec pour attribut valeurImage l'image correspondant à la valeur 0 
				 */
				
				for (String e : tab) {
					
					rechercheValeurImageTuile(e,tabMapValue);

					colonne++;
					
				}
			
			}
			
			fichier.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void rechercheValeurImageTuile(String e, String[] tab){
	
		int ind;
		
		int posx=0, posy=0;
		
		for (ind=0; ind<tab.length; ind++) {
				
				if(e.equals(tab[ind])) {
							
						map.add(new Tile(posx,posy,tab[ind],false));
								
				}
				
				posx+=32;
				posy+=32;
			
		}
		
	}
	
	public void getTab(String[] tab) {
		
		for (int a=0; a<tab.length; a++) {
			
			System.out.println(tab[a]+" ");
			
		}

	}
	
	public void getListe() {
		for (int i=0; i<this.map.size(); i++) {
			System.out.println(map.get(i));
		}
	}
	
	public double getTaille() {
		return colonne*hauteur;
	}

}
