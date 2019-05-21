package controleur;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;


public class controleur implements Initializable{
	
    @FXML
    private Circle perso;
    
    private boolean goRight, goLeft, goUp;
    
    @FXML
    void move(KeyEvent ke) {

    	if (ke.getCode() == KeyCode.LEFT) {
    		goLeft = true;	
    	}
    	
    	if (ke.getCode() == KeyCode.RIGHT) {
    		goRight = true;	
    	}
    	
    	if (ke.getCode() == KeyCode.UP) {
    		goUp = true;	
    	}
    	
    	
  
    }

    @FXML
    void stopMoving(KeyEvent ke) {
    	if (ke.getCode() == KeyCode.LEFT) {
    		handle();
    		goLeft = false;

    	}
    	
    	if (ke.getCode() == KeyCode.RIGHT) {
    		handle();
    		goRight = false;

    	}
    	
    	if (ke.getCode() == KeyCode.UP) {
    		handle();
    		goUp = false;
    	}
    }
    
    
    
    public void handle() {
    	
    	if(goRight) perso.setLayoutX(perso.getLayoutX()+10);
    	
    	if(goLeft) perso.setLayoutX(perso.getLayoutX()-10);
    	
    	if(goUp) perso.setLayoutX(perso.getLayoutY()+10);
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
	}
}