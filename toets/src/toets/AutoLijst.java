package toets;

import java.util.ArrayList;
import java.awt.*;

public class AutoLijst {
    private ArrayList<Auto> autolijst;
    int minprijs = 0;
    int maxprijs = Integer.MAX_VALUE;
    
    /**
     * Constructor die de lijst aanmaakt en auto's toevoegt
     */
    public AutoLijst() {
        autolijst = new ArrayList<Auto>();	
        Auto ford1 = new Auto("Ford", "Fiesta", 23999, 
          "fotos/fordfiesta.jpg");
        autolijst.add(ford1);
        Auto ford2 = new Auto("Ford", "Focus", 18995, 
          "fotos/fordfocus.jpg");
        autolijst.add(ford2);
        Auto opel1 = new Auto("Opel", "Astra", 14895, 
          "fotos/opelastra.jpg");
        autolijst.add(opel1);
        Auto opel2 = new Auto("Opel", "Insignia", 65450, 
          "fotos/opelinsignia.jpg");
        autolijst.add(opel2);
        Auto subaru1 = new Auto("Subaru", "Forester", 34750, 
          "fotos/subaruforester.jpg");
        autolijst.add(subaru1);
        Auto subaru2 = new Auto("Subaru", "Impreza", 28345, 
          "fotos/subaruimpreza.jpg");
        autolijst.add(subaru2);
        Auto mercedes2 = new Auto("Mercedes", "CLA 45", 190780, 
          "fotos/mercedescla45.jpg");
        autolijst.add(mercedes2);
        Auto ferrari1 = new Auto("Ferrari", "612 GTO", 350500, 
          "fotos/ferrari612.jpg");
        autolijst.add(ferrari1);
        Auto citroen1 = new Auto("Citroen", "2CV", 459, 
          "fotos/citroen2cv.jpg");
        autolijst.add(citroen1);
        Auto mini1 = new Auto("Mini", "Cooper", 34495, 
          "fotos/minicooper.jpg");
        autolijst.add(mini1);
     }
    
    /**
     * 
     * @return geeft de lijst met auto's
     */
    public ArrayList<Auto> getLijst() {
        return autolijst;
    }
    
    
    
    /**
     * Ten behoeve van het select merk input veld
     * @return een lijst met alle unieke merken
     */
    public ArrayList<String> getMerken() {
        ArrayList<String> merken = new ArrayList<String>();
        for (Auto auto: autolijst) {
            String merk = auto.getMerk();
            if (!merken.contains(merk)) {
                merken.add(merk);
            }
        }
        return merken;
    }
    
    
    
    public ArrayList<Auto> getFilter(String merk, int minprijs,int maxprijs){
        
        ArrayList<Auto> prijslijst= new ArrayList();
           
        for(Auto a : this.autolijst){
         if(a.getMerk().equals(merk) &&  a.getPrijs() >= minprijs && a.getPrijs() <= maxprijs) {
          prijslijst.add(a);
          }
         if(merk.equals("alle") &&  a.getPrijs() >= minprijs && a.getPrijs() <= maxprijs) {
             prijslijst.add(a);
             }
         	
         }
        return prijslijst;
       }
    
    
}
