

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

import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bo.Categorie;


@WebServlet(name ="PageVendreArticle",
value = {"/VendreArticle"})


public class PageVendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Categorie> categories;
	CategorieManager cat ;
DateTimeFormatter df;

	@Override
	public void init() throws ServletException {
		super.init();
		CategorieManager cat = CategorieManager.getInstance();
		StringBuilder messageerreur = new StringBuilder();
		try {
			categories=cat.getCategories();
		} catch (BLLException e) {
			messageerreur.append("Je n'arrive pas à récupérer les Categories");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listeCategorie", categories);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pagevendrearticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// je m'assure que TomCat decodera en UTF8
		request.setCharacterEncoding("UTF-8");
		String nomProduit,description;
		LocalDate dateDebut=null;
		LocalDate dateFin=null;
		int idcategorie;
		int miseAPrix=0;
		StringBuilder message = new StringBuilder();
		// Récupération de l'article
		nomProduit=request.getParameter("sarticle");
		if(nomProduit==null || nomProduit.trim().isEmpty()) {
			message.append("Le nom du produit est obligatoire <br>");
		}
		// Récupération de la description
		description=request.getParameter("sdescription");
		if(description==null || description.trim().isEmpty()) {
			message.append("La description du produit est obligatoire <br>");
		}
		// Récupération de l'id catégorie
		idcategorie=Integer.parseInt(request.getParameter("scategorie"));
		// Récupération du prix
		try {
			miseAPrix=Integer.parseInt(request.getParameter("sprix"));
		} catch (NumberFormatException e) {
			message.append("Veuillez saisir un chiffre");
		}
		// Récupération des dates
		dateDebut=LocalDate.parse(request.getParameter("sdateDebut"));
		dateFin=LocalDate.parse(request.getParameter("sdateFin"));
		//System.out.println(dateDebut);
		System.out.println(nomProduit+" description "+description+" catégorie "+idcategorie+" prix "+miseAPrix+" dateDebut "+dateDebut+" datefin "+dateFin);
		System.out.println(message.toString());
	}

}
