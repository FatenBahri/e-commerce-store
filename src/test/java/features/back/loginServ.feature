Feature: la connection en tant que admin et user en cas de success et echoue

  Scenario: Login admin 
     Given utilisateur envoie une requête POST à LoginServlet avec username "admin" et password "admin123"
     When le serveur traite la requête
     Then la réponse doit rediriger vers "admin.jsp"
     
  
   Scenario: Login user 
     Given utilisateur envoie une requête POST à LoginServlet avec username "user" et password "user123"
     When le serveur traite la requête
     Then la réponse doit rediriger vers "page1.jsp"
   
   
  Scenario: Login echoue 
     Given utilisateur envoie une requête POST à LoginServlet avec username "user45" et password "l;km "
     When le serveur traite la requête
     Then la réponse doit rediriger vers "login.jsp?error=true"
   