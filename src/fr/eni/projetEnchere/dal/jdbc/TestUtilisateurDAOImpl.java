package fr.eni.projetEnchere.dal.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.UtilisateurDAO;

@WebServlet("/TestUtilisateurJdbcImpl")
public class TestUtilisateurDAOImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Utilisateur u1 = new Utilisateur("Renelataupe","Ren�","Brice","deux@laposte.net","0610203040","4 rue du soleil", "44000","Nantes","lataupe",0);
//		UtilisateurDAO u = new UtilisateurDAOImpl();
//		
////		try {
////			u.addUtilisateur(u1);
////			System.out.println("J'ai cr�er un article sans retrait");
////			} catch (DALException e) {
////			System.out.println(e.getMessage());
////			}
////	}
////
////	
//	
//	//Appel a la methode dans le doget?
//	
//	UtilisateurDAOImpl utilisateurdaoimpl = new UtilisateurDAOImpl();
//	try {
//		Utilisateur u2= utilisateurdaoimpl.selectByPseudo("tSalmon");
//		System.out.println(u2);
//	} catch (DALException e) {
//		System.out.println(e.getMessage());
//	}
//}
//	
	
	// =================> A TOI BRICE <============================
	// Test selectByPseudo
	// =================> A TOI BRICE <============================
	String email="rose@orange.com";
	UtilisateurDAOImpl utilisateurdaoimpl = new UtilisateurDAOImpl();
	try {
		System.out.println(utilisateurdaoimpl.emailAlreadyExist(email));
		System.out.println("emailexist");
	} catch (DALException e) {
		System.out.println("emailexist pas");
	}

}
}
