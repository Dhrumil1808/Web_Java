package cs1220.finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class save
 */
@WebServlet("/cs1220/finals/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String moviename=request.getParameter("moviename");
		String days=request.getParameter("days");
		String silver=request.getParameter("silver");
		String gold=request.getParameter("gold");
		String platinum=request.getParameter("platinum");
		String change=request.getParameter("change");
		String delete=request.getParameter("delete");
		if(delete=="")
		{
			delete="";
		}
		String username="cs1220stu13";
		String password="tojQ70RE";
		String hostname="cs3.calstatela.edu";	
		String port="3306";
		String dbName="cs1220stu13";
	
		try
		{
			int i=0,j=0;
			System.out.println("Class.forName");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//com.mysql.jdbc.Driver driver= new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mysql://"+ hostname + ":" + port + "/" + dbName;

			System.out.println("Creating Connection");
			
			Connection connection= (Connection) DriverManager.getConnection(url,username,password);
			
			System.out.println("Creating Statement");
			Statement statement=(Statement) connection.createStatement();
			
				if(delete!=null)
				{
				if(delete.equals("Delete"))
				{
					i++;
					String deletes="DELETE FROM Movies "+ " WHERE ID=" + Integer.parseInt(id); 
					System.out.println(deletes);
					statement.executeUpdate(deletes);
						
				}
				}
				if(i==0)
				{
				if(change.equals("Change"))
				{
				String update="UPDATE Movies "+"SET Days='" + days + "', Movies='" + moviename + "', Silver='" + silver + "', Gold='" + gold+ "', Platinum='" + platinum + "' WHERE ID='" + id +"'"; 
				System.out.println(update);
				statement.executeUpdate(update);
				}
				}
				String query="SELECT * FROM Movies";
				System.out.println("Executing Query");
				ResultSet resultSet=statement.executeQuery(query);
				
				System.out.println("Iterating over results");
				ArrayList<Movies> users=new ArrayList<Movies>();
				
				while(resultSet.next())
				{
					users.add(new Movies(resultSet.getInt("ID"),resultSet.getString("Days"),resultSet.getString("Movies"),resultSet.getString("Available"),resultSet.getInt("Silver"),resultSet.getInt("Gold"),resultSet.getInt("Platinum")));
				}
				
				
				
				
							HttpSession sess=request.getSession();
				sess.setAttribute("trial",users);

				
				response.sendRedirect("CinemaTimings.jsp");
				connection.close();

				

		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
