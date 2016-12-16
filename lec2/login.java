package cs1220.lec2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String birthdate=request.getParameter("birthdate");
		String address=request.getParameter("address");
		
		PrintWriter out=response.getWriter();
		int i=0;
		if(fname.trim().length()==0)
		{
			out.println("First name should not be blank");  
			response.sendRedirect("/cs1220stu13/register");
			i++;
		}
		if(lname.trim().length()==0)
		{
			out.println("Last name should not be blank");  
			i++;
		}
		if(mobile.trim().length()==0)
		{
			out.println("Mobile Number should not be blank");  
			i++;
		}
		if(email.trim().length()==0)
		{
			out.println("eamil should not be blank");  
			i++;
			}
		 if(birthdate.trim().length()==0)
		{
			out.println("birthdate should not be blank");  
			i++;
		}
		if(address.trim().length()==0)
		{
			out.println("address should not be blank");  
		    i++;
		}
		if(i>0)
		{
			//out.println("address should not be blank");  
		}
		else
		{
		out.println("<b> First Name: </b> " + fname +"<br>");
		out.println("<b> Last Name: </b> " +lname +"<br>");
		out.println("<b> Mobile: </b> " +mobile +"<br>");
		out.println("<b> Email: </b> " +email +"<br>");
		out.println("<b> Birthdate: </b> " +birthdate +"<br>");
		out.println("<b> Address: </b> " +address +"<br>");
		}

		doGet(request, response);
	}

}
