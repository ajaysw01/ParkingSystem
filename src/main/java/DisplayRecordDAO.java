import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayRecordDAO {
    private String url = "jdbc:mysql://localhost:3306/parking_solution";
    private String user = "root";
    private String password = "root";
    
    public List<Records> getAllRecords() {
        List<Records> parkingRecords = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ParkingRecords")) {
            while (rs.next()) {
                Records record = new Records();
                record.setLocation(rs.getString("Location"));
                record.setDate(rs.getString("Date"));
                record.setUserName(rs.getString("UserName"));
                record.setRollNo(rs.getInt("RollNo"));
                record.setInTime(rs.getString("InTime"));
                record.setVehicleType(rs.getString("VehicleType"));
                record.setVehicleNo(rs.getString("VehicleNo"));
                record.setPaymentMethod(rs.getString("PaymentMethod"));
                parkingRecords.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkingRecords;
    }
    
    public boolean addRecord(Records record) {
        boolean success = false;
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO ParkingRecords VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, record.getLocation());
            stmt.setString(2, record.getDate());
            stmt.setString(3, record.getUserName());
            stmt.setInt(4, record.getRollNo());
            stmt.setString(5, record.getInTime());
            stmt.setString(6, record.getVehicleType());
            stmt.setString(7, record.getVehicleNo());
            stmt.setString(8, record.getPaymentMethod());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public boolean deleteRecord(int id) {
        boolean success = false;
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM ParkingRecords WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public boolean updateRecord(Records record) {
        boolean success = false;
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE ParkingRecords SET Location = ?, Date = ?, UserName = ?, RollNo = ?, InTime = ?, VehicleType = ?, VehicleNo = ?, PaymentMethod = ? WHERE RollNo = ?")) {
            stmt.setString(1, record.getLocation());
            stmt.setString(2, record.getDate());
            stmt.setString(3, record.getUserName());
            stmt.setInt(4, record.getRollNo());
            stmt.setString(5, record.getInTime());
            stmt.setString(6, record.getVehicleType());
            stmt.setString(7, record.getVehicleNo());
            stmt.setString(8, record.getPaymentMethod());
            stmt.setInt(9, record.getRollNo());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
