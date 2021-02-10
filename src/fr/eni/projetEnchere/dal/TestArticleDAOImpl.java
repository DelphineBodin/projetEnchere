package fr.eni.projetEnchere.dal;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class TestArticleDAOImpl
 */
@WebServlet("/TestArticleDAOImpl")
public class TestArticleDAOImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u1=new Utilisateur();
		Categorie cat1=new Categorie("vaillesse");
		ArticleVendu a1=new ArticleVendu("tasse", "tasse rose", LocalDate.now(), LocalDate.now(), 15,  null, cat1);
		ArticleDAOImpl a = new ArticleDAOImpl();
		try {
			a.ajouterArticle(a1, u1,cat1);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
				
	}

}
