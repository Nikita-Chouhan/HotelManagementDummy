package in.mindprove.hotelmanagement.controlller;
import java.io.IOException;
import java.util.List;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.service.HotelServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AllHotelsController")
public class AllHotelsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                HotelServices services = new HotelServices();

        List<HotelDto> hotelList = services.getAllHotels();

        
        if (!hotelList.isEmpty()) {
            // Set the list of hotels as an attribute to be accessed in the JSP
            request.setAttribute("hotelList", hotelList);
        } else {
            // If no hotels are found, you can set a message or handle it as needed
            request.setAttribute("errorMsg", "No hotels available.");
        }

        // Forward to Admin.jsp to display the list
        RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
        rd.forward(request, response);
    }
}
