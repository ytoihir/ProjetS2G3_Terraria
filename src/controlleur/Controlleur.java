package controlleur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controlleur {
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private Pane pane;
	
	@FXML
	private ImageView imageEtabli;
	
	@FXML
	private VBox affichage;
	
	private boolean clic;
	
	private Pane newLoadedPane;
	
	@FXML
	public void afficheListeObjets(MouseEvent event) throws IOException {
		
		if (clic==true) {
			pane.getChildren().remove(newLoadedPane);
			clic=false;
			
		}
		
		else {
			newLoadedPane = FXMLLoader.load(getClass().getResource("/vue/vueEtabli.fxml"));
			pane.getChildren().add(newLoadedPane);
			clic = true;
		}
		
	}

	public void initialize() {
		
	}
	
}
