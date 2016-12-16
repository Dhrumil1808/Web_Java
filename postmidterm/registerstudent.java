package cs1220.postmidterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerstudent
 */
@WebServlet(name = "registers", urlPatterns = { "/registers" })
public class registerstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context=this.getServletContext();
		if(context.getAttribute("registeruser")==null)
		{
			ArrayList<registeruser> regentries=new ArrayList<registeruser>();
			regentries.add(new registeruser("John","Doe",30));
			regentries.add(new registeruser("Adam","Adam",50));
			regentries.add(new registeruser("Jade","Doe",40));
			regentries.add(new registeruser("Jack","Roy",60));
			context.setAttribute("registeruser", regentries);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Register");
		out.println("</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='registerstudent'>");
		out.println("Username");
		out.println("<input type='text' name='username' id='username'> <br>");
		out.println("Password");
		out.println("<input type='password' name='password' id='password'><br>");
		out.println("<input type='submit' name='submit' value='submit'>");
		out.println("</form>");
		out.println("</body>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
		 @SuppressWarnings("unchecked")
		ArrayList<registeruser> users=(ArrayList<registeruser>) this.getServletContext().getAttribute("registeruser");
		
		for(registeruser r : users)
		{
			out.println(r.getFirstname());
			out.println("  ");
			out.println(r.getLastname());
			out.println(" ");
			out.println(r.getGrade());
		}
		
		//doGet(request, response);
	}

}
