import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServelet")
public class UserServelet extends HttpServlet
{	
	private static final long serialVersionUID = 1L;

    public UserServelet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		User userObj = new User();
		userObj.setUserName(request.getParameter("uName"));
		userObj.setRollNo(Integer.parseInt(request.getParameter("uRNo")));
		userObj.setUClass(request.getParameter("uClass"));
		userObj.setVehicleType(request.getParameter("vType"));
		userObj.setVehicleNo(request.getParameter("vNo"));
		userObj.setEmailId(request.getParameter("emId"));
		userObj.setContactNo(request.getParameter("cNo"));
		userObj.setPassword(request.getParameter("pass"));
		UserDAO userDAOObj = new UserDAO();
		if(userDAOObj.insertRecord(userObj))
		{
			response.sendRedirect("LandingPage.html");
		}
		else
		{
			response.sendRedirect("Retry.html");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
