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
	private String [][] tabBuildingsValue;
	private String [][] tabObjectsValue;
	
	public Map(String nom) {
		
		this.nom=nom;
		
		map = FXCollections.observableArrayList();
		
		tabSkyValue = new String[32][2];
		
		tabGroundValue = new String[2][2];
		
		tabBuildingsValue = new String [16][2];
		
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
			
			tabSkyValue[i][0]="0";
			tabSkyValue[i][1]="images/sky/sky_0.png";
			i++;
			
			tabSkyValue[i][0]="64";
			tabSkyValue[i][1]="images/sky/sky_64.png";
			i++;
			
			tabSkyValue[i][0]="65";
			tabSkyValue[i][1]="images/sky/sky_65.png";
			i++;
			
			tabSkyValue[i][0]="66";
			tabSkyValue[i][1]="images/sky/sky_66.png";
			i++;
			
			tabSkyValue[i][0]="67";
			tabSkyValue[i][1]="images/sky/sky_67.png";
			i++;
			
			tabSkyValue[i][0]="68";
			tabSkyValue[i][1]="images/sky/sky_68.png";
			i++;
			
			tabSkyValue[i][0]="69";
			tabSkyValue[i][1]="images/sky/sky_69.png";
			i++;

			tabSkyValue[i][0]="72";
			tabSkyValue[i][1]="images/sky/sky_72.png";
			i++;
			
			tabSkyValue[i][0]="73";
			tabSkyValue[i][1]="images/sky/sky_73.png";
			i++;

			tabSkyValue[i][0]="74";
			tabSkyValue[i][1]="images/sky/sky_74.png";
			i++;
			
			tabSkyValue[i][0]="75";
			tabSkyValue[i][1]="images/sky/sky_75.png";
			i++;
			
			tabSkyValue[i][0]="76";
			tabSkyValue[i][1]="images/sky/sky_76.png";
			i++;

			tabSkyValue[i][0]="77";
			tabSkyValue[i][1]="images/sky/sky_77.png";
			i++;
			
			tabSkyValue[i][0]="78";
			tabSkyValue[i][1]="images/sky/sky_78.png";
			i++;
			
			tabSkyValue[i][0]="79";
			tabSkyValue[i][1]="images/sky/sky_79.png";
			i++;
			
			tabSkyValue[i][0]="80";
			tabSkyValue[i][1]="images/sky/sky_80.png";
			i++;

			tabSkyValue[i][0]="81";
			tabSkyValue[i][1]="images/sky/sky_81.png";
			i++;
			
			tabSkyValue[i][0]="82";
			tabSkyValue[i][1]="images/sky/sky_82.png";
			i++;
			
			tabSkyValue[i][0]="83";
			tabSkyValue[i][1]="images/sky/sky_83.png";
			i++;
			
			tabSkyValue[i][0]="84";
			tabSkyValue[i][1]="images/sky/sky_84.png";
			i++;
			
			tabSkyValue[i][0]="85";
			tabSkyValue[i][1]="images/sky/sky_85.png";
			i++;
			
			tabSkyValue[i][0]="86";
			tabSkyValue[i][1]="images/sky/sky_86.png";
			i++;
			
			tabSkyValue[i][0]="87";
			tabSkyValue[i][1]="images/sky/sky_87.png";
			i++;
			
			tabSkyValue[i][0]="88";
			tabSkyValue[i][1]="images/sky/sky_88.png";
			i++;
			
			tabSkyValue[i][0]="89";
			tabSkyValue[i][1]="images/sky/sky_89.png";
			i++;
			
			tabSkyValue[i][0]="90";
			tabSkyValue[i][1]="images/sky/sky_90.png";
			i++;
			
			tabSkyValue[i][0]="91";
			tabSkyValue[i][1]="images/sky/sky_91.png";
			i++;
			
			tabSkyValue[i][0]="92";
			tabSkyValue[i][1]="images/sky/sky_92.png";
			i++;
			
			tabSkyValue[i][0]="93";
			tabSkyValue[i][1]="images/sky/sky_93.png";
			i++;
			
			tabSkyValue[i][0]="94";
			tabSkyValue[i][1]="images/sky/sky_94.png";
			i++;
			
			tabSkyValue[i][0]="95";
			tabSkyValue[i][1]="images/sky/sky_95.png";
			i++;

			tabSkyValue[i][0]="100";
			tabSkyValue[i][1]="images/sky/sky_100.png";
			
			// affecter les images au tiles sol

			i=0;
			
			tabGroundValue[i][0]="28";
			tabGroundValue[i][1]="images/ground/ground_28.png";
			i++;
			
			tabGroundValue[i][0]="45";
			tabGroundValue[i][1]="images/ground/ground_45.png";
			
			// affecter les images buildings aux tiles
			
			i=0;
			
			tabBuildingsValue[i][0]="9";
			tabBuildingsValue[i][1]="images/buildings/buildings_9.png";
			i++;
			
			tabBuildingsValue[i][0]="10";
			tabBuildingsValue[i][1]="images/buildings/buildings_10.png";
			i++;
			
			tabBuildingsValue[i][0]="18";
			tabBuildingsValue[i][1]="images/buildings/buildings_18.png";
			i++;
			
			tabBuildingsValue[i][0]="19";
			tabBuildingsValue[i][1]="images/buildings/buildings_19.png";
			i++;
			
			tabBuildingsValue[i][0]="27";
			tabBuildingsValue[i][1]="images/buildings/buildings_27.png";
			i++;
			
			tabBuildingsValue[i][0]="28";
			tabBuildingsValue[i][1]="images/buildings/buildings_28.png";
			i++;
			
			tabBuildingsValue[i][0]="30";
			tabBuildingsValue[i][1]="images/buildings/buildings_30.png";
			i++;
			
			tabBuildingsValue[i][0]="31";
			tabBuildingsValue[i][1]="images/buildings/buildings_31.png";
			i++;
			
			tabBuildingsValue[i][0]="34";
			tabBuildingsValue[i][1]="images/buildings/buildings_34.png";
			i++;
			
			tabBuildingsValue[i][0]="35";
			tabBuildingsValue[i][1]="images/buildings/buildings_35.png";
			i++;
			
			tabBuildingsValue[i][0]="36";
			tabBuildingsValue[i][1]="images/buildings/buildings_36.png";
			i++;
			
			tabBuildingsValue[i][0]="37";
			tabBuildingsValue[i][1]="images/buildings/buildings_37.png";
			i++;
			
			tabBuildingsValue[i][0]="38";
			tabBuildingsValue[i][1]="images/buildings/buildings_38.png";
			i++;
			
			tabBuildingsValue[i][0]="39";
			tabBuildingsValue[i][1]="images/buildings/buildings_39.png";
			i++;
			
			tabBuildingsValue[i][0]="40";
			tabBuildingsValue[i][1]="images/buildings/buildings_40.png";
			i++;
			
			tabBuildingsValue[i][0]="43";
			tabBuildingsValue[i][1]="images/buildings/buildings_43.png";	
			
			// affecter les images objects aux tiles
			
			i=0;
					
			tabObjectsValue[i][0]="36";
			tabObjectsValue[i][1]="images/objetcs/objects_36.png";
			i++;
			
			tabObjectsValue[i][0]="60";
			tabObjectsValue[i][1]="images/objetcs/objects_60.png";
			i++;
			
			tabObjectsValue[i][0]="108";
			tabObjectsValue[i][1]="images/objetcs/objects_108.png";
			i++;
			
			tabObjectsValue[i][0]="152";
			tabObjectsValue[i][1]="images/objetcs/objects_152.png";
			i++;
			
			tabObjectsValue[i][0]="176";
			tabObjectsValue[i][1]="images/objetcs/objects_176.png";
			i++;
			
			tabObjectsValue[i][0]="200";
			tabObjectsValue[i][1]="images/objetcs/objects_200.png";
			i++;
			
			tabObjectsValue[i][0]="223";
			tabObjectsValue[i][1]="images/objetcs/objects_223.png";
			i++;
			
			tabObjectsValue[i][0]="224";
			tabObjectsValue[i][1]="images/objetcs/objects_224.png";
			
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
	
	public String browseBuildingsTab(String e) {
		for (int ind=0; ind<tabBuildingsValue.length; ind++) {
			if (e==tabBuildingsValue[ind][0]) {
				return tabBuildingsValue[ind][1];
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
