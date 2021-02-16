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

public class CreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des champs de formulaire
//		String pseudo = "";
//		String nom = "";
//		String prenom = "";
//		String email = "";
//		String telephone = "";
//		String rue = "";
//		String codePostal = "";
//		String ville = "";
//		String password = "";
//		String passwordConfirm = "";
		
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
		// Initialisation des attributs session
		HttpSession maSession = null;
		RequestDispatcher dispatcher = null;
		//Création de l'utilisateur
		Utilisateur u = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,password,100);
		
		//Test de la validité des champs de saisie:
	//		boolean testInscription = false;
	//		try {
	//			testInscription = annuaire.validerInscription(u);
	//			System.out.println(testInscription);
	//		} catch (BLLException e1) {
	//			testInscription = false;
	//			messageError.append(e1.getMessage());
	//		}
	//		System.out.println(testInscription);	
		
		boolean testInscription = false;
		boolean testPassword = false;
		//Test de la validité des champs de saisie:
		try {
			testInscription = annuaire.validerInscription(u);
			System.out.println(testInscription);
			//Test de la confirmation du mot de passe
			if(password.equals(passwordConfirm)) {
				testPassword = true;
				System.out.println("Confirmation mot de passe identique");
			} else {
				testPassword = false;
				messageError.append("Les mots de passes ne sont pas identiques");
				System.out.println("Les mots de passes ne sont pas identiques");
				if(testPassword == false) {
					request.setAttribute("messageErreur", messageError.toString());
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp");
				}
			}
			
			//Création de l'inscription
			try {
				annuaire.nouvelleInscription(u);
				// Création d'une session
				maSession = request.getSession();
				maSession.setAttribute("utilisateurConnecte", new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,password,100));
				// Redirection vers la page...
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mesachats.jsp");
			} catch (BLLException e1) {
				messageError.append(e1.getMessage());
			}
		} catch (BLLException e1) {
			testInscription = false;
			testPassword = false;
			messageError.append(e1.getMessage());
		}
		dispatcher.forward(request, response);	
	}
}