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
 * Servlet implementation class EditMovie
 */
@WebServlet("/cs1220/finals/EditMovie")
public class EditMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		
		String username="cs1220stu13";
		String password="tojQ70RE";
		String hostname="cs3.calstatela.edu";	
		String port="3306";
		String dbName="cs1220stu13";
		
		try
		{
			
			System.out.println("Class.forName");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//com.mysql.jdbc.Driver driver= new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mysql://"+ hostname + ":" + port + "/" + dbName;

			System.out.println("Creating Connection");
			
			Connection connection= (Connection) DriverManager.getConnection(url,username,password);
			
			System.out.println("Creating Statement");
			Statement statement=(Statement) connection.createStatement();
			
			
			String query="SELECT * FROM Movies WHERE ID=" + Integer.parseInt(id);
			System.out.println("Executing Query");
			System.out.println(query);
			ResultSet resultSet=statement.executeQuery(query);
			
			System.out.println("Iterating over results");
			ArrayList<Movies> user=new ArrayList<Movies>();
			while(resultSet.next())
			{
				user.add(new Movies(resultSet.getInt("ID"),resultSet.getString("Days"),resultSet.getString("Movies"),resultSet.getString("Available"),resultSet.getInt("Silver"),resultSet.getInt("Gold"),resultSet.getInt("Platinum")));
				
			}
			
			HttpSession sess=request.getSession();
			sess.setAttribute("trials",user);
			response.sendRedirect("EditMovie.jsp");
			connection.close();
			
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
