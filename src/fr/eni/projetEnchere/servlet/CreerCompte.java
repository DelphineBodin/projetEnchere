package fr.eni.projetEnchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			
		StringBuilder messageError = new StringBuilder();
		
// =========>>>> met on le crédit ici à 100 ?
		// Appel du manager (lien servlet <> BLL);
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		Utilisateur u = null;
		boolean test;
		try {
			test = annuaire.validerInscription(u);
		} catch (BLLException e1) {
			test = false;
			messageError.append(e1.getMessage());
		}
		System.out.println(test);
		boolean error;
		
		// Initialisation des attributs session
		HttpSession maSession = null;
		RequestDispatcher dispatcher = null;
		
		if(test == true) {
			if(!password.equals(passwordConfirm)) {
				error = true;
				messageError.append("Les mots de passes ne sont pas identiques");
				System.out.println("Les mots de passes ne sont pas identiques");
			} else {
				error = false;
				System.out.println("Inscription réussi");
				//Création de l'utilisateur
				u = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,password,100);

				// Création d'une session
				maSession = request.getSession();
				maSession.setAttribute("utilisateurConnecte", u);
				// Redirection vers la page...
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mesachats.jsp");
				try {
					System.out.println(annuaire.validerInscription(u));
					//Nouvelle inscription validé
					annuaire.nouvelleInscription(u);
				} catch (BLLException e) {
					messageError.append(e.getMessage());
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("page erreur");
			request.setAttribute("messageErreur", messageError.toString());
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp");
		}
		dispatcher.forward(request, response);	
		request.setAttribute("erreurEMessage", messageError.toString());
	}
}
