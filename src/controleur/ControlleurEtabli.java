package controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modele.inventaire.Inventaire;
import modele.inventaire.Objet;
import modele.inventaire.etabli.Etabli;
import modele.inventaire.ressource.Fer;

public class ControlleurEtabli{
	
	@FXML
	private AnchorPane ap;
	
    @FXML
    private ImageView ecranEtabli;
    
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private VBox VBoxObjets, VBoxRessources, VBoxNbrRessources, VBoxBoutons;
	private DialogPane alerte;

	private ControleurInventaire contInventaire;
	
	public ControlleurEtabli(ControleurInventaire ivt) {
		this.contInventaire = ivt;
	}
	
	public void fabriquerObjetVue(String id, Inventaire i) {
		this.contInventaire.getIvt().getEtabli().choisirUnObjet(id); 
		
		if(contInventaire.getIvt().getEtabli().fabriquerObjet(i)==null) {
			alerte = new DialogPane();
			ap.getChildren().add(alerte);
			alerte.setLayoutY(220);
			alerte.setHeaderText("Pas les ressources nécessaires!");
		}
		//mise a jour de l'inventaire 
		System.out.println(id);
		contInventaire.ajouterObjetConstruitAIvt(id);
		
		System.out.println(contInventaire.getIvt().getListe());
		
	}
	

	public void configurerEtabli(Etabli e) {
			    
		for (int i=0; i<e.getListeObjetFabriquable().size(); i++) {
			
			ImageView vueObjet = new ImageView(e.getListeObjetFabriquable().get(i).getValPNG());		
			VBoxObjets.getChildren().add(vueObjet);
			
			vueObjet.setFitWidth(30);
			vueObjet.setFitHeight(30);
			VBoxObjets.setMargin(vueObjet, new Insets(0,0,20,0));
			
			VBox affichageRessources = new VBox();
			
			VBox affichageNbrRessources = new VBox();
			
			VBoxRessources.getChildren().add(affichageRessources);
			
			VBoxNbrRessources.getChildren().add(affichageNbrRessources);
			
			affichageRessources.setPadding(new Insets(0,0,35,0));
			
			affichageNbrRessources.setPadding(new Insets(0,0,35,0));
			
			
			// fabriquer un objet lors du click du bouton
			
			Button b = new Button();
			b.setText("F");
			b.setId(e.getListeObjetFabriquable().get(i).getId());
			b.setOnAction(evt -> {fabriquerObjetVue(b.getId(), contInventaire.getIvt()); System.out.println(b.getId());});
			VBoxBoutons.setMargin(b,new Insets(0,0,25,0));
			VBoxBoutons.getChildren().add(b);
			
			
			// afficher les images view des ressources necessaires à avoir pour crafter les objets
			
			ImageView vueRessource = new ImageView(new Image("/img/ressource/map_1.png"));
			VBoxRessources.getChildren().add(vueRessource);
			vueRessource.setFitWidth(15);
			vueRessource.setFitHeight(15);
			affichageRessources.getChildren().add(vueRessource);
			Text t=new Text(e.getListeObjetFabriquable().get(i).getFerNecessaires()+"x");
			affichageNbrRessources.getChildren().add(t);
			
		}
	}
	@FXML
	public void initialize() {
		//controleur = new ControleurInventaire();
		
		Image etabli = new Image("/img/inventaire/etablieEcran.png");
		ecranEtabli.setImage(etabli);
		
		if(contInventaire != null) configurerEtabli(contInventaire.getIvt().getEtabli());
		else System.out.println("🤡");
	    
	}

}