package cs1220.database;

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
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class userdisplay
 */
@WebServlet("/cs1220/database/userdisplay")
public class userdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username="cs1220stu13";
		String password="tojQ70RE";
		String hostname="cs3.calstatela.edu";	
		String port="3306";
		String dbName="cs1220stu13";
		
		try
		{
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			System.out.println("Class.forName");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//com.mysql.jdbc.Driver driver= new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mysql://"+ hostname + ":" + port + "/" + dbName;

			System.out.println("Creating Connection");
			
			Connection connection= (Connection) DriverManager.getConnection(url,username,password);
			
			System.out.println("Creating Statement");
			Statement statement=(Statement) connection.createStatement();
			
			
			PreparedStatement stmt= (PreparedStatement) connection.prepareStatement("INSERT INTO first VALUES(?)");
			//stmt.setString(2, "Bob");
			//int k=stmt.executeUpdate();
			//System.out.println(k);
			String update="UPDATE first " + "SET UserName='Andrew' WHERE ID=8";
			statement.executeUpdate(update);
			
			String insert="INSERT first " + " VALUES (NULL,'James')";
			statement.executeUpdate(insert);
			
			String inserts="INSERT login "+ " VALUES (NULL," + "'" + user + "'" +  ","  + "'" + pass + "'" + ")";
			statement.executeUpdate(inserts);
			
			String query="SELECT * FROM first";
			System.out.println("Executing Query");
			ResultSet resultSet=statement.executeQuery(query);
			
			System.out.println("Iterating over results");
			ArrayList<index> users=new ArrayList<index>();
			
			while(resultSet.next())
			{
				users.add(new index(resultSet.getInt("ID"),resultSet.getString("Username")));
			}
			
			ArrayList<log> use=new ArrayList<log>();
			String querys="SELECT * FROM login";
			System.out.println("Executing Query");
			ResultSet results=statement.executeQuery(querys);
			
			while(results.next())
			{
				use.add(new log(results.getInt("ID"),results.getString("Username"),results.getString("Password")));
			}
			
			for(int i=0;i<users.size();i++)
			{
				System.out.println(users.get(i).getId() + "  " + users.get(i).getUsername());
			}
			
			for(int i=0;i<use.size();i++)
			{
				System.out.println(use.get(i).getId() + "  " + use.get(i).getUser() + " " + use.get(i).getPass());
			}
			
			HttpSession sess=request.getSession();
			sess.setAttribute("trial",users);

			HttpSession session=request.getSession();
			session.setAttribute("trials",use);
			
			response.sendRedirect("content.jsp");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
