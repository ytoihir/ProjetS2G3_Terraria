package modele.inventaire;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.inventaire.arme.Arc;
import modele.inventaire.arme.Epee;
import modele.inventaire.etabli.Etabli;
import modele.inventaire.outil.Pioche;

public class Inventaire {

	private ObservableList <Objet> mesObjets;
	private Etabli etabli;
	
	public Inventaire() {	
		mesObjets = FXCollections.observableArrayList();
		this.etabli = null;

	}
	
	public void ajouterObjet(Objet a) {
		mesObjets.add(a);
	}
	
	public String enleverObjet(Objet a) {
		for(int i = 0; i < mesObjets.size(); i++) 
			if(mesObjets.get(i) == a ) {
				mesObjets.remove(a);
				return a.getId();
			}
		return null;
	}
	
	public ObservableList<Objet> getListeObjets() {
		return this.mesObjets;
	}
	
	public Objet getObjet(String id) {
		for(int i = 0; i < mesObjets.size(); i++) {
			if(this.mesObjets.get(i).getId() == id)
				return this.mesObjets.get(i);
			
		}
		return null;
	}
	
	public Objet getDernierObjet() {
		return this.mesObjets.get(mesObjets.size()-1);
		
	}
	
	public Etabli initialiserEtabli() {
		this.etabli = new Etabli();
		this.mesObjets.add(etabli);
		return this.etabli;
	}
	
	public Etabli getEtabli() {
		return this.etabli;
	}
	
	
	
}
