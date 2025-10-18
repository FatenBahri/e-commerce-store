<%@ page import="java.util.Vector" %>
<%@ page import="pack.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMERCE</title>
<link rel="stylesheet" type="text/css" href="design.css">

</head>
<body>
    <h2>Votre Panier</h2>
<div align="right">
<img alt="" src="R.png" width="40" height="40"style="vertical-align: middle;" >
		<a href="http://localhost:8081/e-commerce-v2/page1.jsp" >retour au catalogue</a>
</div>
    <%
        // Récupérer le panier depuis la session
        Vector<Article> panier = (Vector<Article>) session.getAttribute("panier");

        if (panier == null ) {
    %>
        <p>Le panier est vide.</p>
    <%
        } else {
    %>
        <!-- Déclarer le bean une seule fois -->
        <jsp:useBean id="article" class="pack.Article" scope="page" />

        <table border="1">
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
                    // Parcourir les articles du panier
                    for (Article articleItem : panier) {
                %>
                <!-- Mettre à jour les propriétés du bean -->
                <jsp:setProperty name="article" property="nom" value="<%= articleItem.getNom() %>" />
                <jsp:setProperty name="article" property="description" value="<%= articleItem.getDescription() %>" />
                <jsp:setProperty name="article" property="prix" value="<%= articleItem.getPrix() %>" />
                
                <tr>
                    <td><jsp:getProperty name="article" property="nom" /></td>
                    <td><jsp:getProperty name="article" property="description" /></td>
                    <td><jsp:getProperty name="article" property="prix" /> €</td>
                    <td>
                        <a href="SupprimerServlet?nom=<jsp:getProperty name='article' property='nom' />&descp=<jsp:getProperty name='article' property='description' />&prix=<jsp:getProperty name='article' property='prix' />">
                            Supprimer
                        </a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        }
    %>
 <br>
<button><a href="formulaire.jsp" >commander</a></button>
</body>
</html>
