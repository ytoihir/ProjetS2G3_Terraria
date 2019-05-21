package application;

import java.io.*;
import application.Constantes;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;

public class SampleController implements Initializable {

	@FXML
    private Pane pane;

    @FXML
    private Pane affichageMapCiel;
    
    @FXML
    private Pane affichageMapSol;

    @FXML
    private ImageView perso;
    
//    @FXML
//    void gaucheOuDroite(KeyEvent event) {
//    	KeyCode touche = event.getCode();
//    	switch (touche) {
//    	case RIGHT:
//    		perso.setImage(personnageRegardantADroite);
//    		break;
//    	case LEFT:
//    		perso.setImage(personnageRegardantAGauche);
//    		break;
//    	}
//    }
    
    @FXML
    void Saut(KeyEvent event) {
    	KeyCode touche = event.getCode();
    	switch (touche) {
    	case SPACE:
			perso.setTranslateY(perso.getTranslateY() - 4.0);
			break;
		}
//    	while (perso.getTranslateY() != 512) {
//    		perso.setTranslateY(perso.getTranslateY() + 2.0);
//    	}
    }
    
    


    
    @FXML
	void enArret(KeyEvent event) {
		perso.setTranslateX(perso.getTranslateX());
		perso.setTranslateY(perso.getTranslateY());
		KeyCode toucheLibere = event.getCode();
		switch (toucheLibere) {
		case RIGHT:
			perso.setImage(Constantes.personnageRegardantADroite);
			break;
		case LEFT:
			perso.setImage(Constantes.personnageRegardantAGauche);
			break;
		}
    }
    
    

	@FXML
	void enMouvement(KeyEvent event) {
		KeyCode key = event.getCode();
		switch (key) {
		case UP:
			perso.setImage(Constantes.personnageVuDeDos);
			break;
		case DOWN:
			perso.setImage(Constantes.personnageIdle);
			break;
		case RIGHT:
			perso.setImage(Constantes.personnageRegardantADroite);
			perso.setImage(Constantes.personnageCourantADroite);
			if (perso.getTranslateX() == 612) {
				System.out.println("On ne peut pas aller plus à droite !");
				perso.setTranslateX(perso.getTranslateX() + 0.0);
			}
			else {
				perso.setTranslateX(perso.getTranslateX() + 4.0);
			}
			break;
		case LEFT:
			perso.setImage(Constantes.personnageRegardantAGauche);
			perso.setImage(Constantes.personnageCourantAGauche);
			if (perso.getTranslateX() == 0) {
				System.out.println("On ne peut pas aller plus à gauche !");
				perso.setTranslateX(perso.getTranslateX() + 0.0);
			}
			else {
				perso.setTranslateX(perso.getTranslateX() - 4.0);
			}
			break;		
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// affichageMap.setPrefColumns(20);
		// affichageMap.setPrefRows(20);
		// affichageMap.setPrefTileHeight(32);
		// affichageMap.setPrefTileWidth(32);
		
		perso.setFocusTraversable(true);
//		perso.setImage(Constantes.personnageIdle);
		perso.setX(0);
		perso.setY(16*32);
		BufferedReader br = null;
		String ligne = "";
		String virgule = ",";

		try {

			br = new BufferedReader(new FileReader(Constantes.fichierCSV1));
			int l=0;
			while ((ligne = br.readLine()) != null) {
				String[] mapCiel = ligne.split(virgule);
				//System.out.println(map.toString());
				
				for (int i = 0; i < mapCiel.length; i++) {
					//System.out.println("map à la ligne l ="+ l + "col : "+ i + "valeur à cette case"+ mapCiel[i]);
					if (mapCiel[i].equals("2")) {
						ImageView blocCiel2 = new ImageView();
						blocCiel2.setImage(Constantes.ciel2);
						blocCiel2.setX(i*32);
						blocCiel2.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel2);
					}

					if (mapCiel[i].equals("12")) {
						ImageView blocSol12 = new ImageView();
						blocSol12.setImage(Constantes.ciel12);
						blocSol12.setX(i*32);
						blocSol12.setY(l*32);
						affichageMapCiel.getChildren().add(blocSol12);
					}

					if (mapCiel[i].equals("13")) {
						ImageView blocCiel13 = new ImageView();
						blocCiel13.setImage(Constantes.ciel13);
						blocCiel13.setX(i*32);
						blocCiel13.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel13);
					}
					
					if (mapCiel[i].equals("14")) {
						ImageView blocCiel14 = new ImageView();
						blocCiel14.setImage(Constantes.ciel14);
						blocCiel14.setX(i*32);
						blocCiel14.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel14);
					}
					
					if (mapCiel[i].equals("15")) {
						ImageView blocCiel15 = new ImageView();
						blocCiel15.setImage(Constantes.ciel15);
						blocCiel15.setX(i*32);
						blocCiel15.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel15);
					}
					
					if (mapCiel[i].equals("16")) {
						ImageView blocCiel16 = new ImageView();
						blocCiel16.setImage(Constantes.ciel16);
						blocCiel16.setX(i*32);
						blocCiel16.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel16);
					}
					
					if (mapCiel[i].equals("17")) {
						ImageView blocCiel17 = new ImageView();
						blocCiel17.setImage(Constantes.ciel17);
						blocCiel17.setX(i*32);
						blocCiel17.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel17);
					}
					
					if (mapCiel[i].equals("18")) {
						ImageView blocCiel18 = new ImageView();
						blocCiel18.setImage(Constantes.ciel18);
						blocCiel18.setX(i*32);
						blocCiel18.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel18);
					}
					
					if (mapCiel[i].equals("19")) {
						ImageView blocCiel19 = new ImageView();
						blocCiel19.setImage(Constantes.ciel19);
						blocCiel19.setX(i*32);
						blocCiel19.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel19);
					}
					
					if (mapCiel[i].equals("20")) {
						ImageView blocCiel20 = new ImageView();
						blocCiel20.setImage(Constantes.ciel20);
						blocCiel20.setX(i*32);
						blocCiel20.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel20);
					}
					
					if (mapCiel[i].equals("21")) {
						ImageView blocCiel21 = new ImageView();
						blocCiel21.setImage(Constantes.ciel21);
						blocCiel21.setX(i*32);
						blocCiel21.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel21);
					}
					
					if (mapCiel[i].equals("22")) {
						ImageView blocCiel22 = new ImageView();
						blocCiel22.setImage(Constantes.ciel22);
						blocCiel22.setX(i*32);
						blocCiel22.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel22);
					}
					
					if (mapCiel[i].equals("23")) {
						ImageView blocCiel23 = new ImageView();
						blocCiel23.setImage(Constantes.ciel23);
						blocCiel23.setX(i*32);
						blocCiel23.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel23);
					}
					
					if (mapCiel[i].equals("27")) {
						ImageView blocCiel27 = new ImageView();
						blocCiel27.setImage(Constantes.ciel27);
						blocCiel27.setX(i*32);
						blocCiel27.setY(l*32);
						affichageMapCiel.getChildren().add(blocCiel27);
					}

				}
				l++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
		BufferedReader nouveauBr = null;
		String nouvelleLigne = "";
		String pointVirgule = ";";
		
		try {

			nouveauBr = new BufferedReader(new FileReader(Constantes.fichierCSV2));
			int l=0;
			while ((nouvelleLigne = nouveauBr.readLine()) != null) {
				String[] mapSol = nouvelleLigne.split(pointVirgule);
				//System.out.println(map.toString());
				
				for (int j = 0; j < mapSol.length; j++) {
					//System.out.println("map à la ligne l ="+ l + "col : "+ j + "valeur à cette case"+ mapSol[j]);
					if (mapSol[j].equals("0")) {
						ImageView blocSol0 = new ImageView();
						blocSol0.setImage(Constantes.sol0);
						blocSol0.setX(j*32);
						blocSol0.setY(l*32);
						affichageMapSol.getChildren().add(blocSol0);
					}

					if (mapSol[j].equals("1")) {
						ImageView blocSol1 = new ImageView();
						blocSol1.setImage(Constantes.sol1);
						blocSol1.setX(j*32);
						blocSol1.setY(l*32);
						affichageMapSol.getChildren().add(blocSol1);
					}
					
					if (mapSol[j].equals("-1")) {
						ImageView blocTransparent = new ImageView();
						blocTransparent.setImage(Constantes.tuileTransparente);
						blocTransparent.setX(j*32);
						blocTransparent.setY(l*32);
						affichageMapSol.getChildren().add(blocTransparent);
					}
				}
				l++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (nouveauBr != null) {
				try {
					nouveauBr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
