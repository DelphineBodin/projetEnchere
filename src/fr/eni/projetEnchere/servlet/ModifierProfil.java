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


@WebServlet(name ="ModifierProfil",
value = {"/ModifierProfil"})


public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierprofil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		// password et new passwoord à revoir dans la BLL
		String password = request.getParameter("password");
		String passwordNew = request.getParameter("passwordNew");
		String passwordNewConfirm = request.getParameter("passwordNewConfirm");
		boolean test = true;
		
		// Appel du manager (lien servlet <> BLL);
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		// Initialisation des attributs session
		HttpSession maSession = request.getSession();
		RequestDispatcher dispatcher = null;
		
		Utilisateur u = (Utilisateur) maSession.getAttribute("utilisateurConnecte");
		int noUtilisateur = u.getNoUtilisateur();
		
		Utilisateur uModifier = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, passwordNew); 
		try {
			annuaire.updateUtilisateur(uModifier);
			System.out.println("Modification de l'utilisateur enregistrer");
			dispatcher = request.getRequestDispatcher("./MesVentes");
		} catch (BLLException e) {
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

}
