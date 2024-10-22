package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class deleteSevice {
	databaseConnectionUtil db= new databaseConnectionUtil();
	 Connection con = databaseConnectionUtil.getConnection();
	   
	        public int delete(roomDto u) {
	          //  System.out.println("delete");
	            int y = 0;

	            try {
	                PreparedStatement ps1 = con.prepareStatement("delete from booking where roomnumber=?");

	                ps1.setString(1, u.getRoomnumber());  
	                y = ps1.executeUpdate();
	                if (y > 0) {
	                    System.out.println("Success");
	                } else {
	                    System.out.println("Not");
	                }

	            } catch (SQLException e) {
	                e.printStackTrace(); 
	            }

	            return y;
	       

	    }
}
