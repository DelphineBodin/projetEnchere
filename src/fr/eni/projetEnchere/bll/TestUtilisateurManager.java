package fr.eni.projetEnchere.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class TestUtilisateurManager
 */
@WebServlet("/TestUtilisateurManager")
public class TestUtilisateurManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		Utilisateur u1 = new Utilisateur("Batman","ROBIN","Brice","deux@laposte.net","0610203040","4 rue du soleil", "44000","Nantes","lataupe",0);
		try {
			System.out.println(annuaire.validerInscription(u1));
			annuaire.nouvelleInscription(u1);
		} catch (BLLException e) {
			System.out.println(e.getMessage());
		}
	}
}