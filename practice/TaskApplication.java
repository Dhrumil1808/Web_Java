package cs1220.practice;

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
 * Servlet implementation class TaskApplication
 */
@WebServlet("/TaskApplication")
public class TaskApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskApplication() {
        super();
        // TODO Auto-generated constructor stub
    }
	ArrayList<Records> tasks = new ArrayList<Records>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Practice Midterm");
		out.println("</title>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='TaskApplication' method='post'>");
		out.println("First Name");
		out.println("<input type='text' id='fname' name='fname' style='border-radius:10px'><br>");
		out.println("Last Name");
		out.println("<input type='text' id='lname' name='lname' style='border-radius:10px'><br>");
		out.println("Task Title");
		out.println("<input type='text' id='task' name='task' style='border-radius:10px'><br>");
		out.println("<input type='submit' value='submit' style='border-radius:10px'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
            //PrintWriter out = response.getWriter();
		boolean valid=true;
		PrintWriter out=response.getWriter();
        		response.setContentType("text/html");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String task_title = request.getParameter("task");
		Date date=new Date();
		SimpleDateFormat simpledate = new SimpleDateFormat("E yyyy.MM.DD 'at' hh:mm:ss a zzz");
		String Date=simpledate.format(date);
		//tasks.add(new Records("John","Doe","Task1",Date));
		//tasks.add(new Records("Jane","Doe","Task2",Date));
		
		if(fname.trim().length()==0)
		{
			out.println("Please fill in the First Name <br>");
			valid=false;
		}
		if(!(fname.matches("[a-zA-Z]*")))
		{
			out.println("First Name should contain only characters <br>");
			valid=false;
		}
		if(lname.trim().length()==0)
		{
			out.println("Please fill in the Last Name <br>");
			valid=false;
		}
		if(!(lname.matches("[a-zA-Z]*")))
		{
			out.println("Last Name should contain only characters <br>");
			valid=false;
		}
		if(task_title.trim().length()==0)
		{
			out.println("Please fill in the Task Title <br>");
			valid=false;
		}
		if(!(task_title.matches("[a-zA-Z0-9]*")))
		{
			out.println("Task Title should contain only alphanumeric characters <br>");
			valid=false;
		}
		if(valid)
		{
			tasks.add(new Records(fname,lname,task_title,Date));
			
			    out.println("<html>");
				out.println("<head>");
				out.println("<title>Task Application</title>");	
				out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
				out.println("</head>");
				out.println("<body>");
				out.println("<table class='table'>");
				out.println("<tr>");
				out.println("<td style='border-right:5px; border-left:5px;'>First Name</td>");
				out.println("<td style='border-right:5px; border-left:5px;'>Last Name</td>");
				out.println("<td style='border-right:5px; border-left:5px;'>Task Title</td>");
				out.println("<td style='border-right:5px; border-left:5px;'>Date</td>");
				out.println("</tr>");
				for(Records s: tasks){
					out.println("<tr>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ s.getFname()+"</td>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ s.getLname()+"</td>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ s.getTask()+"</td>");
					out.println("<td style='border-right:5px; border-left:5px;'>"+ s.getDate()+"</td>");
					out.println("</tr>");	
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
		}
		
		
		//tasks.add();
		
		//doGet(request, response);
	}

}
