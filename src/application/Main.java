package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage primaryStage;
	
	private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }
	
	static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			setPrimaryStage(primaryStage);
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		
			Scene scene = new Scene(root,640,640);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Last Resort");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
