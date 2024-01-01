import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displayRecords")
public class DisplayRecordsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DisplayRecordDAO displayRecordDAO;

    public void init() {
        displayRecordDAO = new DisplayRecordDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
        List<Records> records = displayRecordDAO.getAllRecords();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Parking Records</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Parking Records</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Location</th>");
        out.println("<th>Date</th>");
        out.println("<th>User Name</th>");
        out.println("<th>Roll No</th>");
        out.println("<th>In Time</th>");
        out.println("<th>Vehicle Type</th>");
        out.println("<th>Vehicle No</th>");
        out.println("<th>Payment Method</th>");
        out.println("</tr>");
        for (Records record : records) {
            out.println("<tr>");
            out.println("<td>" + record.getLocation() + "</td>");
            out.println("<td>" + record.getDate() + "</td>");
            out.println("<td>" + record.getUserName() + "</td>");
            out.println("<td>" + record.getRollNo() + "</td>");
            out.println("<td>" + record.getInTime() + "</td>");
            out.println("<td>" + record.getVehicleType() + "</td>");
            out.println("<td>" + record.getVehicleNo() + "</td>");
            out.println("<td>" + record.getPaymentMethod() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    	
}
