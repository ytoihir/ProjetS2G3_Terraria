package modele;

public class Ressource extends Objet {

	private String nom;
	private int nbr;
	private String desc;
	private String valeurPNG;
	
	public Ressource (String nom, String desc, String valPNG, int nbr) {
		
		super(nom,desc,valPNG);
		this.nbr=nbr;
		
	}
	
	public int getNbr() {
		return this.nbr;
	}

}
