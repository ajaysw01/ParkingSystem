import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RecordServelet")
public class RecordServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public RecordServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Records recObj = new Records();
		recObj.setLocation(request.getParameter("location"));
		recObj.setDate(request.getParameter("date"));
		recObj.setUserName(request.getParameter("username"));
		recObj.setRollNo(Integer.parseInt(request.getParameter("userrno")));
		recObj.setInTime(request.getParameter("intime"));
		recObj.setVehicleType(request.getParameter("vType"));
		recObj.setVehicleNo(request.getParameter("vNo"));
		recObj.setPaymentMethod(request.getParameter("payment"));
		
		AddVeDAO recDAOObj = new AddVeDAO();
		if(recDAOObj.insertRecord(recObj))
		{
			response.sendRedirect("Success.html");
		}
		else
		{
			response.sendRedirect("Retry.html");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
