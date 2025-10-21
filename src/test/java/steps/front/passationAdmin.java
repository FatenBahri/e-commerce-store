package steps.front;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class passationAdmin {

    WebDriver driver;

    // ----------------- Partie utilisateur -----------------
    @Given("l'utilisateur ouvre la page panier")
    public void pagePanier() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp");
        attendre(2000);
    }

    @When("clic sur le button commander")
    public void clicButtonCommander() {
        driver.findElement(By.id("commander")).click();
        attendre(2000);
    }

    @Then("il doit être dirigé vers le formulaire")
    public void verifPageFormulaire() {
        if(driver.getCurrentUrl().contains("formulaire.jsp")){
            System.out.println("✅ Page formulaire ouverte");
        } else {
            System.out.println("❌ Page formulaire non atteinte");
        }
        attendre(1000);
    }

    @When("il remplir le name {string} et il remplir prenom {string} et il remplir tlf {string} et adress {string}")
    public void remplirFormulaire(String name, String prenom, String tlf, String adresse) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("prenom")).sendKeys(prenom);
        driver.findElement(By.id("tlf")).sendKeys(tlf);
        driver.findElement(By.id("adress")).sendKeys(adresse);
        attendre(1000);
    }

    @When("clic sur button enregister")
    public void clicButtonEnregistrer() {
        driver.findElement(By.id("enregistrer")).click();
        attendre(2000);
    }

    @Then("il doit être redirigé vers la page panier")
    public void verifRedirectionPanier() {
        if(driver.getCurrentUrl().contains("AfficherPanierServlet.jsp")){
            System.out.println("✅ Redirection vers panier réussie");
        } else {
            System.out.println("❌ Redirection échouée");
        }
    }

    // ----------------- Partie Admin -----------------
    @Given("l'utilisateur est sur la page admin")
    public void pageAdmin() {
        driver = new ChromeDriver();

        driver.get("http://localhost:8081/e-commerce-v2/admin.jsp");
        attendre(2000);
    }

    @When("il clic sur le lien voir details")
    public void voirDetails() {
        driver.findElement(By.id("voirDetails")).click();
        attendre(2000);
    }

    @Then("il doit être dirigé vers la page details")
    public void verifPageDetails() {
        if(driver.getCurrentUrl().contains("details.jsp")){
            System.out.println("✅ Page details ouverte");
        } else {
            System.out.println("❌ Page details non atteinte");
        }
    }

    @When("il clic sur le button archiver")
    public void clicButtonArchiver() {
        driver.findElement(By.id("archiver")).click();
        attendre(2000);
    }

    @Then("il doit être redirigé vers la page admin")
    public void verifRedirectionAdmin() {
        if(driver.getCurrentUrl().contains("admin.jsp")){
            System.out.println("✅ Redirection vers admin réussie");
        } else {
            System.out.println("❌ Redirection vers admin échouée");
        }
        driver.quit();
    }

    // Méthode utilitaire pour pause
    private void attendre(int ms){
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
