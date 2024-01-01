import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/AdminServlet")


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AdminServlet() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String UserName = request.getParameter("username");
		String Password = request.getParameter("pass");

		response.setContentType("text/html");
		AdminDAO adao = new AdminDAO();
		Admin admin = adao.validateUser(UserName, Password);
		if(admin!= null) {
			response.sendRedirect("admin-2wheelerpg.html");
		}else {
			response.sendRedirect("Retry2.html");
			
		}
	}
	
}