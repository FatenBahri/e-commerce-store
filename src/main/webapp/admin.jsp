<%@ page import="java.util.Vector" %>
<%@ page import="pack.Article" %>
<%@ page import="pack.Commande" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMERCE</title>
<link rel="stylesheet" type="text/css" href="design.css">

</head>
<body>
    <h2>les commandes</h2>

    <%
        // Récupérer les commandes depuis la application 
 List<Commande> commandes = (List<Commande>) application.getAttribute("commandes");

        if (commandes == null ) {
    %>
        <p>pas de commande.</p>
    <%
        } else {
    %>
        <!-- Déclarer le bean une seule fois -->
        <jsp:useBean id="commande" class="pack.Commande" scope="page" />

        <table border="1">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>prenom</th>
                    <th>tel</th>
                    <th>Adresse</th>
                    <th>commande</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Parcourir les articles du panier
                    for (Commande comm : commandes) {
                %>
                <!-- Mettre à jour les propriétés du bean -->
                <jsp:setProperty name="commande" property="nom" value="<%= comm.getNom() %>" />
                <jsp:setProperty name="commande" property="prenom" value="<%= comm.getPrenom() %>" />
                <jsp:setProperty name="commande" property="tel" value="<%= comm.getTel() %>" />
                <jsp:setProperty name="commande" property="adresse" value="<%= comm.getAdresse() %>" />
                <jsp:setProperty name="commande" property="achats" value="<%= comm.getAchats() %>" />
                
                <tr>
                    <td><jsp:getProperty name="commande" property="nom" /></td>
                    <td><jsp:getProperty name="commande" property="prenom" /></td>
                    <td><jsp:getProperty name="commande" property="tel" /> </td>
                    <td><jsp:getProperty name="commande" property="adresse" /> </td>
                    
                   <td>
                   <a id="voirDetails" href="details.jsp?nom=<%= comm.getNom() %>">
                        Voir détails
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
<button><a id="archiver" href="appSupprimer" >archiver</a></button>
</body>
</html>
