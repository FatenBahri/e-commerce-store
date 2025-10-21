Feature: tester servlet lorsque on commande un produit et remplissage de formulaire  et redirection

  Scenario: passer une commande 
     Given utilisateur envoie une requête POST à Commander avec nom "admin" et prenom "faten" et tlf "90047220" et adresse "tunis"
     When le serveur traite la requête et prepare la reponse
     Then la réponse doit rediriger vers la "AfficherPanierServlet.jsp"
     
  

  
  