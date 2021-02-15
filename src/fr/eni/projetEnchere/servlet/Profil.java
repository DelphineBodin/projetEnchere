package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name ="Profil",
value = {"/Profil"})

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
		String telephone = request.getParameter("pseudo");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		

		//Stockage du résultat et des messages d'erreur dans l'objet request
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		
		// Transmission de la paire d'objets request/response à notre JSP ????????????????????
		//this.getServletContext().getRequestDispatcher("/WEB-INF/..........OU???????).forward(request, response);
	}



}
