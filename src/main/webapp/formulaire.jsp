<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMERCE</title>
<link rel="stylesheet" type="text/css" href="designp.css">
</head>
<body>
<h1>Informations du client</h1>

<div align="right">
    <img alt="" src="R.png" width="40" height="40" style="vertical-align: middle;">
    <a id="affichierPanier" href="http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp">afficher panier</a>
</div>

<div class="form-container">
    <form method="post" action="Commander" class="client-form">
        <label for="name">NOM :</label>
        <input id="name" type="text" name="nom" placeholder="Votre nom" required />

        <label for="prenom">PRENOM :</label>
        <input id="prenom" type="text" name="prenom" placeholder="Votre prénom" required />

        <label for="tlf">TELEPHONE :</label>
        <input id="tlf" type="text" name="telephone" placeholder="Votre numéro" required />

        <label for="adress">ADRESSE :</label>
        <input id="adress" type="text" name="adresse" placeholder="Votre adresse" required />

        <button id="enregistrer" type="submit">Enregistrer</button>
    </form>
</div>

</body>
</html>
