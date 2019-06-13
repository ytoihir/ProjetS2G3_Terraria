package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;

import modele.inventaire.Inventaire;
import modele.inventaire.Objet;
import modele.inventaire.outil.Pioche;


public class ControleurInventaire implements Initializable {
	
    private boolean tenirOuReposer = false, clic = false;
    private ImageView imgView;

	private Pane newLoadedPane;

	private ArrayList <ImageView> casesInventaire;	 
	
    private Inventaire ivt;

    @FXML
    private ImageView case1 ;
	@FXML
	private ImageView case2 ;
	@FXML
	private ImageView case3 ;
	@FXML
	private ImageView case4 ;
	@FXML
	private ImageView case5 ;
	@FXML
	private ImageView case6;
	@FXML
	private ImageView perso;
	@FXML
	private ImageView imageEtabli;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private Pane pane;

	//public ControleurInventaire() {
	//	this.ivt = new Inventaire();
	//}
		
	private ControlleurEtabli c;
	
	@FXML
	public void afficheListeObjets(MouseEvent event) throws IOException{
		
		c = new ControlleurEtabli(this);
		//newLoadedPane = FXMLLoader.load(getClass().getResource("/vue/vueEtabli.fxml"));
		
		//c.initialize();
		if(this.ivt.getEtabli() == null) this.ivt.initialiserEtabli();
		
		if (clic) {
			pane.getChildren().remove(newLoadedPane);
			clic=false;
			
		}
		
		else if(!clic){
			//newLoadedPane = FXMLLoader.load(getClass().getResource("/vue/vueEtabli.fxml"));
			pane.getChildren().add(newLoadedPane);
			clic = true;
			
			
		
		}
		
	}
    
    // retourne le nom de l'outil cliqué 
    public String retournerNomOutilCliqué(MouseEvent evt){

    	ImageView img = (ImageView)evt.getSource();
    	
    	if(img.getImage() != null ) {
    		String idImageSelectionée = img.getId();

	    	for(int i = 0; i < casesInventaire.size(); i++) {
	    		for(int y = 0; y < this.ivt.getListe().size(); y++) {
	    			if(idImageSelectionée == casesInventaire.get(i).getId()) {
	    				System.out.println(casesInventaire.get(i).getId());
	    				return this.ivt.getListe().get(y).getNom();
	    			}
	    				
	    		
	    		}
	
	    	}
    	}
    	
    	
    	return null;
    }
    
    
    // retourne l'imageView cliqué
    public ImageView retournerNomImgViewCliquée(MouseEvent evt){
    	
    	ImageView i1 = (ImageView)evt.getSource();
    	String idImageSelectionée = i1.getId();
    	
    		for(int i = 0; i < casesInventaire.size(); i++)
    			if(idImageSelectionée == casesInventaire.get(i).getId()) return casesInventaire.get(i);
    			
  
    	return null;																																																																										
    }
    

    // methode qui change l'image du joueur selon l'outil cliqué dans l'inventaire
    @FXML
    public void prendreObjet(MouseEvent event) {
    	
    	
    	if(retournerNomOutilCliqué(event) != null) {
   
    		Image img = new Image("/img/perso/perso" + "_" + retournerNomOutilCliqué(event) + ".png");
        	Image imgB = new Image("/img/perso/filledroitidle.png");
        	
        	ImageView imgSelec = (ImageView)event.getSource();
        	   
        		
        		if(!tenirOuReposer ) { 		
            		perso.setImage(img);
            		tenirOuReposer = true;
            		
            		DropShadow dropShadow = new DropShadow();
            		dropShadow.setOffsetX(3.0);
            		dropShadow.setOffsetY(3.0);
            		
            		imgView = retournerNomImgViewCliquée(event);
            		retournerNomImgViewCliquée(event).setEffect(dropShadow);
            	}

            	else if(tenirOuReposer) {
            		perso.setImage(imgB);
            		tenirOuReposer = false;	
            		imgView.setEffect(null);
            	}
        		
        
    	}
    	
    	else System.out.println("case vide");
    	
    	
    	
    	
    }
    
    @FXML
    public void enleverObjet(MouseEvent event) {
    
    	ImageView imgSelec = (ImageView)event.getSource(); 
    	
    	if (imgSelec.getImage() != null) {
    		ivt.enleverObjet(ivt.getObjet(imgSelec.getId())); // enlever l'objet de la liste d'objet de l'inventaire
    		imgSelec.setImage(null); // enlever l'ImageView de l'inventaire
    	}
    		
    }

    public ArrayList<ImageView> getListeInventaire (){
    	return this.casesInventaire;
    }
    
    public Inventaire getIvt () {
    	return this.ivt;
    }
    
    public void ajouterObjetConstruitAIvt(String idObjetSelect) {
    	System.out.println(casesInventaire.size());
		for(int i = 0; i < casesInventaire.size(); i++){
			if(verifierImgViewVideOuPas() == 0) {
			
				System.out.println(ivt.getDernierObjet());	
				System.out.println(casesInventaire.size());
				
				casesInventaire.get(i).setImage( new Image( ivt.getDernierObjet().getValPNG() ) );
				casesInventaire.get(i).setId(ivt.getObjet(idObjetSelect).getId());
				break;
				
			}
				
		}
    }
    
    public int verifierImgViewVideOuPas () {
    	int videOuPas = 0;
    	for(int i = 0; i < casesInventaire.size(); i++){
    		if(casesInventaire.get(i).getImage() == null) {
    			videOuPas = 0;
    			break;
    		}
    	}
    	return videOuPas;
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources){
    	
			this.ivt = new Inventaire();
			Objet pioche = new Pioche();	
			ivt.ajouterObjet(pioche);
			case1.setImage(new Image(pioche.getValPNG()));
			case1.setId(pioche.getId());
			
			casesInventaire  = new ArrayList<>();
			
			casesInventaire.add(case1);
			casesInventaire.add(case2);
			casesInventaire.add(case3);
			casesInventaire.add(case4);
			casesInventaire.add(case5);
			casesInventaire.add(case6);
			
			System.out.println(casesInventaire.size());
		
		//System.out.println(getIvt().getListe());
		
	}
    																																																																																				

}

