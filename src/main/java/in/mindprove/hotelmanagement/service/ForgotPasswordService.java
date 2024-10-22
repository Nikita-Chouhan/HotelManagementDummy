package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class ForgotPasswordService {
	databaseConnectionUtil db= new databaseConnectionUtil();
	 Connection con = databaseConnectionUtil.getConnection();
	   
   public int updatePassword(Userdto u) {
	    int z = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement("UPDATE user SET Password=? WHERE email=?");

	        ps.setString(1, u.getpassword());    
	        ps.setString(2, u.getemail());   
	    
	    z = ps.executeUpdate();
        if (z > 0) {
            System.out.println("Password Update Success");
        } else {
            System.out.println("Password Update Failed");
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
   
