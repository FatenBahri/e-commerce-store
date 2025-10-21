package steps.front;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginSteps {
    WebDriver driver;

    @Given("l'utilisateur est sur la page de login")
    public void ouvrir_dashboard() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/e-commerce-v2/login.jsp");
        attendre(2000); // attendre 2s pour le chargement
    }

    @When("il remplir le username {string} et il remplir password {string}")
    public void remplirDonnes(String name,String pass) {
        WebElement nom = driver.findElement(By.id("username"));
        nom.clear(); // efface d'abord
        nom.sendKeys(name); // saisit le nom
        WebElement motpass = driver.findElement(By.id("password"));
        motpass.clear(); // efface d'abord
        motpass.sendKeys(pass); // saisit le motpasse
        attendre(2000);
    }
    @When("clic sur button se connecter")
    public void cliquer_button_retour() {
        driver.findElement(By.id("btnlogin")).click();
        attendre(2000);
    }
    

    @Then("il doit être dirigé vers la page admin")
    public void verifier_page_admin() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("admin.jsp")) {
            System.out.println("✅  réussi vers la page admin!");
        } else {
            System.out.println("❌  échoué !");
        }

        // Fermer le navigateur à la fin du test
        attendre(2000);
        driver.quit();
    }
    @Then("il doit être dirigé vers la page 1")
    public void verifier_page1() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("page1.jsp")) {
            System.out.println("✅  réussi vers la page 1!");
        } else {
            System.out.println("❌  échoué !");
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
