package application;
import application.Deplacement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
public class Personnage {

	private String nom;
	private String desc;
	private int id;
	private Deplacement mouvement;
	private int CoupsTotalAvantDeMourir;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	
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
		this.xProperty = new SimpleIntegerProperty(9);
		this.yProperty = new SimpleIntegerProperty(0);

	}
	
	public IntegerProperty xProperty() {
		return this.xProperty;
	}
	
	public IntegerProperty yProperty() {
		return this.yProperty;
	}
	
	public void deplacerPerso(int x, int y) {
//		System.out.println("posPerso X :" + this.getX());
//		System.out.println("posPerso y :" + this.getY());
//		if (this.xProperty.get()%32 == 0) {
//			this.xProperty.set(this.xProperty.get() + x);
//		}
		this.xProperty.set(this.xProperty.get() + x);
		this.yProperty.set(this.yProperty.get() + y);
	}
	
	public int getX() {
		return this.xProperty.get();
	}
	
	public int getY() {
		return this.yProperty.get();
	}
	
	
	
}
