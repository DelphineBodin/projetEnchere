

package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import fr.eni.projetEnchere.bll.AnnuaireArticleManager;
import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bll.RetraitManager;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;


@WebServlet(name ="PageVendreArticle",
value = {"/VendreArticle"})


public class PageVendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Categorie> categories;
	CategorieManager cat ;
	DateTimeFormatter df;
	Utilisateur u;
	AnnuaireArticleManager a;

	@Override
	public void init() throws ServletException {
		super.init();
		cat = CategorieManager.getInstance();
		StringBuilder messageerreur = new StringBuilder();
		try {
			categories=cat.getCategories();
		} catch (BLLException e) {
			messageerreur.append("Je n'arrive pas � r�cup�rer les Categories");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		u=(Utilisateur) session.getAttribute("utilisateurConnecte");
		request.setAttribute("listeCategorie", categories);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pagevendrearticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// je m'assure que TomCat decodera en UTF8
		request.setCharacterEncoding("UTF-8");
		Categorie categorie=null;
		ArticleVendu article=null;
		LocalDate dateDebut=null;
		LocalDate dateFin=null;
		LocalTime heureDebut =null;
		LocalTime heureFin=null;
		int idcategorie;
		int miseAPrix=0;
		StringBuilder message = new StringBuilder("L'enregistrement de cette vente � �chou� : \n");
		RetraitManager retraitManager= RetraitManager.getInstance();
		boolean ok = true;
		// R�cup�raton article et description
		String nomProduit=request.getParameter("sarticle");
		String description=request.getParameter("sdescription");
		// R�cup�ration de l'id cat�gorie
		idcategorie=Integer.parseInt(request.getParameter("scategorie"));
		// R�cup�ration du prix
		try {
			miseAPrix=Integer.parseInt(request.getParameter("sprix"));
		} catch (NumberFormatException e) {
			message.append("Un chiffre doit �tre saisi dans Mise � Prix. \n");
			ok=false;
		}
		// R�cup�ration des dates
		if(!request.getParameter("sdateDebut").trim().isEmpty()) {
			dateDebut=LocalDate.parse(request.getParameter("sdateDebut"));
		}else {
			ok=false;
			message.append("Une date de d�but d'ench�re doit �tre saisie. \n");
		}
		if(!request.getParameter("sdateFin").trim().isEmpty()) {
			dateFin=LocalDate.parse(request.getParameter("sdateFin"));
		}else {
			ok=false;
			message.append("Une date de fin d'ench�re doit �tre saisie. \n");
		}
		if(!request.getParameter("sheureFin").trim().isEmpty()) {
			heureDebut=LocalTime.parse(request.getParameter("sheureDebut"));
		}else {
			ok=false;
			message.append("Une heure de d�but d'ench�re doit �tre saisie. \n");
		}
		if(!request.getParameter("sheureFin").trim().isEmpty()) {
			heureFin=LocalTime.parse(request.getParameter("sheureFin"));
		}else {
			ok=false;
			message.append("Une heure de fin d'ench�re doit �tre saisie. \n");
		}
		// R�cup�re la cat�gorie
		try {
			categorie=cat.getCategorieParId(idcategorie);
		} catch (BLLException e) {
			ok=false;
			message.append("Pb r�cup�ration cat�gorie"+e.getMessage());
		}
		// Gestion du lieu de Retrait
		Retrait r = null;
		// R�cup�ration du lieu de retrait par d�faut
		String rueDefaut = u.getRue();
		String codeDefaut = u.getCodePostal();
		String villeDefaut = u.getVille();
		// R�cup�ration des infos saisies dans le formulaire
		String rueFormulaire=request.getParameter("srue");
		String codeFormulaire=request.getParameter("scodePostal");
		String villeFormulaire=request.getParameter("sville");
		// Est ce que je cr�e un lieu de retrait
		if(!rueFormulaire.trim().isEmpty()&
				!codeFormulaire.trim().isEmpty()&
				!villeFormulaire.trim().isEmpty()) {
			// je cr�e un lieu de retrait
			if(rueFormulaire.trim().isEmpty()) {
				rueFormulaire=rueDefaut;
			}
			if(codeFormulaire.trim().isEmpty()) {
				codeFormulaire=codeDefaut;
			}
			if(villeFormulaire.trim().isEmpty()) {
				villeFormulaire=villeDefaut;
			}
			r=new Retrait(rueFormulaire,villeFormulaire,codeFormulaire);
			try {
				retraitManager.ajouterRetrait(r);
			} catch (BLLException e) {
				message.append(e.getMessage());
				ok=false;
			}
		}
		// je ne cr�e pas de lieu de retrait r restera � null
		if(ok==true) {
		a=AnnuaireArticleManager.getInstance();
		article=new ArticleVendu(nomProduit, description, dateDebut,heureDebut, dateFin,heureFin, miseAPrix, categorie);
		try {
			a.nouvelleVente(article, u, categorie, r);
		} catch (BLLException e) {
			message.append("Pb cr�ation Article Vendu"+e.getMessage());
			ok=false;
		}
		}
		RequestDispatcher disp=null;
		if(ok==true) {
			disp = request.getRequestDispatcher("./MesVentes");
		}else {
			request.setAttribute("messageErreur", message.toString());
			disp = request.getRequestDispatcher("/WEB-INF/jsp/pagevendrearticle.jsp");
		}
		disp.forward(request, response);	
		
	
	}

}
