import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServelet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() 
	{
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String EmailId = request.getParameter("emId");
		String Password = request.getParameter("pass");

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		LoginDAO dao = new LoginDAO();
		User user = dao.validateUser(EmailId, Password);
		if(user!= null) {
			session.setAttribute("current-user",user);
			response.sendRedirect("User-defaultpage.html");
		}else {
			response.sendRedirect("LandingPage.html");
			
		}
	}
	
}