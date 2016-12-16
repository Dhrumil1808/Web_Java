package cs1220.lec2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("CS1220Lecture2");
		out.println("</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='register' method='post'>");
		out.println("First Name");
		out.println("<input type='text' id='fname' name='fname'><br>");
		out.println("Last Name");
		out.println("<input type='text' id='lname' name='lname'><br>");
		out.println("Mobile");
		out.println("<input type='text' id='mobile' name='mobile'><br>");
		out.println("Email");
		out.println("<input type='text' id='email' name='email'><br>");
		out.println("Birth date");
		out.println("<input type='date' name='birthdate' id='birthdate'><br>");
		out.println("Address");
		out.println("<textarea name='address' id='address'>");
		out.println("</textarea><br>");
		out.println("<input type='submit' value='submit'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String birthdate=request.getParameter("birthdate");
		String address=request.getParameter("address");
		int i=0;
		//PrintWriter out=response.getWriter();
		if(fname.trim().length()==0)
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('First name should not be blank');");  
			out.println("</script>");
			i++;
		}
		if(lname.trim().length()==0)
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Last name should not be blank');");  
			out.println("</script>");
			i++;
		}
		if(mobile.trim().length()==0)
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Mobile Number should not be blank');");  
			out.println("</script>");
			i++;
		}
		if(email.trim().length()==0)
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Email should not be blank');");  
			out.println("</script>");
			i++;
		}
		if(birthdate.trim().length()==0)
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Birth date should not be blank');");  
			out.println("</script>");
			i++;
		}
		if(address.trim().length()==0)
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Address name should not be blank');");  
			out.println("</script>");
			i++;
		}
		if(i>0)
		{
			//doGet(request, response);	
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
		//doGet(request, response);
	}

}
