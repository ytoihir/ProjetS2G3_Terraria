package modele.inventaire;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.inventaire.outil.Pioche;
import modele.inventaire.ressource.Fer;

public class TestInventaire {

	@Test
	public void testAjoutObjet() {
		Inventaire ivt = new Inventaire();
		Objet fer = new Fer();

		ivt.ajouterObjet(fer);
		
		assertEquals("cas objet ajouté", fer, ivt.getObjet(fer.getId()));
		
		ivt.enleverObjet(fer);
		
		assertEquals("cas objet non présent dans la liste", null, ivt.getObjet(fer.getId()));
		
	}
	
	@Test
	public void testSupprimerObjet() {
		Inventaire ivt = new Inventaire();
		Objet fer = new Fer();

		ivt.ajouterObjet(fer);
		
		assertEquals("cas objet present dans la liste", fer.getId(), ivt.enleverObjet(fer));
		
		ivt.enleverObjet(fer);
		
		assertEquals("cas objet non présent dans la liste", null, ivt.enleverObjet(fer));
		
	}
	
	@Test
	public void testRetournerDernierObjet() {
		Inventaire ivt = new Inventaire();
		Objet fer = new Fer();
		Objet pioche = new Pioche();
		
		ivt.ajouterObjet(fer);
		ivt.ajouterObjet(pioche);
		
		assertEquals("cas retourne pioche", pioche, ivt.getDernierObjet());
		
		ivt.enleverObjet(fer);
		ivt.enleverObjet(pioche);
		
		assertEquals("cas liste vide", null, ivt.getDernierObjet());
		
		
	}
	
	@Test
	public void testInitialisationEtabli() {
		
		Inventaire ivt = new Inventaire();
		
		assertEquals("cas etabli null", null, ivt.getEtabli());
		
		ivt.initialiserEtabli();
		
		assertEquals("cas etabli initialisé", ivt.getEtabli(), ivt.getEtabli());
		
		
	}
	
	

}
