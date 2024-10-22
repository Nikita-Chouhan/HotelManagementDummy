package in.mindprove.hotelmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.mindprove.hotelmanagement.dto.roomDto;

public class databaseConnectionUtil {
	

	public static Connection getConnection() {
		{
			Connection con=null;

			 try 
			 {
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?user=root&password=Nikita@123");
		     }
			 catch (Exception e)
			 {
		         e.printStackTrace(); 
		     }
				
		return con;
	}
	}
	
	  public static int generateEventId() {
	        int booking_id = 0;
	        Statement statement = null;
	        ResultSet rs = null;
	        Connection con = getConnection();

	        try {
	           
	          
	            statement = con.createStatement();
	            rs = statement.executeQuery("SELECT MAX(booking_id) FROM booking");

	            int maxEventId = (int) 1L	; 
	            if (rs.next()) {
	                maxEventId = (int) rs.getLong(1);
	            }
	           booking_id = ++maxEventId;
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (IllegalStateException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (statement != null) statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	       

	        return booking_id;
	    }


}