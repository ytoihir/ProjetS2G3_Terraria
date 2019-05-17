package modele;

public class Tile {
	
	private int posx;
	private int posy;
	private String valeur;
	private boolean collision;
	private int id;
	
	private static int no=0;
	
	public Tile (int posx, int posy, String valeur, boolean collision) {
		
		this.id=no++;
		this.posx=posx;
		this.posy=posy;
		this.valeur=valeur;
		this.collision=collision;
		
	}

}
