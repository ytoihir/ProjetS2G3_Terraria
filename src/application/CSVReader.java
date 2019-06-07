package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.*;

public class CSVReader {
	private ObservableList<Tuile> listeTuile ; 
	
	public CSVReader() {
		this.listeTuile = FXCollections.observableArrayList();
	}
    public void tuileListe(String fichierCSV) {
        BufferedReader br = null;
        String ligne = "";
        int j;
        try {

            br = new BufferedReader(new FileReader(fichierCSV));
            j = 0;
            while ((ligne = br.readLine()) != null) {
                String[] map = ligne.split(",|;");

                for (int i = 0; i < map.length; i++) {
                	Tuile nouvelleTuile = new Tuile(i,j,map[i]);
                	this.listeTuile.add(nouvelleTuile);
                	
                	
                }
                j++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    public ObservableList<Tuile> getListeTuile() {
    	return this.listeTuile;
    }
    
    public Tuile getTuile (int indice) {
        return this.listeTuile.get(indice);
    }
    
    public void setTuile(int indice, Tuile tuile) {
    	this.listeTuile.set(indice, tuile);
    }
    
//    public int translationPositionMapModeleVueX(double x) {
//    	return (int)(x%32);
//    }
//    
//    public int translationPositionMapModeleVueY(double y) {
//    	return (int)(y%32);
//    }
//    
    public int calculerIndice(int x, int y) {
        int indice = 0;
      
        for (int i = 0; i < this.listeTuile.size(); i++) {
            if (this.listeTuile.get(i).getPosX() == x && this.listeTuile.get(i).getPosY() == y) {
                indice = i;
            }
        }
        return indice;
    }
    
    public boolean collision(int x, int y) {    	
      if (this.getTuile(this.calculerIndice(x, y)).getId().equals("0") || this.getTuile(this.calculerIndice(x, y)).getId().equals("1") )
       return true;
       else return false;
    }
    
    public void setNouvelleTuile(String id, int x, int y) {
    	for (int i = 0; i < this.listeTuile.size(); i++) {
    		if (this.listeTuile.get(i).getPosX() == x && this.listeTuile.get(i).getPosY() == y) {
    			this.listeTuile.get(i).setTuile(id);
    		}
    	}
    }
    
    public void setTuileVide(int x, int y) {
		for (int i = 0; i < this.listeTuile.size(); i++) {
			if (this.listeTuile.get(i).getPosX() == x && this.listeTuile.get(i).getPosY() == y) {
				this.listeTuile.get(i).setTuileVide();
			}
		}
	}
    

}
