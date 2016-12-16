package cs1220.lab5;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class savepage
 */
@WebServlet("/cs1220/lab5/savepage")
public class savepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savepage() {
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
		String index=request.getParameter("id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String image=request.getParameter("image");
		
		
		admin add=new admin(Integer.parseInt(index),name,Integer.parseInt(price),Integer.parseInt(quantity),image);
		ArrayList<admin> item=(ArrayList<admin>) getServletContext().getAttribute("admins");
	  item.set(Integer.parseInt(index), add);
	   HttpSession sess=request.getSession();
		sess.setAttribute("trial",item);
		
		ArrayList<Login> user=(ArrayList<Login>) getServletContext().getAttribute("page");
		HttpSession session=request.getSession();
		session.setAttribute("use",user);
		
		response.sendRedirect("admin_shopping.jsp");
		
	}

}
