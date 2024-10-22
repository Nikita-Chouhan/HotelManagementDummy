package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.service.UpdateService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class updateController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			roomDto u = new roomDto();
			u.setRoomnumber(request.getParameter("totalroom"));
			u.setcapacity(request.getParameter("t2"));
			u.setcheckin(request.getParameter("t3"));
			u.setcheckout(request.getParameter("t4"));
			UpdateService update= new UpdateService();
	        String action = request.getParameter("action");
	         if("update".equals(action)){
				int y=update.update(u);
				String target1="";
				if(y>=1)
				{
					System.out.println("updated");
					request.setAttribute("sms","Updated Successfully");
					
				}
				
				RequestDispatcher rd1 = request.getRequestDispatcher("/Index.jsp");
				rd1.forward(request, response);
	         }
			
				
			
			
	     }
}
