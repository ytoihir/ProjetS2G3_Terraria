package modele.inventaire.etabli;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.inventaire.Inventaire;
import modele.inventaire.Objet;
import modele.inventaire.arme.Arc;
import modele.inventaire.arme.Arme;
import modele.inventaire.arme.Epee;
import modele.inventaire.ressource.Fer;

public class Etabli extends Objet{
	
	private ObservableList<Objet> listeObjets;
	
	private Objet objetSelec, objetArc, objetEpee;
	
	public Etabli() {
		
		super("etabli", "/img/inventaire/etablieEcran.png");
		listeObjets=FXCollections.observableArrayList();
		listeObjets.add(this.objetEpee = new Epee());
		listeObjets.add(this.objetArc = new Arc());
		objetSelec= null;
		
	}
	
	public Objet fabriquerObjet(Inventaire ivt) {
		int nbRessources=0;
		
		for(int i = 0; i < ivt.getListe().size(); i++) 
			if(ivt.getListe().get(i).getClass().getName() == "Fer") nbRessources++;
		
		
		
			if (objetSelec.getFerNecessaires() == nbRessources) {
				ivt.ajouterObjet(objetSelec);
				for(int y = 0; y < ivt.getListe().size(); y++) {
					if(ivt.getListe().get(y).getClass().getName() == "Fer") {
						ivt.enleverObjet(ivt.getListe().get(y));
						return objetSelec;
					}
				}
			
		}
	
		return null;
		
	}
	
	public void choisirUnObjet(String o) {
	
		for (int i=0; i<listeObjets.size(); i++) {
			
			if (listeObjets.get(i).getId().equals(o)) {
			
				objetSelec=listeObjets.get(i);
				objetSelec.setId(); // incremente l'id de l'objet fabriqué 
				break;
			
			}
		
		}
		
	}
	
	
	
	public ObservableList<Objet> getListeObjetFabriquable() {
		
		return this.listeObjets;
		
	}

}
