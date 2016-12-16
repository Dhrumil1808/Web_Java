package cs1220.homework3;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HomePage_Shopping
 */
@WebServlet("/cs1220/homework3/HomePage_cinema")
public class HomePage_cinema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage_cinema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context=this.getServletContext();
		if(context.getAttribute("page")==null)
		{
			ArrayList<Login> register=new ArrayList<Login>();
			register.add(new Login("john","Doe","john@admin.com","admin","admin",Long.parseLong("1234567890")));
			context.setAttribute("page", register);
			
		}
			}

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/cs1220stu13/cs1220/homework3/HomePage_cinema.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
