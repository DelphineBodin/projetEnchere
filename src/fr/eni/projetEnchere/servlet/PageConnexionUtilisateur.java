package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.AnnuaireUtilisateurManager;
import fr.eni.projetEnchere.bo.Utilisateur;


//@WebServlet(name ="PageConnexionUtilisateur",
//value = {"/ConnexionUtilisateur"})
@WebServlet("/connexion")

public class PageConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageConnexionUtilisateur() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}


	//methode pourra acceder aux parametres des champs remplis par l'utilisateur de la jsp 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//on s'assure que tomcat decodera les informations reçues avc le coade utf-8
		request.setCharacterEncoding("UTF-8");


		//recuperation ds parametre identifiant
		String identifiant="";
		identifiant = request.getParameter("sidentifiant");

		System.out.println(identifiant);

		//syso utilisateur recup de la bdd
		//cree une instance de annuaireUtilisateurManager pour avoir acces a la methode getUtilisateur
		AnnuaireUtiisateurManager dao = new AnnuaireUtilisateurManager();
		
		//je cree une variable pour recuperer ce getUtilisateur
		Utilisateur u = null;
		
		//compare la variable identifiant qui est sidentifiant recupéré du champ de login / au resultat de la methode getutilisateur

		//recuperation ds parametre mot de passe

		String motdepasse="";
		motdepasse = request.getParameter("smotdepasse");

		if(motdepasse.trim().isEmpty() || motdepasse == null) {
			System.out.println("Veuillez rentrer un mot de passe valide");
		}else {
			System.out.println(motdepasse);
		}






	}

}
