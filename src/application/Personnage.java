package application;
import application.Deplacement;
public class Personnage {

	private String nom;
	private String desc;
	private int id;
	private Deplacement mouvement;
	private int CoupsTotalAvantDeMourir;
	
	public Personnage(int id, String nom, String description, Deplacement mvt, int PV) {
		this.id = id;
		this.nom = nom;
		this.desc = description;
		this.mouvement = mvt;
		this.CoupsTotalAvantDeMourir = PV;
	}
	
	public Personnage(int id, String nom, String description, Deplacement mvt) {
		this.id = id;
		this.nom = nom;
		this.desc = description;
		this.mouvement = mvt;

	}
	
	public Personnage(int id, String nom, String description, int PV) {
		this.id = id;
		this.nom = nom;
		this.desc = description;
		this.CoupsTotalAvantDeMourir = PV;

	}
}
