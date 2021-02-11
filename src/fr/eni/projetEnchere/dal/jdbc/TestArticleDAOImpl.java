package fr.eni.projetEnchere.dal.jdbc;

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
import fr.eni.projetEnchere.dal.DALException;


/**
 * Servlet implementation class TestArticleDAOImpl
 */
@WebServlet("/TestArticleDAOImpl")
public class TestArticleDAOImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u1=new Utilisateur(2,"tSalmon","Salmon","Titouan","titouan@gmail.com","0685445454","4 rue eglise","13100","Les Milles","coucou2",15,false);
		Categorie cat1=new Categorie(1,"INFORMATIQUE");
//		ArticleVendu a1=new ArticleVendu("Ordinateur Portable","Philips",LocalDate.of(2021,02, 25),LocalDate.of(2021,02, 28),100,cat1);//utilisateur ?
		ArticleDAOImpl a = new ArticleDAOImpl();

// Test 1 Cr�ation d'une vente sans classe Retrait		
//		try {
//			a.nouvelleVente(a1, u1,cat1,null);
//			System.out.println("J'ai cr�er un article sans retrait");
//		} catch (DALException e) {
//			System.out.println(e.getMessage());
//		}
		
		// Test 2 Cr�ation d'une vente avec classe Retrait			
//		Retrait retrait1 = new Retrait(1,"rue des Peupliers","13000","Aix en Provence");
//		ArticleVendu a2=new ArticleVendu("Imprimante","LaserJet Pro",LocalDate.of(2021,02, 26),LocalDate.of(2021,03, 29),120,cat1);
//		try {
//			a.nouvelleVente(a2, u1,cat1,retrait1);
//			System.out.println("J'ai cr�er un article avec retrait");
//		} catch (DALException e) {
//			System.out.println(e.getMessage());
//		}		
		// Test 3 Cr�ation d'une vente avec classe Retrait � null
		ArticleVendu a3=new ArticleVendu("Clavier","Noir",LocalDate.of(2021,02, 24),LocalDate.of(2021,02, 27),10,cat1);
	
		try {
			a.nouvelleVente(a3, u1,cat1,null);
			System.out.println("J'ai cr�er un article sans retrait");
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	
	
	
	
	}

}