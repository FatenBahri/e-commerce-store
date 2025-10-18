

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.Article;

import java.io.IOException;
import java.util.Vector;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true); // Crée ou récupère la session
        Vector<Article> panier = (Vector<Article>) session.getAttribute("panier");

        if (panier == null) {
            panier = new Vector<>();
        }

        // Ajouter un article
        String nom = request.getParameter("nom");
        String descp = request.getParameter("descp");
        double prix = Double.parseDouble(request.getParameter("prix"));
        Article article = new Article();
        article.setDescription(descp);
        article.setNom(nom);
        article.setPrix(prix);
        panier.add(article);//ajout de larticle au panier
        session.setAttribute("panier", panier);// Ajouter le produit dans la session :mise a joour de session

        
  
        

        //response.getWriter().println(article);
        
        response.sendRedirect("http://localhost:8081/e-commerce-v2/AfficherPanierServlet.jsp");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
