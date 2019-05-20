package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import modele.Tile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Map {

	private int hauteur, colonne;
	private String nom;
	private ObservableList<Tile> map;
	private String [][] tabSkyValue;
	private String [][] tabGroundValue;
	private String [][] tabObjectsValue;
	
	public Map(String nom) {
		
		this.nom=nom;
		
		map = FXCollections.observableArrayList();
		
		tabSkyValue = new String[32][2];
		
		tabGroundValue = new String[2][2];
		
		tabObjectsValue = new String[8][2];
		
		try {
			
			int i=0;
			
			String ligne ;
			
			//affecter l'image ciel aux tiles ciel
			
			BufferedReader fichier = new BufferedReader(new FileReader("csv/Map_sky.csv"));
			
			while ((ligne = fichier.readLine()) != null) {
				hauteur++;
				colonne=0;
				String[] tab = ligne.split(",");
				
				for (String e : tab) {
					colonne++;
				}
			
			}

			i=0;
			
			tabSkyValue[i][0]="2";
			tabSkyValue[i][1]="imagesMap/sky/sky_2.png";
			i++;
			
			tabSkyValue[i][0]="12";
			tabSkyValue[i][1]="imagesMap/sky/sky_12.png";
			i++;
			
			tabSkyValue[i][0]="13";
			tabSkyValue[i][1]="imagesMap/sky/sky_13.png";
			i++;
			
			tabSkyValue[i][0]="14";
			tabSkyValue[i][1]="imagesMap/sky/sky_14.png";
			i++;
			
			tabSkyValue[i][0]="15";
			tabSkyValue[i][1]="imagesMap/sky/sky_15.png";
			i++;
			
			tabSkyValue[i][0]="16";
			tabSkyValue[i][1]="imagesMap/sky/sky_16.png";
			i++;
			
			tabSkyValue[i][0]="17";
			tabSkyValue[i][1]="imagesMap/sky/sky_17.png";
			i++;

			tabSkyValue[i][0]="18";
			tabSkyValue[i][1]="imagesMap/sky/sky_18.png";
			i++;
			
			tabSkyValue[i][0]="19";
			tabSkyValue[i][1]="imagesMap/sky/sky_19.png";
			i++;

			tabSkyValue[i][0]="20";
			tabSkyValue[i][1]="imagesMap/sky/sky_20.png";
			i++;
			
			tabSkyValue[i][0]="21";
			tabSkyValue[i][1]="imagesMap/sky/sky_21.png";
			i++;
			
			tabSkyValue[i][0]="22";
			tabSkyValue[i][1]="imagesMap/sky/sky_22.png";
			i++;

			tabSkyValue[i][0]="23";
			tabSkyValue[i][1]="imagesMap/sky/sky_23.png";
			i++;
			
			tabSkyValue[i][0]="27";
			tabSkyValue[i][1]="imagesMap/sky/sky_27.png";
			i++;
			
			// affecter les imagesMap au tiles sol

			i=0;
			
			tabGroundValue[i][0]="0";
			tabGroundValue[i][1]="imagesMap/ground/ground_0.png";
			i++;
			
			tabGroundValue[i][0]="1";
			tabGroundValue[i][1]="imagesMap/ground/ground_1.png";
			
			// affecter les imagesMap objects aux tiles
			
			i=0;
					
			tabObjectsValue[i][0]="38";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_38.png";
			i++;
			
			tabObjectsValue[i][0]="40";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_40.png";
			i++;
			
			tabObjectsValue[i][0]="46";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_46.png";
			i++;
			
			tabObjectsValue[i][0]="47";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_47.png";
			i++;
			
			tabObjectsValue[i][0]="51";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_51.png";
			i++;
			
			tabObjectsValue[i][0]="52";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_52.png";
			i++;
			
			tabObjectsValue[i][0]="62";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_62.png";
			i++;
			
			tabObjectsValue[i][0]="63";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_63.png";
			
			tabObjectsValue[i][0]="64";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_64.png";
			
			tabObjectsValue[i][0]="67";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_67.png";
			
			tabObjectsValue[i][0]="68";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_68.png";
			
			tabObjectsValue[i][0]="79";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_79.png";
			
			tabObjectsValue[i][0]="80";
			tabObjectsValue[i][1]="imagesMap/objetcs/objects_80.png";
			
			//affiche le tableau tabValeur
			
			for (int a=0; a<tabSkyValue.length; a++) {
				
				for (int b=0; b<tabSkyValue[a].length; b++) {
					
					System.out.print(tabSkyValue[a][b]+" ");
					
				}
				
				System.out.println("");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String browseSkyTab(String e) {
		for (int ind=0; ind<tabSkyValue.length; ind++) {
			if (e==tabSkyValue[ind][0]) {
				return tabSkyValue[ind][1];
			}
		}
		return null;
	}
	
	public String browseGroundTab(String e) {
		for (int ind=0; ind<tabGroundValue.length; ind++) {
			if (e==tabGroundValue[ind][0]) {
				return tabGroundValue[ind][1];
			}
		}
		return null;
	}
	
	public String browseObjectsTab(String e) {
		for (int ind=0; ind<tabObjectsValue.length; ind++) {
			if (e==tabObjectsValue[ind][0]) {
				return tabObjectsValue[ind][1];
			}
		}
		return null;
	}
	
	public double getTaille() {
		return colonne*hauteur;
	}
	
	public void addTile(Tile t) {
		map.add(t);
	}

}
