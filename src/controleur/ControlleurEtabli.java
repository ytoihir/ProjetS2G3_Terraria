package controleur;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modele.inventaire.Inventaire;
import modele.inventaire.etabli.Etabli;

public class ControlleurEtabli {
	
	private DialogPane alerte;

	private ArrayList<String> ressourcesAsupp;
	
	private ControleurInventaire contInventaire;
	
	public ControlleurEtabli(ControleurInventaire ivt) {
		this.ressourcesAsupp=new ArrayList<String>();
		this.contInventaire = ivt;
		Image etabli = new Image("/img/inventaire/etablieEcran.png");
		ivt.getPane().getChildren().add(new ImageView(etabli));
		configurerEtabli(contInventaire.getIvt().initialiserEtabli());
	}
	
	public void fabriquerObjetVue(String id, Inventaire i) {

		this.contInventaire.getIvt().getEtabli().choisirUnObjet(id); 
		
		ArrayList<String> liste = contInventaire.getIvt().getEtabli().fabriquerObjet(i);
	
		if(liste==null) {
			alerte = new DialogPane();
			contInventaire.getPane().getChildren().add(alerte);
			alerte.setLayoutY(220);
			alerte.setHeaderText("Pas les ressources nécessaires!");
		}
		
		else {
			String idImageView=null;
			for (int a=0; a<contInventaire.getListeImgView().size(); a++) {
			
				idImageView = contInventaire.getListeImgView().get(a).getId();
				
				for (int b=0; b<liste.size(); b++) {
					if(idImageView==liste.get(b)) {
						contInventaire.getListeImgView().get(a).setImage(null);
					}
				}
				
			}
		
		}
		
	}
	
	public ArrayList<String> getListeAsupp() {
		
		System.out.println("res"+this.ressourcesAsupp);
		return this.ressourcesAsupp;
		
	}
	
	public void configurerEtabli(Etabli e) {
			   
		int xObjets = 10;
		int yObjets = 10;
		
		int xBoutons = 90;
		int yBoutons = 10;
		
		int xRessources = 50;
		int yRessources = 10;
		
		int xNbrRessources = 70;
		int yNbrRessources = 10;
		
		for (int i=0; i<e.getListeObjetFabriquable().size(); i++) {
			
			ImageView vueObjet = new ImageView(e.getListeObjetFabriquable().get(i).getValPNG());		
			VBox VBoxObjets = new VBox();
			VBoxObjets.getChildren().add(vueObjet);
			vueObjet.setFitWidth(30);
			vueObjet.setFitHeight(30);
	
			VBoxObjets.setLayoutX(xObjets);
			VBoxObjets.setLayoutY(yObjets+=40);
			
			contInventaire.getPane().getChildren().add(VBoxObjets);
			
			// fabriquer un objet lors du click du bouton
			
			Button b = new Button();
			b.setText("F");
			
			String idObjet = e.getListeObjetFabriquable().get(i).getId();

			b.setOnAction(evt -> {fabriquerObjetVue(idObjet, contInventaire.getIvt());});
			
			VBox VBoxBoutons = new VBox();

			VBoxBoutons.getChildren().add(b);
			VBoxBoutons.setLayoutX(xBoutons);
			VBoxBoutons.setLayoutY(yBoutons+=40);
			
			contInventaire.getPane().getChildren().add(VBoxBoutons);
			
			// afficher les images view des ressources necessaires à avoir pour crafter les objets
			
			ImageView vueRessource = new ImageView(new Image("/img/ressource/map_1.png"));

			VBox VBoxRessources = new VBox();
			VBoxRessources.setLayoutX(xRessources);
			VBoxRessources.setLayoutY(yRessources+=43);
			
			VBoxRessources.getChildren().add(vueRessource);
			vueRessource.setFitWidth(15);
			vueRessource.setFitHeight(15);
			
			contInventaire.getPane().getChildren().add(VBoxRessources);
			
			Text t=new Text(e.getListeObjetFabriquable().get(i).getFerNecessaires()+"x");
			VBox affichageNbrRessources = new VBox();
			
			affichageNbrRessources.getChildren().add(t);

			affichageNbrRessources.setLayoutX(xNbrRessources);
			affichageNbrRessources.setLayoutY(yNbrRessources+=43);

			contInventaire.getPane().getChildren().add(affichageNbrRessources);

		}
	}
}