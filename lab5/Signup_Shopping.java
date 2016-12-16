package cs1220.lab5;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup_Shopping
 */
@WebServlet("/cs1220/lab5/Signup_Shopping")
public class Signup_Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      @SuppressWarnings("unchecked")
		ArrayList<Login> users=(ArrayList<Login>) this.getServletContext().getAttribute("page");
			
			//PrintWriter out =response.getWriter();
			boolean valid=true;
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String email=request.getParameter("email");
			String uname=request.getParameter("username");
			String password=request.getParameter("password");
			String pnum=request.getParameter("pnumber");
			
			//out.print(users.get(0).getFname());
			String message="";
			if(fname.trim().length()==0)
			{
				message+="Enter the first name" +"\n";
				valid=false;
			}
			if(!(fname.matches("[a-zA-Z]+")))
			{
				message+="First Name should contain characters only" +"\n";
				valid=false;
			}
			if(lname.trim().length()==0)
			{
				message+="Enter the last name" +"\n";
				valid=false;
			}
			if(!(lname.matches("[a-zA-Z]+")))
			{
				message+="Last Name should contain characters only" +"\n";
				valid=false;
			}
			if(email.trim().length()==0)
			{
				message+="Enter the email id";
				valid=false;
			}
			if(!(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")))
			{
				message+="Invalid email id";
				valid=false;
			}
			if(password.trim().length()==0)
			{
				message+="password is empty";
				valid=false;
			} 
			
			if(!(password.matches("[A-Za-z]+[0-9]+[#?!@$%^&*-]+") || password.matches("[A-Za-z]+[#?!@$%^&*-]+[0-9]+") || password.matches("[0-9]+[#?!@$%^&*-]+[A-Za-z]+") || password.matches("[0-9]+[A-Za-z]+[#?!@$%^&*-]+") || password.matches("[#?!@$%^&*-]+[A-Za-z]+[0-9]+") || password.matches("[#?!@$%^&*-]+[0-9]+[A-Za-z]")))
			{
				message+="Password should contain at least one aphabet,one digit and one special character";
				valid=false;
			}
			
		   if(uname.trim().length()==0)
		   {
			   message+="Username is empty";
				valid=false;
		   }
		   
		   if(users.size()>0)
		   {
		   for(int i=0;i<users.size();i++)
		   {
			   if(users.get(i).getUsername().equalsIgnoreCase(uname))
			   {
				   message+="Username is already taken";
				   valid=false;
			   }
		   }
		   }
			if(pnum.trim().length()!=10 || (!pnum.matches("[0-9]*")))
			{
				message+="Phone number should be of 10 digits only";
				valid=false;
			}
			if(valid)
			{
				users.add(new Login(fname,lname,email,uname,password,Long.parseLong(pnum)));
				response.sendRedirect("signin_shopping.jsp");	
			}
			else
			{
				response.sendRedirect("Signup_Shopping.jsp?msg=" + URLEncoder.encode(message,"UTF-8"));
			}


		//doGet(request, response);
	}

}
