package fr.eni.projetEnchere.bll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class TestUtilisateurManagerV2
 */
@WebServlet("/TestUtilisateurManagerV2")
public class TestUtilisateurManagerV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnuaireUtilisateurManager a = AnnuaireUtilisateurManager.getInstance();
		try {
			Utilisateur utest =a.getUtilisateur("tsalmon");
			System.out.println(utest);
		} catch (BLLException e) {
			System.out.println(e.getMessage());
		}
		
	
		
		
	}

	

}
