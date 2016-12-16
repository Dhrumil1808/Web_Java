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
 * Servlet implementation class edit_shopping
 */
@WebServlet("/cs1220/lab5/edit_shopping")
public class edit_shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String index=request.getParameter("index");
		
		ArrayList<admin> item=(ArrayList<admin>) getServletContext().getAttribute("admins");
		ArrayList<admin> end=new ArrayList<admin>();
		for(int i=0;i<item.size();i++){
			if(item.get(i).getId()==Integer.parseInt(index))
			{
				end.add(new admin(item.get(i).getId(),item.get(i).getName(),item.get(i).getPrice(),item.get(i).getQuantity(),item.get(i).getImage()));
			}
		}
		HttpSession sess=request.getSession();
		sess.setAttribute("trials",end);
		response.sendRedirect("edit_shopping.jsp");
		//doGet(request, response);
	}

}
