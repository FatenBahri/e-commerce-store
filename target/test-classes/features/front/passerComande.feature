Feature: passer une commande et gerer partie admin
Scenario: button commander marche avec sucees et remplissage de formulaire
     Given l'utilisateur ouvre la page panier
     When clic sur le button commander
     Then il doit être dirigé vers le formulaire
     When il remplir le name "faten" et il remplir prenom "bahri" et il remplir tlf "90047220" et adress "sfax"
     And clic sur button enregister
     Then il doit être redirigé vers la page panier


Scenario: verifier le passation de commande cote admin
     Given l'utilisateur est sur la page admin
    When il clic sur le lien voir details
     Then il doit être dirigé vers la page details


Scenario: archiver les commandes eq livaison => suppresion
     Given l'utilisateur est sur la page admin
    When il clic sur le button archiver
     Then il doit être redirigé vers la page admin
