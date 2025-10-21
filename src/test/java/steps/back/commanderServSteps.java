package steps.back;

import io.cucumber.java.en.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class commanderServSteps {

    // Objet qui représente la connexion HTTP vers le serveur
    private HttpURLConnection connection;

    // Pour stocker le code HTTP renvoyé par le serveur (ex: 200 = OK, 302 = redirection)
    private int responseCode;

    // Pour récupérer l'URL de redirection si le serveur fait une redirection après login
    private String locationHeader;

    // STEP 1: envoyer les identifiants au login
    @Given("utilisateur envoie une requête POST à Commander avec nom {string} et prenom {string} et tlf {string} et adresse {string}")
    public void envoyer_identifiants(String nom, String prenom,String tlf, String adresse) throws Exception {
        // Crée l'URL du Servlet Commander -servlet
        URL url = new URL("http://localhost:8081/e-commerce-v2/Commander");

        // Ouvre la connexion HTTP vers le serveur
        connection = (HttpURLConnection) url.openConnection();

        // On utilise la méthode POST pour envoyer les données du formulaire
        connection.setRequestMethod("POST");

        // Indique que la requête va envoyer des données (username et password)
        connection.setDoOutput(true);

        // Ne suit pas automatiquement la redirection : on veut vérifier l'URL de redirection nous-mêmes
        connection.setInstanceFollowRedirects(false);

        // Construire les paramètres comme dans un formulaire HTML
        String params = "nom=" + nom + "&prenom=" + prenom + "&tlf=" + tlf + "&adresse=" + adresse;

        // Envoyer les données sur la requête HTTP
        OutputStream os = connection.getOutputStream();
        os.write(params.getBytes());
        os.flush();
        os.close();
    }

    // STEP 2: récupérer la réponse du serveur
    @When("le serveur traite la requête et prepare la reponse")
    public void serveur_traite() throws Exception {
        // Récupérer le code HTTP renvoyé par le serveur
        responseCode = connection.getResponseCode();

        // Récupérer l'URL de redirection si le serveur a fait un sendRedirect
        //si le login est correct, LoginServlet fait response.sendRedirect("AfficherPanierServlet.jsp"). Alors Location = AfficherPanierServlet.jsp
        locationHeader = connection.getHeaderField("Location");
    }

    // STEP 3: vérifier que la redirection est correcte
    @Then("la réponse doit rediriger vers la {string}")
    public void verifier_redirection(String expectedUrl) {
        // Vérifier que le code HTTP correspond à une redirection (302) ou echoue
        assertEquals(302, responseCode);

        // Vérifier que l'URL de redirection contient l'URL attendue
        assertTrue(locationHeader.contains(expectedUrl));
    }
}
