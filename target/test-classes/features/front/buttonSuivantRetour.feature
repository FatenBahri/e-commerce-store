Feature: Test de les buttons suivant retour de site
  Scenario: Navigation complète entre les pages
     Given l'utilisateur est sur la page 1
     When il clique sur le bouton suivant
     Then il doit être redirigé vers la page 2
     When il clique sur le bouton retour
     Then il doit revenir à la page 1
