package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;



public class bookingService {
	 Connection con = databaseConnectionUtil.getConnection();
	 
    public int book(roomDto u) {
        int x = 0;
        
        int hotel_id=0;
             int generateEventId = databaseConnectionUtil.generateEventId();
             
             HotelDto hotelDto = HotelServices.getHotelById(u.getHotel_id());
             String hotelname = hotelDto != null ? hotelDto.gethotelname() : null;

             if (hotelname == null) {
                 System.out.println("Hotel name is not found for the given hotel_id.");
                 return 0; 
             }	
             
        try {
                 
                
            
        	PreparedStatement ps = con.prepareStatement("INSERT INTO booking(booking_id,user_id,hotel_id,hotelname,roomnumber,capacity,checkin,checkout) VALUES (?,?,?,?,?,?,?,?)");
            HotelDto hoteldto = new HotelDto();
            
            ps.setInt(1,generateEventId);
            ps.setInt(2, u.getUser_id());
            ps.setInt(3, u.getHotel_id());
            ps.setString(4,hotelname);
            ps.setString(5, u.getRoomnumber());
            ps.setString(6,u.getcapacity());
            ps.setString(7,u.getcheckin());
            ps.setString(8,u.getcheckout());

            x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Not");
            }

        } catch (SQLException e) {
        	System.out.println("SQL Exception : ----");
            e.printStackTrace(); 
        }

        return x;
    }
    public List<roomDto> getAllBookings() {
        List<roomDto> bookings = new ArrayList<>();

        try {
            String query = "SELECT booking_id,user_id,hotel_id, hotelname, roomnumber, capacity, checkin, checkout FROM booking";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                roomDto booking = new roomDto();
            	HotelDto hoteldto = new HotelDto();

                booking.setBooking_id(rs.getInt("booking_id"));
                booking.setUser_id(rs.getInt("user_id"));
                booking.setHotel_id(rs.getInt("hotel_id"));
                hoteldto.sethotelname(rs.getString("hotelname"));
                booking.setRoomnumber(rs.getString("roomnumber"));
                booking.setcapacity(rs.getString("capacity"));
                booking.setcheckin(rs.getString("checkin"));
                booking.setcheckout(rs.getString("checkout"));

                bookings.add(booking); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}
    

