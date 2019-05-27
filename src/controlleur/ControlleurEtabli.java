package controlleur;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modele.Etabli;
import modele.Objet;
import modele.Ressource;

public class ControlleurEtabli {
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private VBox VBoxObjets, VBoxRessources, VBoxNbrRessources, VBoxBoutons;
	
	private Inventaire i;
	
	private Etabli e;
	
	private DialogPane alerte;

	public void fabriquerObjet(String id,ObservableList<Ressource> listeRessources) {
		e.choisirUnObjet(id);
		if (e.fabriquerObjet(listeRessources)!=null) {
			VBoxObjets.getChildren().add(new Text("Vous avez fabriquer l'objet " + e.fabriquerObjet(listeRessources).getNom()));
		}
		else {
			alerte = new DialogPane();
			ap.getChildren().add(alerte);
			alerte.setLayoutY(220);
			alerte.setHeaderText("Vous n'avez pas les ressources nécessaires pour fabriquer cet objet!");
		}
	}
	
	public void configurerEtabli() {
		
		ArrayList<Ressource> ressources = new ArrayList<>();
		ArrayList<Ressource> ressources2 = new ArrayList<>();
		
		ressources.add(new Ressource("fer","peut être posé, ou réutiliser pour fabriquer des objets","ressourcesImages/Iron_Bar.png",3));
		
		ressources2.add(new Ressource("bronze","peut être posé, ou réutiliser pour fabriquer des objets","ressourcesImages/Iron_Crate.png",4));
		
		e.ajouterObjet(new Objet("épée","combattre","ressourcesImages/epee.png", ressources));
		
		e.ajouterObjet(new Objet("arc","tirer","ressourcesImages/arc.png", ressources2));	
	    
		for (int i=0; i<e.getListe().size(); i++) {
			
			File fichierObjet = new File(e.getListe().get(i).getValPNG());
			 
			Image imageObjet = new Image(fichierObjet.toURI().toString());
			 
			ImageView vueObjet = new ImageView();
			
			vueObjet.setImage(imageObjet);
			
			vueObjet.setFitWidth(30);
			vueObjet.setFitHeight(30);
			
			VBoxObjets.getChildren().add(vueObjet);
			
			VBoxObjets.setMargin(vueObjet, new Insets(0,0,20,0));
			
			VBox affichageRessources = new VBox();
			
			VBox affichageNbrRessources = new VBox();
			
			VBoxRessources.getChildren().add(affichageRessources);
			
			VBoxNbrRessources.getChildren().add(affichageNbrRessources);
			
			affichageRessources.setPadding(new Insets(0,0,35,0));
			
			affichageNbrRessources.setPadding(new Insets(0,0,35,0));
			
			Button b = new Button();
			
			b.setText("F");
			
			// FABRIQUER UN OBJET, ON VERIFIE SI LE JOUEUR DISPOSE DES RESSOURCES NECESSAIRES POUR
			// FABRIQUER L'OBJET, ON DOIT DONC PARCOURIR SON INVENTAIRE 
			// PAS ENCORE FAIT
			
			ObservableList<Ressource> listeInventaire = FXCollections.observableArrayList();
			
			listeInventaire.add(new Ressource("bronze","peut être posé, ou réutiliser pour fabriquer des objets","ressourcesImages/Iron_Crate.png",4));
			
			b.setId(e.getListe().get(i).getId());
			
			b.setOnAction(evt -> fabriquerObjet(b.getId(), listeInventaire));
			
			VBoxBoutons.setMargin(b,new Insets(0,0,25,0));
			
			VBoxBoutons.getChildren().add(b);
			
			for (int j=0;j<e.getListe().get(i).getRessource().size(); j++) {
				
				File fichierRessources = new File(e.getListe().get(i).getRessource().get(j).getValPNG());
				
				Image imageRessource = new Image(fichierRessources.toURI().toString());
				 
				ImageView vueRessource = new ImageView();
				
				vueRessource.setImage(imageRessource);
				
				vueRessource.setFitWidth(15);
				
				vueRessource.setFitHeight(15);
				
				affichageRessources.getChildren().add(vueRessource);
				
				Text t=new Text(e.getListe().get(i).getRessource().get(j).getNbr()+"x");
				
				affichageNbrRessources.getChildren().add(t);
				
			}
		    
		}
	}
	public void initialize() {
		
		e = new Etabli();
		configurerEtabli();
	    
	}

}
