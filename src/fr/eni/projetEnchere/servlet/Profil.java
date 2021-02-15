package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.AnnuaireUtilisateurManager;
import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bo.Utilisateur;

@WebServlet("/Profil")

public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des champs de formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
			
		// test mot de passe :
//		boolean error;
//		if(password == passwordConfirm) {
//			error = false;
//			System.out.println("Les mots de passes ne sont pas identiques");
//		} else {
//			error = true;
//			System.out.println("***");
//		}
		
// =========>>>> met on le crédit ici à 100 ?
		// Création d'un constructeur u 
		Utilisateur u = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,password,100);
		// Appel du manager (lien servlet <> BLL);
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		try {
			System.out.println(annuaire.validerInscription(u));
			annuaire.nouvelleInscription(u);
	
		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("erreurMessage", e.getMessage());
		}
	}
}
