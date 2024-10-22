package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class UpdateHotelServices {

	Connection conn= databaseConnectionUtil.getConnection();
	
	public int updateHotel(HotelDto hoteldto)
	{
		int x=0;
		try {
			PreparedStatement ps= conn.prepareStatement("UPDATE addhotel SET hotelname=?,HotelLocation=?,hotelType=? ,hotelpayment=? ,totalrooms=? WHERE hotel_id=?");
			ps.setString(1, hoteldto.gethotelname());    
	        ps.setString(2, hoteldto.getHotellocation());   
	        ps.setString(3, hoteldto.getHoteltype()); 
	        ps.setString(4, hoteldto.getHotelPayment());
	        ps.setString(5, hoteldto.getTotalrooms());
	        ps.setInt(6, hoteldto.getHotel_id());  
	        x = ps.executeUpdate();
	        if (x> 0) {
	            System.out.println("Update Success");
	        } else {
	            System.out.println("Update Failed");
	        }

	    } catch (SQLException e) {
	       e.printStackTrace();
	    }
		return x;
	}
}

