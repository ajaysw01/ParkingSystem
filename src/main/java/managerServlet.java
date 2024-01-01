import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class managerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public managerServlet() {
		super();
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String UserName = request.getParameter("username");
		String Password = request.getParameter("pass");

		response.setContentType("text/html");
		ManagerDAO mdao = new ManagerDAO();
		Manager mngr = mdao.validateUser(UserName, Password);
		if(mngr!= null) {
			response.sendRedirect("manager.html");
		}else {
			response.sendRedirect("Retry1.html");
			
		}
	}
	
}