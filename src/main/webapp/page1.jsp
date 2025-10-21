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
<h1>les articles disponibles</h1>
<div align="right">
<img alt="" src="R.png" width="40" height="40"style="vertical-align: middle;" >
		<a id="affichierPanier" href="http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp" >afficher panier</a>
</div>
<table border="2">
  <thead>
    <tr>
      <th>Article</th>
      <th>Description</th>
      <th>Prix</th>
      <th>ajouter</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>OrdinateurPortable</td>
      <td>HP 15 pouces, 8GB RAM</td>
      <td>699.99</td>
      
      <td>
         <a id="ajouter" href="AjouterServlet?nom=Ordinateur Portable&descp=HP 15 pouces 8GB RAM&prix=699.99" >ajouter au panier</a>	
	
      </td>
    </tr>
    <tr>
      <td>SourisSansFil</td>
      <td>Logitech M185</td>
      <td>12.99</td>
      <td>
        <a id="ajouter" href="AjouterServlet?nom=Souris Sans Fil&descp=Logitech M185&prix=12.99" >ajouter au panier</a>	

      </td>
    </tr>
  </tbody>
</table>


<br>
<button id="btnSuivant"><a href="page2.jsp" >suivant</a></button>
</body>
</html>