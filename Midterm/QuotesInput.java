package cs1220.Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class QuotesInput
 */
@WebServlet("/QuotesInput")
public class QuotesInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<quotes> quoteslist=new ArrayList<quotes>();
	Date date=new Date();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public QuotesInput() {
        super();
        // TODO Auto-generated constructor stub
        quoteslist.add(new quotes("Slow and Steady wins the race","John Doe",date));
    	quoteslist.add(new quotes("Speed thrills but kills","Andrew Hall",date));
    	quoteslist.add(new quotes("Tit for Tat","Andre Russell",date));
    	quoteslist.add(new quotes("A Friend in need is a Friend Indeed","Bill Gates",date));
    	quoteslist.add(new quotes("Cleanliness is next to Godliness","Steve Jobs",date));
           
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Midterm");
		out.println("</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='QuotesInput' method='post'>");
		out.println("Quote");
		out.println("<input type='text' id='quote' name='quote' style='border-radius:10px'><br>");
		out.println("Author Name");
		out.println("<input type='text' id='author' name='author' style='border-radius:10px'><br>");
		out.println("<input type='submit' value='submit' style='border-radius:10px'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
boolean valid=true;
	
		
		PrintWriter out=response.getWriter();
        		response.setContentType("text/html");
		String quote = request.getParameter("quote");
		String author = request.getParameter("author");
		Date date=new Date();
		SimpleDateFormat simpledate = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		String Date=simpledate.format(date);
		//tasks.add(new Records("John","Doe","Task1",Date));
		//tasks.add(new Records("Jane","Doe","Task2",Date));
		
		
		
		if(quote.trim().length()==0)
		{
			out.println("Quote should not be empty<br>");
			valid=false;
		}
		if(!(quote.matches("[a-zA-Z ]*")))
		{
			out.println("Quotes should contain only characters <br>");
			valid=false;
		}
		if(author.trim().length()==0)
		{
			out.println("Author Name should not be empty <br>");
			valid=false;
		}
		if(!(author.matches("[a-zA-Z ]*")))
		{
			out.println("Author Name should contain only characters <br>");
			valid=false;
		}
		
		if(valid)
		{
			quoteslist.add(new quotes(quote,author,date));
			
			    out.println("<html>");
				out.println("<head>");
				out.println("<title>Quotes Input</title>");	
				out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
				out.println("</head>");
				out.println("<body>");
				out.println("<table class='table'>");
				out.println("<tr>");
				out.println("<td style='border-right:5px; border-left:5px;'>Quote</td>");
				out.println("<td style='border-right:5px; border-left:5px;'>Author Name</td>");
				out.println("<td style='border-right:5px; border-left:5px;'>Date</td>");
				out.println("</tr>");
				String temp_quote,temp_author;
				Date temp_date;
				int k=0;
				for(int i=0;i<quoteslist.size();i++){
					for(int j=0;j<quoteslist.size()-1;j++)
					{
							 if((quoteslist.get(j).getAuthor().compareToIgnoreCase(quoteslist.get(j+1).getAuthor()))>0)
									 
						{
							temp_quote=quoteslist.get(j).getQuote();
							temp_author=quoteslist.get(j).getAuthor();
							temp_date=quoteslist.get(j).getDate();
							quoteslist.set(j, new quotes(quoteslist.get(j+1).getQuote(),quoteslist.get(j+1).getAuthor(),quoteslist.get(j+1).getDate()));
							quoteslist.set(j+1, new quotes(temp_quote,temp_author,temp_date));
							
						}
						
						
					}
				}
				
				for(int i=0;i<quoteslist.size();i++)
				{
					out.println("<tr>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ quoteslist.get(i).getQuote()+"</td>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ quoteslist.get(i).getAuthor()+"</td>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ quoteslist.get(i).getDate()+"</td>");
					out.println("</tr>");	
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
		}
		

		//doGet(request, response);
	}

}
