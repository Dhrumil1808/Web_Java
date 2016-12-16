package cs1220.homework3;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cs1220.lab5.Login;

/**
 * Servlet implementation class AddMovie_cinema
 */
@WebServlet("/cs1220/homework3/AddMovie_cinema")
public class AddMovie_cinema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie_cinema() {
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
		
		ArrayList<admin> users=(ArrayList<admin>) this.getServletContext().getAttribute("admins");
		String name=request.getParameter("movie_name");
		String image=request.getParameter("movie_image");
		String rating=request.getParameter("rating");
		String silver=request.getParameter("silver");
		String silver_seats=request.getParameter("silver_seats");
		String gold=request.getParameter("gold");
		String gold_seats=request.getParameter("gold_seats");
		String platinum=request.getParameter("platinum");
		String platinum_seats=request.getParameter("platinum_seats");
		boolean valid=true;
		//out.print(users.get(0).getFname());
		String message="";
		if(name.trim().length()==0)
		{
			message+="Enter the name   " ;
			valid=false;
		}
		if(image.trim().length()==0)
		{
			message+="  Enter the image  " +"\n";
			valid=false;
		}
		if(rating.trim().length()==0)
		{
			message+="   Enter the rating  ";
			valid=false;
		}
		if((!rating.matches("[0-9]*.[0-9]*")) || Double.parseDouble(rating) <=10 || Double.parseDouble(rating) >=0)
		{
			message+="  rating should contain numbers between 1 to 10  ";
		}
		
		if(silver.trim().length()==0)
		{
			message+="   Enter the rates for silver seats   ";
			valid=false;
		} 
		if((!silver.matches("[0-9]*.[0-9]*")))
		{
			message+="   rates for silver seats should conatin numeric values only  ";
		}
		if(silver_seats.trim().length()==0)
		{
			message+="    Enter the silver seats available   ";
			valid=false;
		} 
		if((!silver_seats.matches("[0-9]*")))
		{
			message+="   silver seats should conatin numeric values only   ";
		}
		if(gold.trim().length()==0)
		{
			message+="   Enter the rates for gold seats   ";
			valid=false;
		} 
		if((!gold.matches("[0-9]*.[0-9]*")))
		{
			message+="   rates for gold seats should conatin numeric values only   ";
		}
		if(gold_seats.trim().length()==0)
		{
			message+="   Enter the gold seats available    ";
			valid=false;
		} 
		if((!gold_seats.matches("[0-9]*")))
		{
			message+="   gold seats should conatin numeric values only   ";
		}
		if(platinum.trim().length()==0)
		{
			message+="   Enter the rates for platinum seats   ";
			valid=false;
		} 
		if((!platinum.matches("[0-9]*.[0-9]*")))
		{
			message+="   rates for platinum seats should conatin numeric values only   ";
		}
		if(platinum_seats.trim().length()==0)
		{
			message+="   Enter the platinum seats available   " ;
			valid=false;
		} 
		if((!platinum_seats.matches("[0-9]*")))
		{
			message+="   platinum seats should conatin numeric values only   ";
		}
		if(valid)
		{
			users.add(new admin(name, image, Double.parseDouble(rating), Double.parseDouble(gold), Integer.parseInt(gold_seats), Double.parseDouble(silver), Integer.parseInt(silver_seats), Double.parseDouble(platinum), Integer.parseInt(platinum_seats)));
			response.sendRedirect("admin_cinema.jsp");	
		}
		else
		{
			response.sendRedirect("AddMovie_Cinema.jsp?msg=" + URLEncoder.encode(message,"UTF-8"));
		}


	}

}
