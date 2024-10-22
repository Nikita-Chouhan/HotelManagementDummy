package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class UpdateService {
	databaseConnectionUtil db= new databaseConnectionUtil();
	 Connection con = databaseConnectionUtil.getConnection();
	   
    public int update(roomDto u) {
	    int z = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement("UPDATE booking SET capacity=?, checkin=?, checkout=? WHERE roomnumber=?");

	        ps.setString(1, u.getcapacity());    
	        ps.setString(2, u.getcheckin());   
	        ps.setString(3, u.getcheckout());  
	        ps.setString(4, u.getRoomnumber());     

	        
	        z = ps.executeUpdate();
	        if (z > 0) {
	            System.out.println("Update Success");
	        } else {
	            System.out.println("Update Failed");
	        }

	    } catch (SQLException e) {
	       e.printStackTrace();
	    }
	    catch (IllegalStateException e)
	    {
	    	e.printStackTrace();
	    }
	    return z;
	}
}
