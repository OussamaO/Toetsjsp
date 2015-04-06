package toets;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Auto {
    private final String merk;
    private final String type;
    private final int prijs;
    private final String fotourl;
    
    
    public Auto(String merk, String type, int prijs, String fotourl) {
        this.merk = merk;
        this.type = type;
        this.prijs = prijs;
        this.fotourl = fotourl;
    }
    
    public String getMerk() {
        return merk;
    }
    
    public String getType() {
        return type;
    }
    
    public int getPrijs() {
    	
        return prijs;
    }
    
    public String getFoto() {
        return fotourl;
    }

    public String getPrijsFormat() {
    	DecimalFormat df = new DecimalFormat("#,##0.--");
    	  DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
    	  
    	  dfs.setDecimalSeparator(',');
    	  dfs.setGroupingSeparator('.');
    	  df.setDecimalFormatSymbols(dfs);
    	  
    	  double prijs = (double) this.getPrijs();
    	  String sPrijs = df.format(prijs);
    	  return sPrijs;
    	
    }
    
    
}
