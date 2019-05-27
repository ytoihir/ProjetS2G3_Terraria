package controleur;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;

import modele.inventaire.Arme;
import modele.inventaire.Epée;
import modele.inventaire.Arc;
import modele.inventaire.Pioche;
import modele.inventaire.Inventaire;

public class controleur implements Initializable{
	
    private boolean tenirOuReposer = false;
    private ImageView imgView;
    
    @FXML
    private HBox hbox1;
    
	@FXML
    private ImageView Pioche;

    @FXML
    private ImageView perso;

    @FXML
    void prendrePioche(MouseEvent event) {
    	prendreObjet(event);
    }

    @FXML
    void enleverPioche(MouseEvent event) {
    	enleverObjet(event, Pioche);
    }
    
    // retourne le nom de l'outil cliqué 
    public String retournerNomOutilCliqué(MouseEvent evt){

    	ImageView i = (ImageView)evt.getSource();
    	String idImageSelectionée = i.getId();
    	
    	if(idImageSelectionée == Pioche.getId()) 
    		return "Pioche";
    	
    	return null;
    }
    
    
    // retourne l'imageView cliqué
    public ImageView retournerNomImgViewCliquée(MouseEvent evt){
    	
    	ImageView i1 = (ImageView)evt.getSource();
    	String idImageSelectionée = i1.getId();
    	
    	if(idImageSelectionée == Pioche.getId()) 
    		return Pioche;
    	
    	return null;
    }

    // methode qui change l'image du joueur selon l'outil cliqué dans l'inventaire
    public void prendreObjet(MouseEvent event) {
    	
    	Image img = new Image("/img/perso/perso" + retournerNomOutilCliqué(event) + ".png");
    	Image imgB = new Image("/img/perso/filledroitidle.png");
    	    	
    	if(!tenirOuReposer) { 		
    		perso.setImage(img);
    		tenirOuReposer = true;
    		
    		DropShadow dropShadow = new DropShadow();
    		dropShadow.setOffsetX(3.0);
    		dropShadow.setOffsetY(3.0);
    		
    		imgView = retournerNomImgViewCliquée(event);
    		retournerNomImgViewCliquée(event).setEffect(dropShadow);
    	}

    	else if(tenirOuReposer) {
    		perso.setImage(imgB);
    		tenirOuReposer = false;	
    		imgView.setEffect(null);
    	}
    }
    
    public void enleverObjet(MouseEvent event, ImageView img) {
    	img.setImage(null);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Inventaire ivt = new Inventaire();
		Pioche pioche1 = new Pioche(1, "pioche1");
		
		ivt.ajouterObjet(pioche1);
        

		
	}
}