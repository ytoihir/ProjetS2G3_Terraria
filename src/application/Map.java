package application;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Map {
	private ObservableList<Tuile> map;
	private int hauteurMap;
	private int largeurMap;
	
	public Map() {
		this.map = FXCollections.observableArrayList();
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(Constantes.fichierCSV1));
			int l=0;
			String ligne = "";
			while ((ligne = br.readLine()) != null) {
				String virgule = ",";
				String[] mapCiel = ligne.split(virgule);