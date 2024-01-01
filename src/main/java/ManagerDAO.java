import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {

	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/parking_solution";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	Connection dbCon;
	
	private boolean connectToDtbc()throws SQLException,ClassNotFoundException
	{
	  Class.forName(dbDriver);
	  dbCon = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
	  if(dbCon != null) {
		  return true;
	  }
	return false;
	}
	
	public Manager validateUser(String username, String pass) {
		Manager mngr = null;
		try {
			if(connectToDtbc()) {
				String query = "SELECT * FROM manager WHERE UserName = ? AND Password = ?";
				PreparedStatement stmt = dbCon.prepareStatement(query);
				stmt.setString(1, username);
				stmt.setString(2, pass);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					mngr = new Manager();
					mngr.setUserName(rs.getString(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mngr;
	}
	
}
