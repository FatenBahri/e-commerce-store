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
		<a href="http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp" >afficher panier</a>
</div>
<table border="2">
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
      <td>clavier Mecanique</td>
      <td>switches cherry mx</td>
      <td>89.99</td>
      <td>
         <a href="AjouterServlet?nom=clavier Mecanique&descp=switches cherry mx&prix=89.99" >ajouter au panier</a>	

      </td>
    </tr>
    <tr>
      <td>ecran 24"</td>
      <td>full hd, 144Hz</td>
      <td>199.99</td>
      <td>
         <a href="AjouterServlet?nom=ecran 24&descp=full hd, 144Hz&prix=199.99" >ajouter au panier</a>	

      </td>
    </tr>
    
  </tbody>
</table>


<br>
<button><a href="page1.jsp">retour</a></button>
</body>
</html>