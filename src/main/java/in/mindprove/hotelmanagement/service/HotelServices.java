package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class HotelServices {
    static Connection con = databaseConnectionUtil.getConnection();

    public static List<HotelDto> getAllHotels() {
        List<HotelDto> hotelList = new ArrayList<>();
        try {
            String query = "SELECT * FROM addhotel";
            PreparedStatement stmt = con.prepareStatement(query);
           
            
            ResultSet rs = stmt.executeQuery();

            
            while (rs.next()) {
            	int int1 = rs.getInt("hotel_id");
            	String string = rs.getString("hotelname");
            	String string2 = rs.getString("hotelLocation");
            	String string3 = rs.getString("hotelType");
            	String string4=rs.getString("hotelpayment");
            	
            	HotelDto hoteldto = new HotelDto();
                hoteldto.setHotel_id(int1); 
                hoteldto.sethotelname(string);
                hoteldto.setHotellocation(string2);
                hoteldto.setHoteltype(string3);
                hoteldto.setHotelPayment(string4);

                hotelList.add(hoteldto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelList;
   
    }
    public static HotelDto getHotelById(int hotel_id) {
        HotelDto hotel = null;
        try (Connection con = databaseConnectionUtil.getConnection()) {
            String query = "SELECT * FROM addhotel WHERE hotel_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, hotel_id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hotel = new HotelDto();
                hotel.setHotel_id(rs.getInt("hotel_id"));
                hotel.sethotelname(rs.getString("hotelname"));
            
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Hotel fetched: " + (hotel != null ? hotel.gethotelname() : "Not found"));
        return hotel;
    }

    
}
