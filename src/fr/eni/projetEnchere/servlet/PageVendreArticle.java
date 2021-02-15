

package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.AnnuaireArticleManager;
import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;


@WebServlet(name ="PageVendreArticle",
value = {"/VendreArticle"})


public class PageVendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Categorie> categories;
	CategorieManager cat ;
	DateTimeFormatter df;
	Utilisateur u;
	AnnuaireArticleManager a;

	@Override
	public void init() throws ServletException {
		super.init();
		cat = CategorieManager.getInstance();
		StringBuilder messageerreur = new StringBuilder();
		try {
			categories=cat.getCategories();
		} catch (BLLException e) {
			messageerreur.append("Je n'arrive pas � r�cup�rer les Categories");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		u=(Utilisateur) session.getAttribute("utilisateurConnecte");
		request.setAttribute("listeCategorie", categories);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pagevendrearticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// je m'assure que TomCat decodera en UTF8
		request.setCharacterEncoding("UTF-8");
		Categorie categorie=null;
		ArticleVendu article=null;
		String nomProduit,description;
		LocalDate dateDebut=null;
		LocalDate dateFin=null;
		int idcategorie;
		int miseAPrix=0;
		StringBuilder message = new StringBuilder();
		// R�cup�ration du nom de l'article
		nomProduit=request.getParameter("sarticle");
		if(nomProduit==null || nomProduit.trim().isEmpty()) {
			message.append("Le nom du produit est obligatoire <br>");
		}
		// R�cup�ration de la description
		description=request.getParameter("sdescription");
		if(description==null || description.trim().isEmpty()) {
			message.append("La description du produit est obligatoire <br>");
		}
		// R�cup�ration de l'id cat�gorie
		idcategorie=Integer.parseInt(request.getParameter("scategorie"));
		// R�cup�ration du prix
		try {
			miseAPrix=Integer.parseInt(request.getParameter("sprix"));
		} catch (NumberFormatException e) {
			message.append("Veuillez saisir un chiffre");
		}
		// R�cup�ration des dates
		dateDebut=LocalDate.parse(request.getParameter("sdateDebut"));
		dateFin=LocalDate.parse(request.getParameter("sdateFin"));
		// R�cup�re la cat�gorie
		try {
			categorie=cat.getCategorieParId(idcategorie);
		} catch (BLLException e) {
			message.append("Pb r�cup�ration cat�gorie"+e.getMessage());
		}
		a=a.getInstance();
		article=new ArticleVendu(nomProduit, description, dateDebut, dateFin, miseAPrix, categorie);
		try {
			a.nouvelleVente(article, u, categorie, null);
		} catch (BLLException e) {
			message.append("Pb cr�ation Article Vendu"+e.getMessage());
		}
	System.out.println(message.toString());
	}

}
