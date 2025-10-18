import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Article;

import java.io.IOException;
import java.util.Vector;

@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SupprimerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la session existante
        HttpSession session = request.getSession(false);

        // Vérifier si la session existe
        if (session == null) {
            response.sendRedirect("http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp"); // Rediriger si la session n'existe pas
            return;
        }

        // Récupérer le panier depuis la session
        Vector<Article> panier = (Vector<Article>) session.getAttribute("panier");

        // Vérifier si le panier n'est pas null
        if (panier != null ) {
            // Récupérer les paramètres de la requête
            String nom = request.getParameter("nom");
            String descp = request.getParameter("descp");
            double prixParm = Double.parseDouble(request.getParameter("prix"));

            // Parcourir le panier à l'envers pour supprimer l'article
            for (int i = panier.size() - 1; i >= 0; i--) {
                Article articleItem = panier.get(i);

                // Vérifier si l'article correspond aux critères de suppression
                if (articleItem.getNom().equals(nom) || 
                    articleItem.getDescription().equals(descp) || 
                    articleItem.getPrix() == prixParm) {
                    
                    panier.remove(i); // Supprimer l'article
                    break;
                }
            }

            // Mettre à jour le panier dans la session après suppression
            session.setAttribute("panier", panier);
        }

        // Rediriger vers la page d'affichage du panier
        response.sendRedirect("http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
