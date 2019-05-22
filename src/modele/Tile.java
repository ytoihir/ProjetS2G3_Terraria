package modele;

public class Tile {
	
	private int posx;
	private int posy;
	private String valeurImage;
	private boolean collision;
	private int id;
	
	private static int no=0;
	
	public Tile (int posx, int posy, String valeur, boolean collision) {
		
		this.id=no++;
		this.posx=posx;
		this.posy=posy;
		this.valeurImage=valeur;
		this.collision=collision;
		
	}
	
	public String toString() {
		return this.id + " " + this.posx + " " + this.posy + " " + this.valeurImage + " " + this.collision;
	}

}
