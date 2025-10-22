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
<h1>les articles disponibles</h1>

<div align="right">
    <img alt="" src="R.png" width="40" height="40" style="vertical-align: middle;">
    <a id="affichierPanier" href="http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp">afficher panier</a>
</div>

<div class="table-container">
<table>
  <thead>
    <tr>
      <th>Article</th>
      <th>Description</th>
      <th>Prix</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td data-label="Article">clavier Mecanique</td>
      <td data-label="Description">switches cherry mx</td>
      <td data-label="Prix">89.99</td>
      <td data-label="Action">
         <a id="ajouter" href="AjouterServlet?nom=clavier Mecanique&descp=switches cherry mx&prix=89.99">ajouter au panier</a>    
      </td>
    </tr>
    <tr>
      <td data-label="Article">ecran 24"</td>
      <td data-label="Description">full hd, 144Hz</td>
      <td data-label="Prix">199.99</td>
      <td data-label="Action">
         <a id="ajouter" href="AjouterServlet?nom=ecran 24&descp=full hd, 144Hz&prix=199.99">ajouter au panier</a>    
      </td>
    </tr>
  </tbody>
</table>
</div>

<br>
<button id="btnRetour"><a href="page1.jsp">retour</a></button>
</body>
</html>
