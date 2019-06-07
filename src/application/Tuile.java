package application;
import application.Constantes;
import javafx.scene.image.Image;

public class Tuile {
	private String id;
	private boolean collision;
	private int posX;
	private int posY;
	
	public Tuile(int posx, int posy, String id) {
		this.id = id;
		this.collision = false;
		this.posX = posx;
		this.posY = posy;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	 public void setPosX(int newPosX) {
	    this.posX = newPosX;
	 }
	    
	 public void setPosY(int newPosY) {
	    this.posY = newPosY;
	 }
	
	public String getId() {
		return this.id;
	}
	
	public void setTuileVide() {
		this.id = "-1";
	}
	
	public void setTuile(String newId) {
		this.id = newId;
	}
	
	public boolean getCollision() {
		return this.collision;
	}
	
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	
}
