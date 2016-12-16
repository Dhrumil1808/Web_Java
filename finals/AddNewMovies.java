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

import com.mysql.jdbc.PreparedStatement;

import cs1220.database.index;
import cs1220.database.log;

/**
 * Servlet implementation class AddNewMovie
 */
@WebServlet("/cs1220/finals/AddNewMovie")
public class AddNewMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMovies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username="cs1220stu13";
		String password="tojQ70RE";
		String hostname="cs3.calstatela.edu";	
		String port="3306";
		String dbName="cs1220stu13";
		
		try
		{
			String moviename=request.getParameter("moviename");
			String days=request.getParameter("days");
			String available="Make Available";
			String gold=request.getParameter("gold");
			String silver=request.getParameter("silver");
			String platinum=request.getParameter("platinum");
			
			System.out.println("Class.forName");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//com.mysql.jdbc.Driver driver= new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mysql://"+ hostname + ":" + port + "/" + dbName;

			System.out.println("Creating Connection");
			
			Connection connection= (Connection) DriverManager.getConnection(url,username,password);
			
			System.out.println("Creating Statement");
			Statement statement=(Statement) connection.createStatement();
			
			
			
			
			String inserts="INSERT Movies "+ " VALUES (NULL," + "'" + days + "'" +  ","  + "'" + moviename + "'"  +  ","  + "'" + available + "'" + ","  + "'" + Integer.parseInt(silver) + "'" + ","  + "'" + Integer.parseInt(gold) + "'" + ","  + "'" + Integer.parseInt(platinum) + "'"+ ")";
			statement.executeUpdate(inserts);
			
			String query="SELECT * FROM Movies";
			System.out.println("Executing Query");
			ResultSet resultSet=statement.executeQuery(query);
			
			System.out.println("Iterating over results");
			ArrayList<Movies> users=new ArrayList<Movies>();
			
			ArrayList<String> day=new ArrayList<String>();
			day.add("Monday");
			day.add("Tuesday");
			day.add("Wednesday");
			day.add("Thursday");
			day.add("Friday");
			day.add("Saturday");
			day.add("Sunday");
			
			while(resultSet.next())
			{
				users.add(new Movies(resultSet.getInt("ID"),resultSet.getString("Days"),resultSet.getString("Movies"),resultSet.getString("Available"),resultSet.getInt("Silver"),resultSet.getInt("Gold"),resultSet.getInt("Platinum")));
			}
			
			
			
			for(int i=0;i<users.size();i++)
			{
				System.out.println(users.get(i).getId() + "  " + users.get(i).getDays() + "  " + users.get(i).getMoviename() + "  " + users.get(i).getAvailable() + "  " + users.get(i).getSilver() + "  " + users.get(i).getGold()+ "  " + users.get(i).getPlatinum());
			}
			
						HttpSession sess=request.getSession();
			sess.setAttribute("trial",users);

			HttpSession session=request.getSession();
			session.setAttribute("da",day);

			response.sendRedirect("CinemaTimings.jsp");
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
