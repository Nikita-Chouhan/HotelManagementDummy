package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.service.UpdateHotelServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateHotelController")
public class UpdateHotelController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HotelDto hoteldto = new HotelDto();
		String hotelIdStr = request.getParameter("hotel_id");
        if (hotelIdStr != null && !hotelIdStr.isEmpty()) {
            int hotelId = Integer.parseInt(hotelIdStr);
            hoteldto.setHotel_id(hotelId); ;
		String hotelname = hoteldto.sethotelname(request.getParameter("HotelName"));
		String hotellocation = hoteldto.setHotellocation(request.getParameter("Location"));
		String hoteltype = hoteldto.setHoteltype(request.getParameter("HotelType"));
		String hotelpayment=hoteldto.setHotelPayment(request.getParameter("HotelPayment"));
		String hotelType=hoteldto.setTotalrooms(request.getParameter("totalrooms"));
		
		UpdateHotelServices update = new UpdateHotelServices();
		String action = request.getParameter("action");
		if ("Updated".equals(action)) {
			int x = update.updateHotel(hoteldto);
			if (x >= 1) {
				request.setAttribute("", "Hotel Updated Successfully");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);
	}
}
}
