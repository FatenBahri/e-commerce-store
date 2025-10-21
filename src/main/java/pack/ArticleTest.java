package pack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;

import org.junit.Test;

public class ArticleTest {
       Article art = new Article("coleur jolie", "clavier", 50.0);
    @Before
    public void gretting() {
    	System.out.println("begin testing");
    }
    @Test
    public void testGetNom() {
        assertEquals("clavier", art.getNom());
    	System.out.println("nom testing");

    }
    @Test
    public void testGetdesc() {
        assertEquals("coleur jolie", art.getDescription());
    	System.out.println("desc testing");

    }
	@Test
    public void testGetprix() {
        assertEquals(50.001, art.getPrix(),0.001); //delta = tolerance +- 0.001
    	System.out.println("prix testing");

    }
    
    @After
    public void closed() {
    	System.out.println("end testing");
    }
}