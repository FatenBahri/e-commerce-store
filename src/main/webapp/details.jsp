<%@ page import="java.util.List" %>
<%@ page import="pack.Commande" %>
<%@ page import="pack.Article" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMERCE</title>
<link rel="stylesheet" type="text/css" href="designp.css">
</head>
<body>
<h2>Details de la commande</h2>
<br><br>
<%
    // Récupérer le paramètre "nom" depuis l'URL
    String clientNom = request.getParameter("nom");

    // Récupérer les commandes depuis le contexte de l'application
    List<Commande> commandes = (List<Commande>) application.getAttribute("commandes");

    if (commandes == null ) {
%>
    <p>Aucune commande trouvée.</p>
<%
    } else {
        // Rechercher la commande correspondant au client
        Commande clientCommande = null;
        for (Commande commande : commandes) {
            if (commande.getNom().equals(clientNom)) {
                clientCommande = commande;
                break;
            }
        }

        if (clientCommande == null) {
%>
    <p>Aucune commande trouvée pour ce client.</p>
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
            </tr>
        </thead>
        <tbody>
        <% 
            if (clientCommande.getAchats() != null) {
                for (Article article : clientCommande.getAchats()) {
        %>
            <tr>
                <td data-label="Nom"><%= article.getNom() %></td>
                <td data-label="Description"><%= article.getDescription() %></td>
                <td data-label="Prix"><%= article.getPrix() %></td>
            </tr>
        <% 
                }
            }
        %>
        </tbody>
    </table>
</div>
<%
        }
    }
%>
</body>
</html>
