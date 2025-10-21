package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Cette annotation indique à JUnit d'utiliser Cucumber comme moteur de test
@RunWith(Cucumber.class)

// Configuration de Cucumber
@CucumberOptions(
    features = "src/test/java/features/back",   // dossier des fichiers .feature
    glue = "steps/back",                           // dossier contenant les Steps Java
    plugin = {
        "pretty",                               // affichage lisible dans la console
        "html:target/cucumber-reports.html"   // rapport HTML généré            // rapport JSON (facultatif)
    },
    monochrome = true                // supprime les caractères colorés dans la console
)
public class TestRunnerBack {
    // Rien à écrire ici : JUnit se charge de tout exécuter automatiquement !
}
