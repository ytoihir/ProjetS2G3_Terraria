package modele.inventaire;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList <Objet> mesObjets;
	
	public Inventaire() {	
		mesObjets = FXCollections.observableArrayList();
		mesObjets.add(new Pioche(1, "pioche"));
		mesObjets.add(new Epée(2, "epée"));
		mesObjets.add(new Arc(3, "arc"));
	}
	
	public void ajouterObjet(Objet a) {
		mesObjets.add(a);
	}
	
	public void enleverObjet(Objet a) {
		for(int i = 0; i < mesObjets.size(); i++) 
			if(mesObjets.get(i) == a ) mesObjets.remove(a);	
	}
	
	public ObservableList<Objet> getListe() {
		return this.mesObjets;
	}
	
}
