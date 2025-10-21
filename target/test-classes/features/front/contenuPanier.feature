Feature: afficher contenu de panier et ajouter/supprimer des elements 
  Scenario: ajouter des articles au panier avec success
     Given l'utilisateur est sur la page 1 ou 2
     When clic sur le lien ajouter panier
     Then il doit être dirigé vers la page de panier

 Scenario: supprimer des articles du panier avec success
     Given l'utilisateur est sur la page panier
     When clic sur le lien supprimer
     Then il doit être sur la meme  page de panier et elemet etre supprimer

 Scenario: afficher le contenu du panier
     Given l'utilisateur est sur la page 1 ou 2
     When clic sur le lien afficher panier
     Then il doit être dirigé vers la page de panier    
  
 Scenario: retour au catalogue dapres la page panier
     Given l'utilisateur est sur la page panier
     When clic sur le lien retour au catalogue
     Then il doit être dirigé vers la page 1 ou 2
     


     