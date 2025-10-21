package steps.back;

import io.cucumber.java.en.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class suppAjouServSteps {

    // Objet qui représente la connexion HTTP vers le serveur
    private HttpURLConnection connection;

    // Pour stocker le code HTTP renvoyé par le serveur (ex: 200 = OK, 302 = redirection)
    private int responseCode;

    // Pour récupérer l'URL de redirection si le serveur fait une redirection après login
    private String locationHeader;
    
    @Given("utilisateur envoie  une requête GET avec les paramètres dans l’URL  à AjouterServlet nom {string} et descp {string} et prix {string}")
    public void ajouter_article_via_url(String nom, String descp, String prix) throws Exception {
        // Crée l'URL exactement comme la page web l'envoie
    	 String urlStr = "http://localhost:8081/e-commerce-v2/AjouterServlet?nom=" 
                 +nom +"&descp="+descp +"&prix=" + Double.parseDouble(prix);

        URL url = new URL(urlStr);
        connection = (HttpURLConnection) url.openConnection();

        // GET car c'est comme un lien cliqué
        connection.setRequestMethod("GET");

        // Ne pas suivre automatiquement la redirection
        connection.setInstanceFollowRedirects(false);
    }

    @When("le serveur traite l'ajout via URL")
    public void serveur_traite_ajout_url() throws Exception {
        responseCode = connection.getResponseCode();
        locationHeader = connection.getHeaderField("Location");
    }

    @Then("article est ajouté et il est redirigé vers {string}")
    public void verifier_redirection_ajout(String expectedUrl) {
        assertEquals(302, responseCode); // Redirection attendue
        System.out.println(locationHeader);
        System.out.println(responseCode);
        assertTrue(locationHeader.contains(expectedUrl));
    }
  
    @Given("utilisateur envoie  une requête GET avec les paramètres dans URL  à SupprimerServlet avec nom {string} et descp {string} et prix {string}")
    public void supprimer_article_via_url(String nom, String descp, String prix) throws Exception {
        // Crée l'URL exactement comme la page web l'envoie
        String urlStr = "http://localhost:8081/e-commerce-v2/SupprimerServlet?nom=" 
                        +nom +"&descp="+descp +"&prix=" + Double.parseDouble(prix);

        URL url = new URL(urlStr);
        connection = (HttpURLConnection) url.openConnection();

        // GET car c'est comme un lien cliqué
        connection.setRequestMethod("GET");

        // Ne pas suivre automatiquement la redirection
        connection.setInstanceFollowRedirects(false);
    }
    @Then("article est supprimé et il est redirigé vers {string}")
    public void verifier_redirection_suppression(String expectedUrl) {
        assertEquals(302, responseCode); // Redirection attendue
        assertTrue(locationHeader.contains(expectedUrl));
    }

}
