package cs1220.lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class quotesandauthor
 */
@WebServlet(name = "quotes", urlPatterns = { "/quotes" })
public class quotesandauthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context=this.getServletContext();
		if(context.getAttribute("quote")==null)
		{
			ArrayList<quote> regentries=new ArrayList<quote>();
			regentries.add(new quote("Slow and Steady wins the race","John Doe"));
	    	regentries.add(new quote("Speed thrills but kills","Andrew Hall"));
	    	regentries.add(new quote("Tit for Tat","Andre Russell"));
	    	regentries.add(new quote("A Friend in need is a Friend Indeed","Bill Gates"));
	    	regentries.add(new quote("Cleanliness is next to Godliness","Steve Jobs"));
	    	context.setAttribute("quote", regentries);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Quotes and Author");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='quotes'>");
		out.println("Quotes <br>");
		out.println("<input type='text' name='quotes' id='quotes'> <br>");
		out.println("Author <br>");
		out.println("<input type='text' name='author' id='author'> <br>");
		out.println("<input type='submit' name='submit' value='submit'> <br>");
		out.println("</form>");
		out.println("</body>");
	
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String quote=request.getParameter("quotes");
		String author=request.getParameter("author");
		
		@SuppressWarnings("unchecked")
		ArrayList<quote> authors=(ArrayList<quote>) this.getServletContext().getAttribute("quote");
		authors.add(new quote(quote,author));
		
		PrintWriter out=response.getWriter();
				
	    out.println("<html>");
				out.println("<head>");
				out.println("<title>Task Application</title>");	
				out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
				out.println("</head>");
				out.println("<body>");
				out.println("<table class='table'>");
				out.println("<tr>");
				out.println("<td style='border-right:5px; border-left:5px;'>Quotes </td>");
				out.println("<td style='border-right:5px; border-left:5px;'>Authors </td>");
				
				out.println("</tr>");
				for(quote s: authors){
					out.println("<tr>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ s.getQuotes()+"</td>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ s.getAuthor()+"</td>");
					out.println("</tr>");	
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
	
				out.println("<form method='get' action='quotes'>");
				out.println("<input type='submit' value='Add' name='Add'>");
				out.println("</form>");
		//doGet(request, response);
	}

}
