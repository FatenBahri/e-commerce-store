

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Article;
import pack.Commande;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Servlet implementation class Commander
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commander() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(true); // Crée ou récupère la session
	     Vector<Article> panier = (Vector<Article>) session.getAttribute("panier");
		Commande commande=new Commande();
       String nom=request.getParameter("nom");
       String prenom=request.getParameter("prenom");
       String telephone=request.getParameter("telephone");
       String adresse=request.getParameter("adresse");
       commande.setNom(nom);
       commande.setPrenom(prenom);
       commande.setAdresse(adresse);
       commande.setTel(telephone);
       commande.setAchats(panier);
       ServletContext context = getServletContext();
       List<Commande> commandes = (List<Commande>) context.getAttribute("commandes");

if (commandes == null) {
    commandes = new ArrayList<>();
}

commandes.add(commande);
context.setAttribute("commandes", commandes);
session.removeAttribute("panier");
response.sendRedirect("http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp");

	}

}
