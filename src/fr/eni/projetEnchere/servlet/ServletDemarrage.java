package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bo.Categorie;

/**
 * Servlet implementation class ServletDemarrage
 * 
 * pas de web xml cree donc j'ai realise un parametrage par annotation pour lier la sevletdemarrage a la jsp index.jsp
 */

@WebServlet(name ="ServletDemarrage",
value = {"/ListesDesEncheres"})


public class ServletDemarrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Categorie> categories;
	CategorieManager cat ;  
  	
	@Override
	public void init() throws ServletException {
		super.init();
		CategorieManager cat = CategorieManager.getInstance();
		StringBuilder messageerreur = new StringBuilder();
		try {
			this.categories=cat.getCategories();
		} catch (BLLException e) {
			System.out.println(messageerreur.append("Je n'arrive pas à récupérer les Categories"));;
			
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeCategorie", categories);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
