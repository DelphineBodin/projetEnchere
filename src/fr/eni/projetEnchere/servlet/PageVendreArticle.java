package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name ="PageVendreArticle",
value = {"/VendreArticle"})


public class PageVendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PageVendreArticle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pagevendrearticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// je m'assure que TomCat decodera en UTF8
		request.setCharacterEncoding("UTF-8");
		String nomProduit,description;
		int categorie;
		
		
		nomProduit=request.getParameter("sarticle");
		description=request.getParameter("sdescription");
		//categorie=request.getParameter("scategorie");
		
		System.out.println(nomProduit+" "+description);
		
	}

}
