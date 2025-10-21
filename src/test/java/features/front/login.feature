Feature: Test de le login 
  Scenario: login au site avec success en tant que admin
     Given l'utilisateur est sur la page de login
     When il remplir le username "admin" et il remplir password "admin123"
     And clic sur button se connecter
     Then il doit être dirigé vers la page admin


 Scenario: login au site avec success en tant que user
     Given l'utilisateur est sur la page de login
     When il remplir le username "user" et il remplir password "user123"
     And clic sur button se connecter
     Then il doit être dirigé vers la page 1     