package application;

import java.beans.*;
import java.io.*;
import application.Constantes;
import java.net.URL;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

	private Personnage p;
	
	private CSVReader csvDecor;
	
	private CSVReader csvSol;
	
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

	public void creationMap() {
		csvDecor = new CSVReader();
		csvDecor.tuileListe(Constantes.fichierCSV1);
		ObservableList<Tuile> mapCiel = csvDecor.getListeTuile();
		
		System.out.println("ciel"+mapCiel.size());
		for (int i = 0; i < mapCiel.size() ; i++) {
			if (mapCiel.get(i).getId().equals("2")) {
				ImageView blocCiel2 = new ImageView();
				blocCiel2.setImage(Constantes.ciel2);
				blocCiel2.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel2.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel2);
			}

			if (mapCiel.get(i).getId().equals("12")) {
				ImageView blocSol12 = new ImageView();
				blocSol12.setImage(Constantes.ciel12);
				blocSol12.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocSol12.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocSol12);
			}

			if (mapCiel.get(i).getId().equals("13")) {
				ImageView blocCiel13 = new ImageView();
				blocCiel13.setImage(Constantes.ciel13);
				blocCiel13.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel13.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel13);
			}

			if (mapCiel.get(i).getId().equals("14")) {
				ImageView blocCiel14 = new ImageView();
				blocCiel14.setImage(Constantes.ciel14);
				blocCiel14.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel14.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel14);
			}

			if (mapCiel.get(i).getId().equals("15")) {
				ImageView blocCiel15 = new ImageView();
				blocCiel15.setImage(Constantes.ciel15);
				blocCiel15.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel15.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel15);
			}

			if (mapCiel.get(i).getId().equals("16")) {
				ImageView blocCiel16 = new ImageView();
				blocCiel16.setImage(Constantes.ciel16);
				blocCiel16.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel16.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel16);
			}

			if (mapCiel.get(i).getId().equals("17")) {
				ImageView blocCiel17 = new ImageView();
				blocCiel17.setImage(Constantes.ciel17);
				blocCiel17.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel17.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel17);
			}

			if (mapCiel.get(i).getId().equals("18")) {
				ImageView blocCiel18 = new ImageView();
				blocCiel18.setImage(Constantes.ciel18);
				blocCiel18.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel18.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel18);
			}

			if (mapCiel.get(i).getId().equals("19")) {
				ImageView blocCiel19 = new ImageView();
				blocCiel19.setImage(Constantes.ciel19);
				blocCiel19.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel19.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel19);
			}

			if (mapCiel.get(i).getId().equals("20")) {
				ImageView blocCiel20 = new ImageView();
				blocCiel20.setImage(Constantes.ciel20);
				blocCiel20.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel20.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel20);
			}

			if (mapCiel.get(i).getId().equals("21")) {
				ImageView blocCiel21 = new ImageView();
				blocCiel21.setImage(Constantes.ciel21);
				blocCiel21.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel21.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel21);
			}

			if (mapCiel.get(i).getId().equals("22")) {
				ImageView blocCiel22 = new ImageView();
				blocCiel22.setImage(Constantes.ciel22);
				blocCiel22.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel22.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel22);
			}

			if (mapCiel.get(i).getId().equals("23")) {
				ImageView blocCiel23 = new ImageView();
				blocCiel23.setImage(Constantes.ciel23);
				blocCiel23.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel23.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel23);
			}

			if (mapCiel.get(i).getId().equals("27")) {
				ImageView blocCiel27 = new ImageView();
				blocCiel27.setImage(Constantes.ciel27);
				blocCiel27.setX(csvDecor.getListeTuile().get(i).getPosX()*32);
				blocCiel27.setY(csvDecor.getListeTuile().get(i).getPosY()*32);
				affichageMapCiel.getChildren().add(blocCiel27);
			}

		}
	
			csvSol = new CSVReader();
			csvSol.tuileListe(Constantes.fichierCSV2);
			ObservableList<Tuile> mapSol = csvSol.getListeTuile();
			System.out.println(mapSol.size());
			for (int j = 0; j < mapSol.size() ; j++) {
				if (mapSol.get(j).getId().equals("0")) {
					mapSol.get(j).setCollision(true);
					ImageView blocSol0 = new ImageView();
					blocSol0.setImage(Constantes.sol0);
					blocSol0.setX(csvSol.getListeTuile().get(j).getPosX()*32);
					blocSol0.setY(csvSol.getListeTuile().get(j).getPosY()*32);
					affichageMapSol.getChildren().add(blocSol0);
				}
				if (mapSol.get(j).getId().equals("1")) {
					mapSol.get(j).setCollision(true);
					ImageView blocSol1 = new ImageView();
					blocSol1.setImage(Constantes.sol1);
					blocSol1.setX(csvSol.getListeTuile().get(j).getPosX()*32);
					blocSol1.setY(csvSol.getListeTuile().get(j).getPosY()*32);
					affichageMapSol.getChildren().add(blocSol1);
				}
				if (mapSol.get(j).getId().equals("-1")) {
					ImageView blocTransparent = new ImageView();
					blocTransparent.setImage(Constantes.tuileTransparente);
					blocTransparent.setX(csvSol.getListeTuile().get(j).getPosX()*32);
					blocTransparent.setY(csvSol.getListeTuile().get(j).getPosY()*32);
					affichageMapSol.getChildren().add(blocTransparent);
				}
			}
	}


	public void creationPerso() {
		p = new Personnage(01,"Carolina", "Carolina", 40);
		perso = new ImageView("file:src/ImgPersonnage/filleidle.png");
		perso.translateXProperty().bind(p.xProperty());
		perso.translateYProperty().bind(p.yProperty());
		perso.setFocusTraversable(true);
		perso.setFitHeight(32);
		perso.setFitWidth(32);
		pane.getChildren().add(perso);
		pane.setMouseTransparent(true);
		pane.setFocusTraversable(true);
		pane.setOnKeyPressed(e -> enMouvement(e));
		pane.setOnKeyReleased(e -> enArret(e));
	}

//	@FXML
//	void Saut(KeyEvent event) {
//		KeyCode touche = event.getCode();
//		switch (touche) {
//		case SPACE:
//			perso.setTranslateY(perso.getTranslateY() - 4.0);
//			break;
//		}
//		//    	while (perso.getTranslateY() != 512) {
//		//    		perso.setTranslateY(perso.getTranslateY() + 2.0);
//		//    	}
//	}





	@FXML
	void enArret(KeyEvent event) {
		this.p.deplacerPerso(0, 0);
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
			if (this.p.xProperty().get() == 612) {
				System.out.println("On ne peut pas aller plus à droite !");
			}
			else {
				initCollision(4, 0);
			}
			break;
		case LEFT:
			perso.setImage(Constantes.personnageRegardantAGauche);
			perso.setImage(Constantes.personnageCourantAGauche);
			if (this.p.xProperty().get() == 0) {
				System.out.println("On ne peut pas aller plus à gauche !");
			}
			else {
				initCollision(-4, 0);
			}
			break;		
		}
	}
	
	private void initCollision(int x, int y) {
		if (p.collision(x, y)) {
			p.deplacerPerso(0, 0);
		}
		else {
			p.deplacerPerso(x, y);
		}
	}
	
	private void initGravite(int x) {
		if (!p.collision(x, 32)) {
			p.deplacerPerso(x, 32);
		}
	}

	//	public void casserBloc() {
	//		affichageMapSol.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	//		     @Override
	//		     public void handle(MouseEvent event) {
	//		    	 int x=((int)(event.getX())/32);
	//		         int y=((int)(event.getY())/32);
	//		         if (x<p.xProperty().get()/32-5 || x>p.xProperty().get()/32+5 || y<p.yProperty().get()/32-5 || y>p.yProperty().get()/32+6) {
	//		         }
	//		         else
	//		        	 map.setBlock(y*60+x,new ("-1",y*60+x));
	//		     }
	//		});
	//		
	//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		creationMap();
		creationPerso();	
		//System.out.println(CSVReader.tuileListe(Constantes.fichierCSV2));

	}
}
