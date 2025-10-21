package steps.front;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contenuPanierSteps {
    WebDriver driver;

    @Given("l'utilisateur est sur la page 1 ou 2")
    public void ouvrir_dashboard() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/e-commerce-v2/page1.jsp");
        attendre(2000); // attendre 2s pour le chargement
    }

    @When("clic sur le lien ajouter panier")
    public void cliquer_lien_ajouter_panier() {
        driver.findElement(By.id("ajouter")).click();
        attendre(2000);
    }

    @Then("il doit être dirigé vers la page de panier")
    public void verifier_pagePanier() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("AfficherPanierServlet.jsp")) {
            System.out.println("✅ ajout réussie vers panier !");
        } else {
            System.out.println("❌ La page de panier n'est pas atteinte !");
        }
        
    }
    @When("clic sur le lien afficher panier")
    public void cliquer_lien_afficher_panier() {
        driver.findElement(By.id("affichierPanier")).click();
        attendre(2000);
    }
    @Given("l'utilisateur est sur la page panier")
    public void affich_panier() {
        driver = new ChromeDriver();

        driver.get("http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp");
        attendre(2000); // attendre 2s pour le chargement
    }
    @When("clic sur le lien retour au catalogue")
    public void cliquer_lien_retour_cat() {
        driver.findElement(By.id("retourCat")).click();
        attendre(2000);
    }
    @Then("il doit être dirigé vers la page 1 ou 2")
    public void verifier_page1() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("page1.jsp")) {
            System.out.println("✅ Navigation réussie vers page2 !");
        } else {
            System.out.println("❌ La page1 n'est pas atteinte !");
        }
     
    }
    int tailleAvant;

    @When("clic sur le lien supprimer")
    public void cliquer_lien_supprimer() {
        // Récupérer la taille actuelle du panier avant suppression
        List<WebElement> boutons = driver.findElements(By.className("supprimer"));
        tailleAvant = boutons.size();

        if (tailleAvant > 0) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // clique sur le premier bouton supprimer trouvé
            WebElement supprimerBtn = wait.until(ExpectedConditions.elementToBeClickable(boutons.get(0)));
            supprimerBtn.click();       
            attendre(2000);
        } else {
            System.out.println("⚠️ Aucun article à supprimer !");
        }
    } 
    @Then("il doit être sur la meme  page de panier et elemet etre supprimer\r\n"
    		+ "")
    public void supprimer_element() {
        String urlActuelle = driver.getCurrentUrl();
        if (urlActuelle.contains("AfficherPanierServlet.jsp")) {
            System.out.println("✅ supprission réussie vers panier !");
        } else {
            System.out.println("❌ erreur supprission !");
        }
        
    }
   
    //@After est une annotation Cucumber spéciale qui s’exécute après chaque scénario, automatiquement.
    @After
    public void fermer_navigateur() {
        if (driver != null) {
            driver.quit();
        }
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
