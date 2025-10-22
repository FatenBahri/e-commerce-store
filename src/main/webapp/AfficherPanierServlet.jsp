<%@ page import="java.util.Vector" %>
<%@ page import="pack.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMERCE</title>
<link rel="stylesheet" type="text/css" href="designp.css">
</head>
<body>
<h2>Votre Panier</h2>

<div align="right">
    <img alt="" src="R.png" width="40" height="40" style="vertical-align: middle;">
    <a id="retourCat" href="http://localhost:8081/e-commerce-v2/page1.jsp">retour au catalogue</a>
</div>

<%
    Vector<Article> panier = (Vector<Article>) session.getAttribute("panier");

    if (panier == null || panier.isEmpty()) {
%>
    <p>Le panier est vide.</p>
<%
    } else {
%>
<div class="table-container">
    <table>
        <thead>
            <tr>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% 
            for (Article articleItem : panier) {
        %>
            <tr>
                <td data-label="Nom"><%= articleItem.getNom() %></td>
                <td data-label="Description"><%= articleItem.getDescription() %></td>
                <td data-label="Prix"><%= articleItem.getPrix() %> €</td>
                <td data-label="Action">
                    <a class="supprimer" href="SupprimerServlet?nom=<%= articleItem.getNom() %>&descp=<%= articleItem.getDescription() %>&prix=<%= articleItem.getPrix() %>">Supprimer</a>
                </td>
            </tr>
        <% 
            }
        %>
        </tbody>
    </table>
</div>
<br>
<button id="commander"><a  href="formulaire.jsp">Commander</a></button>
<%
    }
%>
</body>
</html>
