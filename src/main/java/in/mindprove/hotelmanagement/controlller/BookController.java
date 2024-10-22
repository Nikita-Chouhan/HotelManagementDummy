package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.service.HotelServices;
import in.mindprove.hotelmanagement.service.UserService;
import in.mindprove.hotelmanagement.service.bookingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		roomDto u = new roomDto();
		List<String> list = new LinkedList<>();

		String hotelIdStr = request.getParameter("hotel_id");
		if (hotelIdStr == null || hotelIdStr.isEmpty()) {
			list.add("Hotel ID is required.");
		} else {
			try {
			u.setHotel_id(Integer.parseInt(hotelIdStr));
		} 
		catch (NumberFormatException e) {
	        System.out.println("Invalid Hotel ID format: " + hotelIdStr);  // Debugging
	        list.add("Invalid hotel ID format.");
		}
			HotelDto hotelDto = HotelServices.getHotelById(u.getHotel_id());
		}
		
		String userIdStr = request.getParameter("user_id");
		if (userIdStr == null || userIdStr.isEmpty()) {
			list.add("user ID is required.");
		} 
		else {
		try {
			u.setUser_id(Integer.parseInt(userIdStr));
		} 
		catch (NumberFormatException e) {
	        System.out.println("Invalid user ID format: " + userIdStr);  // Debugging
	        list.add("Invalid hotel ID format.");
		}
		//Userdto userdto = UserService.getuserById(u.getUser_id());
			
	    }

	//	String hotelname1 = request.getParameter("HotelName");
		String roomid = u.setRoomnumber(request.getParameter("totalroom"));
		String capacity =u.setcapacity(request.getParameter("t2"));
		String checkin = u.setcheckin(request.getParameter("t3"));
		String checkout = u.setcheckout(request.getParameter("t4"));

		// Validation
		if (roomid == null || roomid.isEmpty()) {
			list.add("Room ID is required.");
		}
		if (capacity == null || capacity.isEmpty()) {
			list.add("Capacity is required.");
		}
		if (checkin == null || checkin.isEmpty()) {
			list.add("Check-in date is required.");
		}
		if (checkout == null || checkout.isEmpty()) {
			list.add("Check-out date is required.");
		}

		if (!list.isEmpty()) {
			request.setAttribute("errorlist", list);
			RequestDispatcher rd = request.getRequestDispatcher("Book.jsp");
			rd.forward(request, response);
		} else {
			bookingService book = new bookingService();
			String action = request.getParameter("action");

			if ("book".equals(action)) {
				int x = book.book(u);
				if (x >= 1) {
					request.setAttribute("sms", "Booked Successfully");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
			rd.forward(request, response);
		}
	}
}