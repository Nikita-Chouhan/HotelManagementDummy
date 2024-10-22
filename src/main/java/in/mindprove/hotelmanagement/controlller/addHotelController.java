package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.service.addHotelServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addHotelController")
public class addHotelController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HotelDto hoteldto = new HotelDto(); 
		
		String hotelname = hoteldto.sethotelname(request.getParameter("hotelname"));
		String hotellocation = hoteldto.setHotellocation(request.getParameter("Location"));
		String hoteltype = hoteldto.setHoteltype(request.getParameter("HotelType"));
		String hotelPayment=hoteldto.setHotelPayment(request.getParameter("HotelPayment"));
		String hotelrooms=hoteldto.setTotalrooms(request.getParameter("totalrooms"));
		addHotelServices add = new addHotelServices();
		String action = request.getParameter("action");
		if ("Inserted".equals(action)) {
			int x = add.addhotel(hoteldto);
			if (x >= 1) {
				request.setAttribute("", "Hotel Booked Successfully");
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);
	}
}