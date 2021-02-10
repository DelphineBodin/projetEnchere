package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemarrage
 * 
 * pas de web xml cree donc j'ai realise un parametrage par annotation pour lier la sevletdemarrage a la jsp index.jsp
 */

@WebServlet(name ="ServletDemarrage",
value = {"/ListesDesEncheres"})


public class ServletDemarrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletDemarrage() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
