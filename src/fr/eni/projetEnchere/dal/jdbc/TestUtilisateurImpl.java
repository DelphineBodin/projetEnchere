package fr.eni.projetEnchere.dal.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurDAO;

@WebServlet("/TestUtilisateurJdbcImpl")
public class TestUtilisateurImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Utilisateur u1 = new Utilisateur(6,"Renelataupe","René","Dupont","renetaupe@laposte.net","0610203040","4 rue du soleil", "44000","Nantes","lataupe","0","0");
		UtilisateurDAO u = new UtilisateurDAOImpl();
	}


}
