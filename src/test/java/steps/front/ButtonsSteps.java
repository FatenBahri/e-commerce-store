package steps.front;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ButtonsSteps {
    WebDriver driver;

    @Given("l'utilisateur est sur la page 1")
    public void ouvrir_dashboard() {
    	// Example Java/Selenium WebDriver setup modification
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");       // Run without a GUI
    	options.addArguments("--no-sandbox");    // Required for Jenkins/Linux environments
    	options.addArguments("--disable-dev-shm-usage"); // Helps prevent "Out of memory" errors
    	WebDriver driver = new ChromeDriver(options);
        driver.get("http://localhost:8081/e-commerce-v2/page1.jsp");
        attendre(2000); // attendre 2s pour le chargement
    }

    @When("il clique sur le bouton suivant")
    public void cliquer_button_suivant() {
        driver.findElement(By.id("btnSuivant")).click();
        attendre(2000);
    }

    @Then("il doit être redirigé vers la page 2")
    public void verifier_page2() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("page2.jsp")) {
            System.out.println("✅ Navigation réussie vers la page 2 !");
        } else {
            System.out.println("❌ La page 2 n'est pas atteinte !");
        }
        attendre(2000);
    }

    @When("il clique sur le bouton retour")
    public void cliquer_button_retour() {
        driver.findElement(By.id("btnRetour")).click();
        attendre(2000);
    }

    @Then("il doit revenir à la page 1")
    public void verifier_page1() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("page1.jsp")) {
            System.out.println("✅ Retour réussi vers la page 1 !");
        } else {
            System.out.println("❌ Retour échoué !");
        }

        // Fermer le navigateur à la fin du test
        attendre(2000);
        driver.quit();
    }

    // Petite méthode utilitaire pour éviter de répéter try/catch
    private void attendre(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
