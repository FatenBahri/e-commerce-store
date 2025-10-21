package pack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandeTest {
    Commande commande = new Commande();
    Article article1,article2;

    
    @Before
    public void setUp() {
        // Création d'articles pour le panier
        article1 = new Article();
        article1.setNom("Produit1");
        article1.setDescription("Desc1");
        article1.setPrix(50.0);
        
        article2 = new Article();
        article2.setNom("Produit2");
        article2.setDescription("Desc2");
        article2.setPrix(100.0);
    	System.out.println("begin testing declaration des articles dans le panier avant commencer test");

    }

    @Test
    public void testSetGetNom() {
        commande.setNom("Faten");
        assertEquals("Faten", commande.getNom());
    }

    @Test
    public void testSetGetPrenom() {
        commande.setPrenom("Bahri");
        assertEquals("Bahri", commande.getPrenom());
    }

    @Test
    public void testSetGetTel() {
        commande.setTel("90047220");
        assertEquals("90047220", commande.getTel());
    }

    @Test
    public void testSetGetAdresse() {
        commande.setAdresse("Sfax");
        assertEquals("Sfax", commande.getAdresse());
    }

    @Test
    public void testSetGetAchats() {
        Vector<Article> achats = new Vector<>();
        achats.add(article1);
        achats.add(article2);
        
        commande.setAchats(achats);
        Vector<Article> result = commande.getAchats();
        
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Produit1", result.get(0).getNom());
        assertEquals("Produit2", result.get(1).getNom());
        assertEquals(50.0, result.get(0).getPrix(), 0.001);
        assertEquals(100.0, result.get(1).getPrix(), 0.001);
    }
    @After
    public void closed() {
    	System.out.println("end testing");
    }
}
