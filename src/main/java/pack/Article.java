package pack;

public class Article {
	private String descp; 
	private String nom; 
	private double prix; 
	//Constructeur 
	 
	 
	    
	     
	    public Article(String descp, String nom, double prix) {
		super();
		this.descp = descp;
		this.nom = nom;
		this.prix = prix;
	}
		public Article() {
			super();
		}
		// Getters 
	    public String getDescription() { 
	        return descp; 
	    } 
	     
	    public String getNom() { 
	        return nom; 
	    } 
	     
	    public double getPrix() { 
	        return prix; 
	    } 
	     
	    // Setters 
	    public void setDescription(String descp) { 
	        this.descp= descp; 
	    } 
	     
	    public void setNom(String nom) { 
	        this.nom = nom; 
	    } 
	     
	    public void setPrix(double prix) { 
	
	        this.prix = prix; 
	    } 
	
}
