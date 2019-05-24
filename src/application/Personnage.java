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
		this.xProperty = new SimpleIntegerProperty(32);
		this.yProperty = new SimpleIntegerProperty(16*32);

	}
	
	public IntegerProperty xProperty() {
		return this.xProperty;
	}
	
	public IntegerProperty yProperty() {
		return this.yProperty;
	}
	
	public void deplacerPerso(int x, int y) {
		this.xProperty.set(this.xProperty.get() + x);
		this.yProperty.set(this.yProperty.get() + y);
	}
	
	public int getX() {
		return this.xProperty.get();
	}
	
	public int getY() {
		return this.yProperty.get();
	}
	
	public boolean collision(int x, int y) {
		CSVReader csv = new CSVReader();
		csv.tuileListe(Constantes.fichierCSV1);
		if(csv.getTuile(csv.calculerIndice(this.getX()+x, this.getY()+y)).getCollision()){
			return true;
		}
		else if(csv.getTuile(csv.calculerIndice(this.getX()+x, (this.getY()+y)+32)).getCollision()){
			return true;
		}
		else if(csv.getTuile(csv.calculerIndice((this.getX()+x)+32, this.getY()+y)).getCollision()){
			return true;
		}
		else if(csv.getTuile(csv.calculerIndice((this.getX()+x)+32, (this.getY()+y)+32)).getCollision()){
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
