package modele.inventaire;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList <Objet> mesObjets;
	
	public Inventaire() {	
		mesObjets = FXCollections.observableArrayList();
	}
	
	public void ajouterObjet(Objet a) {
		mesObjets.add(a);
	}
	
	public void enleverObjet(Objet a) {
		for(int i = 0; i < mesObjets.size(); i++) 
			if(mesObjets.get(i) == a ) mesObjets.remove(a);	
	}
	
}
