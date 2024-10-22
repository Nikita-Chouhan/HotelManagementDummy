package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class addHotelServices {
	Connection conn = databaseConnectionUtil.getConnection();

	public int addhotel(HotelDto hoteldto) {

		int x = 0;

		try {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO addhotel (hotel_id,hotelname,hotelLocation,hotelType,hotelpayment,totalrooms)values(?,?,?,?,?,?)");
			ps.setInt(1, hoteldto.getHotel_id());
			ps.setString(2, hoteldto.gethotelname());
			ps.setString(3, hoteldto.getHotellocation());
			ps.setString(4, hoteldto.getHoteltype());
			ps.setString(5, hoteldto.getHotelPayment());
			ps.setString(6, hoteldto.getTotalrooms());
			
			x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Not");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
}