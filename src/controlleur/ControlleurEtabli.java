package controlleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import modele.Etabli;
import modele.Objet;
import modele.Ressource;

public class ControlleurEtabli {
	
	@FXML
	private ImageView imageEtabli;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private VBox eP;
	
	private Etabli e;
	
	@FXML
	public void afficheListeObjets(MouseEvent event) {
		
		/*for (int i=0; i<1; i++) {
			
			eP.getChildren().add(new ImageView(e.getListe().get(i).getValPNG()));
			
		}*/
		
		eP.getChildren().add(new ImageView("ressourcesImages/epee.png"));
	}
	
	public void initialize() {
		
		e = new Etabli();
		
		ArrayList<Ressource> ressources = new ArrayList<>();
		
		ressources.add(new Ressource("fer","peut être posé, ou réutiliser pour fabriquer des objets","ressourcesImages/Iron_Bar.png"));
		
		e.ajouterObjet(new Objet("pioche","piocher","ressourcesImages/epee.png", ressources));
		
	}

}
