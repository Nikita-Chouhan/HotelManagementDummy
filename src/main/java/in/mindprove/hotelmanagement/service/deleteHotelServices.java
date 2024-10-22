package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class deleteHotelServices {
	Connection conn = databaseConnectionUtil.getConnection();

	public int deletehotel(HotelDto hoteldto) {

		int x = 0;

		try {
			  PreparedStatement ps1 = conn.prepareStatement("delete from addhotel where hotel_id=?");

              ps1.setInt(1, hoteldto.getHotel_id());  
              x = ps1.executeUpdate();
              if (x> 0) {
                  System.out.println("Successully deleted");
              } else {
                  System.out.println("not deleted");
              }

		}catch(SQLException e) {
			e.printStackTrace();{
			
}
}
		return x;
	}}