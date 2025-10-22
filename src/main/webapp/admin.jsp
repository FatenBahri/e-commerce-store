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
<link rel="stylesheet" type="text/css" href="designp.css">
</head>
<body>

<h2>Les Commandes</h2>
<br><br>
<%
    List<Commande> commandes = (List<Commande>) application.getAttribute("commandes");

    if (commandes == null || commandes.isEmpty()) {
%>
    <p>Aucune commande pour le moment.</p>
<%
    } else {
%>
<div class="table-container">
    <table>
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Téléphone</th>
                <th>Adresse</th>
                <th>Commande</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Commande comm : commandes) {
        %>
            <tr>
                <td data-label="Nom"><%= comm.getNom() %></td>
                <td data-label="Prénom"><%= comm.getPrenom() %></td>
                <td data-label="Téléphone"><%= comm.getTel() %></td>
                <td data-label="Adresse"><%= comm.getAdresse() %></td>
                <td data-label="Commande">
                    <a id="voirDetails" href="details.jsp?nom=<%= comm.getNom() %>">Voir détails</a>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<button id="archiver"><a href="appSupprimer">Archiver</a></button>
<%
    }
%>

</body>
</html>
