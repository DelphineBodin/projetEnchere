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
		StringBuilder message = new StringBuilder();
		AnnuaireUtilisateurManager dao = AnnuaireUtilisateurManager.getInstance();
		Utilisateur u = null;
		boolean res = false;
		//on s'assure que tomcat decodera les informations reçues avc le coade utf-8
		request.setCharacterEncoding("UTF-8");
		//recuperation ds parametre identifiant et vérification que le champs est rempli
		String identifiant = request.getParameter("sidentifiant");
		String motDePasse = request.getParameter("smotdepasse");
		// Test si le champs pseudo n'est pas vide
		if(identifiant==null||identifiant.trim().isEmpty()) {
			message.append("Aucun Pseudo n'a été saisi");
			res=false;
		}else if (motDePasse==null||motDePasse.trim().isEmpty()) {
				message.append("Aucun Mot de passe n'a été saisi");
				res=false;
		// si champs mot de passe et pseudo ne sont pas vide
			}else {
				try {
					// je récupére l'utilisateur à partir du pseudo/identifiant
					u=dao.getUtilisateur(identifiant);
					// je vérifie que je récupère un utilisateur
					if(u==null) {
						res=false;
						message.append("Le pseudo saisi n'existe pas \n");
					// je vérifie que le mot de passe de l'utilisateur recupéré correspond à celui saisi	
					}else 
						if(u.getMotDePasse().equals(motDePasse)){
							res=true;
						}else {
							res=false;
							message.append("Le mot de passe est erroné \n");
						}// Fin des test
				} catch (BLLException e) {
						message.append("Problème interne Serveur :"+e.getMessage());
						res=false;
				}//Fin du catch
			}
		HttpSession maSession=null;
		RequestDispatcher dispatcher = null;
		if(res==true) {
			maSession = request.getSession();
			maSession.setAttribute("utilisateurConnecte", u);	
			dispatcher = request.getRequestDispatcher("./MesVentes");
		}else {
			System.out.println("page erreur");
			request.setAttribute("messageErreur", message.toString());
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		}
		dispatcher.forward(request, response);	
		
	}
	}

	


