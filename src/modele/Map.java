package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import modele.Tile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Map {
	
	private ObservableList<Tile> map;
	
	private String [][] tabSkyValue;
	
	private String [][] tabGroundValue;
	
	private String [][] tabObjectsValue;
	
	private int hauteur, colonne;
	
	private String nom;
	
	public Map(String nom) {
		
		this.nom=nom;
		
		map = FXCollections.observableArrayList();
		
		tabSkyValue = new String[14][2];
		
		tabGroundValue = new String[2][2];
		
		tabObjectsValue = new String[13][2];
		
		try {
	
			// affecter les imagesMap au tiles ciel
			
			int i=0;
			
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
			
			// affecter les imagesMap au tiles sol

			i=0;
			
			tabGroundValue[i][0]="0";
			tabGroundValue[i][1]="imagesMap/ground/ground_0.png";
			i++;
			
			tabGroundValue[i][0]="1";
			tabGroundValue[i][1]="imagesMap/ground/ground_1.png";
			
			// affecter les imagesMap aux tiles objets
			
			i=0;
					
			tabObjectsValue[i][0]="38";
			tabObjectsValue[i][1]="imagesMap/objects/objects_38.png";
			i++;
			
			tabObjectsValue[i][0]="40";
			tabObjectsValue[i][1]="imagesMap/objects/objects_40.png";
			i++;
			
			tabObjectsValue[i][0]="46";
			tabObjectsValue[i][1]="imagesMap/objects/objects_46.png";
			i++;
			
			tabObjectsValue[i][0]="47";
			tabObjectsValue[i][1]="imagesMap/objects/objects_47.png";
			i++;
			
			tabObjectsValue[i][0]="51";
			tabObjectsValue[i][1]="imagesMap/objects/objects_51.png";
			i++;
			
			tabObjectsValue[i][0]="52";
			tabObjectsValue[i][1]="imagesMap/objects/objects_52.png";
			i++;
			
			tabObjectsValue[i][0]="62";
			tabObjectsValue[i][1]="imagesMap/objects/objects_62.png";
			i++;
			
			tabObjectsValue[i][0]="63";
			tabObjectsValue[i][1]="imagesMap/objects/objects_63.png";
			i++;
			
			tabObjectsValue[i][0]="64";
			tabObjectsValue[i][1]="imagesMap/objects/objects_64.png";
			i++;
			
			tabObjectsValue[i][0]="67";
			tabObjectsValue[i][1]="imagesMap/objects/objects_67.png";
			i++;
			
			tabObjectsValue[i][0]="68";
			tabObjectsValue[i][1]="imagesMap/objects/objects_68.png";
			i++;
			
			tabObjectsValue[i][0]="79";
			tabObjectsValue[i][1]="imagesMap/objects/objects_79.png";
			i++;
			
			tabObjectsValue[i][0]="80";
			tabObjectsValue[i][1]="imagesMap/objects/objects_80.png";

			for (int a=0; a<tabSkyValue.length; a++) {
			
				for (int b=0; b<tabSkyValue[a].length; b++) {
					
					System.out.print(tabSkyValue[a][b]+" ");
					
				}
				
				System.out.println("");
			}
			
			// créer tiles pour le ciel
			
			int ind=0;
			
			String ligne ;
			
			BufferedReader fichier = new BufferedReader(new FileReader("MAPS CSV + JSON/map/Map_sky.csv"));
			
			while ((ligne = fichier.readLine()) != null) {
				hauteur++;
				colonne=0;
				String[] tab = ligne.split(",");
				
				for (String e : tab) {
					colonne++;
					if(e==tabSkyValue[ind][0]) {
						map.add(new Tile(0,0,tabSkyValue[ind][1],false));
					}
				}
			
			}
			
			fichier.close();
			
			// créer tiles pour le sol
			
			ind=0;
			
			fichier = new BufferedReader(new FileReader("MAPS CSV + JSON/map/Map_ground.csv"));
						
			while ((ligne = fichier.readLine()) != null) {
				String[] tab = ligne.split(",");
								
				for (String e : tab) {
						if(e==tabGroundValue[ind][0]) {
								map.add(new Tile(0,0,tabGroundValue[ind][1],false));
						}
				}
						
			}
			
			fichier.close();
			
			// créer tiles pour les objets
			
			ind=0;
						
			fichier = new BufferedReader(new FileReader("MAPS CSV + JSON/map/Map_objects.csv"));
									
			while ((ligne = fichier.readLine()) != null) {
				String[] tab = ligne.split(",");
											
				for (String e : tab) {
						if(e==tabObjectsValue[ind][0]) {
							map.add(new Tile(0,0,tabObjectsValue[ind][1],false));
						}
				}

			}
			
			fichier.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public double getTaille() {
		return colonne*hauteur;
	}

}
