package cs1220.lab5;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admin_shopping
 */
@WebServlet("/cs1220/lab5/admin_shopping")
public class admin_shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_shopping() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException
    {
    	ServletContext context=this.getServletContext();
		if(context.getAttribute("admins")==null)
		{
			ArrayList<admin> admin=new ArrayList<admin>();
			admin.add(new admin(0,"Pizza",20,2,"http://www.cicis.com/media/1138/pizza_trad_pepperoni.png"));
			admin.add(new admin(1,"Chocolates",30,4,"https://upload.wikimedia.org/wikipedia/commons/9/9f/Chocolate(bgFFF).jpg"));
			admin.add(new admin(2,"Chocolate cake",35,4,"https://d3awvtnmmsvyot.cloudfront.net/api/file/Jqoi44f2S6aGO6RXDja1/convert?fit=max&w=1450&quality=60&cache=true&rotate=exif&compress=true"));
			admin.add(new admin(3,"Burger",32,12,"http://www.tastyburger.com/wp-content/themes/tastyBurger/images/home/img-large-burger.jpg"));
			admin.add(new admin(4,"Sandwich",21,23,"http://thesandwichguide.com/wp-content/uploads/sandwich.jpg"));
			context.setAttribute("admins", admin);			
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<admin> items=(ArrayList<admin>) getServletContext().getAttribute("admins");
		HttpSession sess=request.getSession();
		sess.setAttribute("trial",items);
		
		ArrayList<Login> user=(ArrayList<Login>) getServletContext().getAttribute("page");
		HttpSession session=request.getSession();
		session.setAttribute("use",user);
		
		response.sendRedirect("admin_shopping.jsp");
		//doGet(request, response);
	}

}
