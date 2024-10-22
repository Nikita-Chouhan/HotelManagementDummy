package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.service.deleteHotelServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteHotelController")
public class deleteHotelController extends HttpServlet {
		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
			{
			 HotelDto hoteldto= new HotelDto();
			 
			 String hotelIdStr = request.getParameter("hotel_id");
		        if (hotelIdStr != null && !hotelIdStr.isEmpty()) {
		            int hotelId = Integer.parseInt(hotelIdStr);
		            hoteldto.setHotel_id(hotelId); 
		        

			 deleteHotelServices delete= new deleteHotelServices();
		        String action = request.getParameter("action");
		        if("Delete".equals(action)){
		    		int x=delete.deletehotel(hoteldto);
		    		String target1="";
		    		if(x>=1)
		    		{
		    			request.setAttribute("","Deleted Successfully");
		    			target1="/Admin.jsp";
		    	
		    		}
		    		RequestDispatcher rd2 = request.getRequestDispatcher(target1);
		    		rd2.forward(request, response);
		    		}
}
}}