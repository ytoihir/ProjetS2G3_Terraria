package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import modele.inventaire.Inventaire;
import modele.inventaire.Objet;
import modele.inventaire.outil.Pioche;
import modele.inventaire.ressource.Fer;

public class ControleurInventaire implements Initializable, ListChangeListener<Objet> {
	
    private boolean tenirOuReposer = false, clic = false;
    private ImageView imgView;
	private ArrayList <ImageView> casesInventaire;	 
	
    private Inventaire ivt;
   // private ControlleurEtabli contEtabli;

    
    @FXML
    private AnchorPane ivtPane;
    
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

	private ControlleurEtabli cE;
	
	@FXML
	public void afficheListeObjets() {

		if (clic) {
			
			pane.setVisible(false);
			clic=false;
			
		}
		
		else {
			
			pane.setVisible(true);
			clic = true;
			
		}
		
	}
    
    // retourne le nom de l'outil cliqué 
	public String retournerNomOutilCliqué(MouseEvent evt){

	    ImageView img = (ImageView)evt.getSource();
	    if(img.getImage()!=null) {
	    	String idImageSelectionée = img.getId();
	    	
	    	for(int y = 0; y < this.ivt.getListeObjets().size(); y++) {

	 	    		if(idImageSelectionée == ivt.getListeObjets().get(y).getId()) {
	 	    			
	 	    			return this.ivt.getListeObjets().get(y).getNom();
	 	    			

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

    	System.out.println(retournerNomOutilCliqué(event));
    	
    	
    	if(retournerNomOutilCliqué(event) != null && retournerNomOutilCliqué(event)!="etabli") {

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

    @Override
	public void initialize(URL location, ResourceBundle resources){
    	
    		this.ivt = new Inventaire();
    		this.ivt.getListeObjets().addListener(this);
    		
			casesInventaire  = new ArrayList<>();
			casesInventaire.add(case1);
			casesInventaire.add(case2);
			casesInventaire.add(case3);
			casesInventaire.add(case4);
			casesInventaire.add(case5);
			casesInventaire.add(case6);
			
			
			Objet pioche = new Pioche();	
			ivt.ajouterObjet(pioche);
			case1.setImage(new Image(pioche.getValPNG()));
			case1.setId(pioche.getId());
			
			cE = new ControlleurEtabli(this);
			
			pane.setVisible(false);

	
	}
    
    public void ajouterImageObjet() {
    	for(int i = 0; i < casesInventaire.size(); i++){
    		if(casesInventaire.get(i).getImage() == null) {
    			
				System.out.println(ivt.getDernierObjet());	
				
				casesInventaire.get(i).setImage( new Image( ivt.getDernierObjet().getValPNG() ) );
				casesInventaire.get(i).setId(ivt.getDernierObjet().getId());

    			if (ivt.getDernierObjet().getNom()=="etabli") {
    				casesInventaire.get(i).setOnMouseClicked((event) -> { afficheListeObjets() ;});
				
    			}
    		
    			break;
    			
    		}
    			
		}
    }
    
    @Override
	public void onChanged(ListChangeListener.Change<? extends Objet> c) {
		
		while (c.next()){
			if (  c.wasAdded()){
				System.out.println("ajout...");
				ajouterImageObjet();
			}
				
			else if (c.wasRemoved()){
				System.out.println("suppression...");
			}
			
		}

	}

	public Pane getPane() {
		return pane;
	}

	public ArrayList<ImageView> getListeImgView() {
		return this.casesInventaire;
		
	}
		
}

