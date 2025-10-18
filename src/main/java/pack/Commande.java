package pack;
import java.util.Vector;

public class Commande {
	 private String nom; 
	    private String prenom; 
	    private String tel; 
	    private String adresse; 
	    private Vector<Article> achats; 
	     
	   
	     
	    // Getters 
	    public String getNom() { 
	        return nom; 
	    } 
	     
	    public String getPrenom() { 
	        return prenom; 
	
	 
	    } 
	     
	    public String getTel() { 
	        return tel; 
	    } 
	     
	    public String getAdresse() { 
	        return adresse; 
	    } 
	     
	    public Vector<Article> getAchats() { 
	        return achats; 
	    } 
	     
	    // Setters 
	    public void setNom(String nom) { 
	        this.nom = nom; 
	    } 
	     
	    public void setPrenom(String prenom) { 
	        this.prenom = prenom; 
	    } 
	     
	    public void setTel(String tel) { 
	        this.tel = tel; 
	    } 
	     
	    public void setAdresse(String adresse) { 
	        this.adresse = adresse; 
	} 
	public void setAchats(Vector<Article> achats) { 
	this.achats = achats; 
	} 
}
