package cs1220.homework3;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admin_shopping
 */
@WebServlet("/cs1220/homework3/admin_cinema")
public class admin_cinema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_cinema() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException
    {
    	ServletContext context=this.getServletContext();
		if(context.getAttribute("admins")==null)
		{
			ArrayList<admin> admin=new ArrayList<admin>();
			admin.add(new admin("Doctor Strange","https://images-na.ssl-images-amazon.com/images/M/MV5BMjM2ODA4MTM0M15BMl5BanBnXkFtZTgwNzE5OTYxMDI@._V1_SY317_CR1,0,214,317_AL_.jpg",8.0,100.0,25,80,24,70,50));
			admin.add(new admin("Trolls","https://images-na.ssl-images-amazon.com/images/M/MV5BMTkxNDc3OTcxMV5BMl5BanBnXkFtZTgwODk2NjAzOTE@._V1_UX182_CR0,0,182,268_AL_.jpg",6.7,200.0,50,150,45,100,30));
			admin.add(new admin("Hacksaw Ridge","https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ1NjM3MTUxNV5BMl5BanBnXkFtZTgwMDc5MTY5OTE@._V1_UX182_CR0,0,182,268_AL_.jpg",8.8,250.0,100,200,80,150,100));
			admin.add(new admin("Loving","https://images-na.ssl-images-amazon.com/images/M/MV5BMjE4NTI3NjIzOF5BMl5BanBnXkFtZTgwNjI0NTI5ODE@._V1_SX214_AL_.jpg",6.7,120,20,100,50,130,23));
			admin.add(new admin("The Eagle Huntress","https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxNDgwNDYzMl5BMl5BanBnXkFtZTgwNTQ3NDc3OTE@._V1_UX182_CR0,0,182,268_AL_.jpg",7.6,130,20,100,90,90,70));
			context.setAttribute("admins", admin);			
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<admin> items=(ArrayList<admin>) getServletContext().getAttribute("admins");
		HttpSession sess=request.getSession();
		sess.setAttribute("trial",items);
		
		response.sendRedirect("admin_cinema.jsp");
		//doGet(request, response);
	}

}
