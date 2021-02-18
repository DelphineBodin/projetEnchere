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
	Utilisateur u;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierprofil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Appel du manager (lien servlet <> BLL);
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		
		//Récupération des infos de l'utilsateur par defaut :
		String pseudoDefaut = u.getPseudo();
		String nomDefaut = u.getNom();
		String prenomDefaut = u.getPrenom();
		String emailDefaut = u.getEmail();
		String telephoneDefaut = u.getTelephone();
		String rueDefaut = u.getRue();
		String codePostalDefaut = u.getCodePostal();
		String villeDefaut = u.getVille();

		// Récupération des infos saisies lors de la mise à jour du formulaire
		String pseudoFormulaire = request.getParameter("pseudo");
		String nomFormulaire = request.getParameter("nom");
		String prenomFormulaire = request.getParameter("prenom");
		String emailFormulaire = request.getParameter("email");
		String telephoneFormulaire = request.getParameter("tel");
		String rueFormulaire = request.getParameter("rue");
		String codePostalFormulaire = request.getParameter("codePostal");
		String villeFormulaire = request.getParameter("ville");
		// password et new passwoord à revoir dans la BLL
		String password = request.getParameter("password");
		String passwordNew = request.getParameter("passwordNew");
		String passwordNewConfirm = request.getParameter("passwordNewConfirm");
		boolean test = true;
		
		// test dans formulaire si champ vide = valeur de la BDD
		if(pseudoFormulaire.trim().isEmpty()) {
			pseudoFormulaire=pseudoDefaut;
		}
		if(nomFormulaire.trim().isEmpty()) {
			nomFormulaire=nomDefaut;
		}
		if(prenomFormulaire.trim().isEmpty()) {
			prenomFormulaire=prenomDefaut;
		}
		if(emailFormulaire.trim().isEmpty()) {
			emailFormulaire=emailDefaut;
		}
		if(telephoneFormulaire.trim().isEmpty()) {
			telephoneFormulaire=telephoneDefaut;
		}
		if(rueFormulaire.trim().isEmpty()) {
			rueFormulaire=rueDefaut;
		}
		if(codePostalFormulaire.trim().isEmpty()) {
			codePostalFormulaire=codePostalDefaut;
		}
		if(villeFormulaire.trim().isEmpty()) {
			villeFormulaire=villeDefaut;
		}
		
		// Initialisation des attributs session
		HttpSession maSession = request.getSession();
		RequestDispatcher dispatcher = null;
		
		Utilisateur u = (Utilisateur) maSession.getAttribute("utilisateurConnecte");
		int noUtilisateur = u.getNoUtilisateur();
		
		Utilisateur uModifier = new Utilisateur(noUtilisateur, pseudoFormulaire, nomFormulaire, prenomFormulaire, emailFormulaire, telephoneFormulaire, rueFormulaire, codePostalFormulaire, villeFormulaire, passwordNew); 
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
