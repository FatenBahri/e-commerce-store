Feature: ajouter et supprimer des produits avec success  

Scenario: ajouter des produits avec success                                                                    
   Given utilisateur envoie  une requête GET avec les paramètres dans l’URL  à AjouterServlet nom "OrdinateurPortable" et descp "HP15pouces8GBRAM" et prix "699.99" 
    When le serveur traite l'ajout via URL                                                          
   Then article est ajouté et il est redirigé vers "AfficherPanierServlet.jsp"                                   


Scenario: supprimer des produits avec success                                                                    
   Given utilisateur envoie  une requête GET avec les paramètres dans URL  à SupprimerServlet avec nom "OrdinateurPortable" et descp "HP15pouces8GBRAM" et prix "699.99" 
    When le serveur traite l'ajout via URL                                                          
   Then article est supprimé et il est redirigé vers "AfficherPanierServlet.jsp"              
   