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
	CategorieManager cat = CategorieManager.getInstance();


	@Override
	public void init() throws ServletException {
		super.init();
		CategorieManager cat = CategorieManager.getInstance();
		StringBuilder messageerreur = new StringBuilder();
		try {
			categories=cat.getCategories();
		} catch (BLLException e) {
			messageerreur.append("Je n'arrive pas à récupérer les Categorie");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listeCategorie", categories);
		request.getRequestDispatcher("/WEB-INF/jsp/pagevendrearticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// je m'assure que TomCat decodera en UTF8
		request.setCharacterEncoding("UTF-8");
		String nomProduit,description;
		int categorie;
		int miseAPrix=0;
		//LocalDate dateDebut=null;
		//LocalDate dateFin=null;
		//DateTimeFormatter dtf =null;
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
		// Récupération de la catégorie
		categorie=Integer.parseInt(request.getParameter("scategorie"));
		// Faire teste si elle existe dans la base
		// la créer en java
		// Récupération du prix
		try {
			miseAPrix=Integer.parseInt(request.getParameter("sprix"));
		} catch (NumberFormatException e) {
			message.append("Veuillez saisir un chiffre");
		}
		
		// Récupération des dates
		//dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//dateDebut=LocalDate.parse(request.getParameter("sdateDebut"));
		//System.out.println(dateDebut);
		System.out.println(nomProduit+" description "+description+" catégorie "+categorie+" prix "+miseAPrix);
		System.out.println(message.toString());
	}

}
