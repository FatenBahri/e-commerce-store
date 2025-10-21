<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>COMMERCE</title>
<link rel="stylesheet" type="text/css" href="design.css">
</head>
<body>
<h1>informations de client</h1>
<div align="right">
<img alt="" src="R.png" width="40" height="40"style="vertical-align: middle;" >
		<a href="http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp" >afficher panier</a>
</div>
<form method="post" action="Commander">
  NOM: <input id="name" type="text" name="nom" /><br>
  PRENOM: <input id="prenom" type="text" name="prenom" /><br>
  TELEPHONE: <input id="tlf" type="text" name="telephone" /><br>
  ADRESSE: <input id="adress" type="text" name="adresse" /> <br>
    <button id="enregistrer" type="submit"   />enregistrer</button>
  
</form>

</body>
</html>