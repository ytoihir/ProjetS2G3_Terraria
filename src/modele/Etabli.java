package modele;

import java.util.ArrayList;

public class Etabli {
	
	private ArrayList<Objet> listeObjets;
	
	private Objet objetSelec;
	
	public Etabli() {
		
		listeObjets=new ArrayList<>();
		
	}
	
	public Objet fabriquerObjet(ArrayList<Ressource >r) {

		if (r==objetSelec.getRessource()) {
			return objetSelec;
		}
		
		return null;
		
	}
	
	public void setObjetSelec(Objet o) {
	
		this.objetSelec=o;
		
	}
	
	public void choisirUnObjet(Objet o) {
	
		for (int i=0; i<listeObjets.size(); i++) {
			
			if (listeObjets.get(i)==o) {
			
				objetSelec=listeObjets.get(i);
			
			}
		
		}
		
	}

}
