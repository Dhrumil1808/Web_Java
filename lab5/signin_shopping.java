package cs1220.lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import cs1220.lab3.quote;

/**
 * Servlet implementation class signin_shopping
 */
@WebServlet("/cs1220/lab5/signin_shopping")
public class signin_shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin_shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String value=request.getParameter("remember");
		ArrayList<Login> users=(ArrayList<Login>) this.getServletContext().getAttribute("page");
		int k=0;
		for(int i=0;i<users.size();i++)
		{
			//out.println(users.get(i).getUsername());
			if(users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).getPassword().equals(password))
			{
				k++;
				if(value!= null)
				{
					HttpSession sess=request.getSession();
					sess.setAttribute("name",users.get(i).getUsername());
					sess.setAttribute("value", value);			
				}
				if(users.get(i).getUsername().equals("admin"))
				{
				
					HttpSession sess=request.getSession();
					sess.setAttribute("trial",users.get(i).getFirstname());
					response.sendRedirect("admin_shopping");
					break;
				}
				else
				{
					
				//k++;
				HttpSession sess=request.getSession();
				sess.setAttribute("trial",users.get(i).getFirstname());
				response.sendRedirect("welcome_shopping.jsp");
				break;
			}
			}
			
		}
		
		if(k==0){
			response.sendRedirect("signin_shopping.jsp?message="+ URLEncoder.encode("invalid login credentials","UTF-8"));
		}
		
		//doGet(request, response);
	
	}

}
