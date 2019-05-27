package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Etabli {
	
	private ObservableList<Objet> listeObjets;
	
	private Objet objetSelec;
	
	public Etabli() {
		
		listeObjets=FXCollections.observableArrayList();
		
	}
	
	public Objet fabriquerObjet(ObservableList<Ressource >r) {

		for (int i=0; i<r.size(); i++) {
			
			for (int j=0; j<objetSelec.getRessource().size(); j++) {
				
				if (r.get(i).getNom()==objetSelec.getRessource().get(j).getNom()) {
					
					objetSelec.getRessource().remove(j);
					
				}
				
				
			}
			
		}
		
		if (objetSelec.getRessource().size()==0) {
			
			return objetSelec;
			
		}
	
		return null;
		
	}
	
	public void choisirUnObjet(String o) {
	
		for (int i=0; i<listeObjets.size(); i++) {
			
			if (listeObjets.get(i).getId()==o) {
			
				objetSelec=listeObjets.get(i);
			
			}
		
		}
		
	}
	
	public void ajouterObjet(Objet o) {
		
		listeObjets.add(o);
		
	}
	
	public ObservableList<Objet> getListe() {
		
		return this.listeObjets;
		
	}

}
