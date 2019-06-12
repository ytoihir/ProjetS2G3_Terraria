package modele.inventaire.etabli;

import java.util.ArrayList;

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
		
		super("etabli", "/img/inventaire/établi.png");
		listeObjets=FXCollections.observableArrayList();
		listeObjets.add(this.objetEpee = new Epee());
		listeObjets.add(this.objetArc = new Arc());
		objetSelec= null;
		
	}
	
	public ArrayList<String> fabriquerObjet(Inventaire ivt) {
		
		ArrayList<String> listObjAsupp = new ArrayList<>();
		
		int suppFer=0;
		
		for(int i = 0; i < ivt.getListeObjets().size(); i++) {
			if(ivt.getListeObjets().get(i).getNom().equals("fer")) {
				listObjAsupp.add("fer");
			}
		}
		
		if (objetSelec.getFerNecessaires() <= listObjAsupp.size()) {
			ivt.ajouterObjet(new Objet(objetSelec.getNom(), objetSelec.getValPNG()));

			for(int y = 0; y < ivt.getListeObjets().size(); y++) {

				if (suppFer!=objetSelec.getFerNecessaires()) {
					
					if(ivt.getListeObjets().get(y).getNom().equals("fer")) {
						ivt.enleverObjet(ivt.getListeObjets().get(y));
						y--;
						suppFer++;
					}
				}
				
			}
			
			return listObjAsupp;
			
		}
	
		return null;
		
	}
	
	public void choisirUnObjet(String o) {
	
		for (int i=0; i<listeObjets.size(); i++) {
			
			if (listeObjets.get(i).getId().equals(o)) {
			
				objetSelec=listeObjets.get(i);
				break;
			
			}
		
		}
		
	}
	
	public ObservableList<Objet> getListeObjetFabriquable() {
		
		return this.listeObjets;
		
	}

}
