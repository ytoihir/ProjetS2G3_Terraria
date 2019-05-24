package application;

import java.io.File;
import java.net.URL;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.Map;

public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {
		try {

		FXMLLoader loader = new FXMLLoader();
		URL url = new File("src/vue/vue.fxml").
		toURI().toURL();
		loader.setLocation(url);
		System.out.println(loader.getLocation());
		AnchorPane root = new AnchorPane(); 
		root=loader.load();
     	Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
