import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddVeDAO {

	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://localhost:3306/parking_solution";
	String userName ="root";
	String pwd = "root";
	Connection dbCon;
	
	private boolean connectToDtbc()throws SQLException,ClassNotFoundException
	{
	  Class.forName(dbDriver);
	  dbCon = DriverManager.getConnection(dbURL,userName,pwd);
	  return true;
	}
	 public boolean insertRecord(Records recObj)
	  {
		  String insertQueryStr = "INSERT into userrecords VALUES(?,?,?,?,?,?,?,?)";
		  
		  try
		  {
			  if(connectToDtbc())
			  {
				  PreparedStatement ppStmt = dbCon.prepareStatement(insertQueryStr);
				  ppStmt.setString(1,recObj.getLocation());
				  ppStmt.setString(2,recObj.getDate());
				  ppStmt.setString(3,recObj.getUserName());
				  ppStmt.setInt(4,recObj.getRollNo());
				  ppStmt.setString(5,recObj.getInTime());
				  ppStmt.setString(6,recObj.getVehicleType());
				  ppStmt.setString(7,recObj.getVehicleNo());
				  ppStmt.setString(8,recObj.getPaymentMethod());
				  ppStmt.executeUpdate();
				  ppStmt.close();
				  dbCon.close();
				  return true;
			  }
			  else
				  return false;
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
			  return false;
		  }
	}
}

		