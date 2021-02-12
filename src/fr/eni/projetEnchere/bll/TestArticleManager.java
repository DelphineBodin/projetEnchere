package fr.eni.projetEnchere.bll;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;


/**
 * Servlet implementation class TestAnnuaireArticleManager
 */
@WebServlet("/TestAnnuaireArticleManager")
public class TestArticleManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AnnuaireArticleManager annuaire=AnnuaireArticleManager.getInstance();
	Utilisateur u1=new Utilisateur(2,"tSalmon","Salmon","Titouan","titouan@gmail.com","0685445454","4 rue eglise","13100","Les Milles","coucou2",15,false);
	Categorie cat1=new Categorie(1,"INFORMATIQUE");
	ArticleVendu a1=new ArticleVendu("Ordinateur","Philips",LocalDate.of(2021,2, 25),LocalDate.of(2021,2, 26),14000,cat1);
	Retrait retrait1 = new Retrait(1,"rue des Peupliers","13000","Aix en Provence");
	try {
		System.out.println(annuaire.validerVente(a1,u1, cat1, null));
		annuaire.nouvelleVente(a1, u1, cat1, null);
	} catch (BLLException e) {
		System.out.println((e.getMessage()));
	}
		
		
	}
	
}
