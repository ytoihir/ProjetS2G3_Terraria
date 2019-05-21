package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String fichierCSV = "/home/etudiants/info/mbenmoussa/mapPourTesterLAffichage.csv";
        BufferedReader br = null;
        String ligne = "";
        String virgule = ",";

        try {

            br = new BufferedReader(new FileReader(fichierCSV));
            while ((ligne = br.readLine()) != null) {

                // use comma as separator
                String[] map = ligne.split(virgule);

                for (int i = 0; i < map.length; i++) {
                	System.out.print(map[i]);
                	if (i == 19) {
                		System.out.println();
                	}
                }

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

}
