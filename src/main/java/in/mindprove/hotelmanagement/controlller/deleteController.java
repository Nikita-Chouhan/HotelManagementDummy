package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import java.sql.Connection;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.service.deleteSevice;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteServices")
public class deleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		roomDto u = new roomDto();
		u.setRoomnumber(request.getParameter("totalroom"));
//		u.setcapacity(request.getParameter("t2"));
//		u.setcheckin(request.getParameter("t3"));
//		u.setcheckout(request.getParameter("t4"));
		deleteSevice delete= new deleteSevice();
        String action = request.getParameter("action");
        if("Delete".equals(action)){
    		int y=delete.delete(u);
    		String target1="";
    		if(y>=1)
    		{
    			request.setAttribute("sms","Deleted Successfully");
    			target1="/Index.jsp";
    	
    		}
    		RequestDispatcher rd2 = request.getRequestDispatcher(target1);
    		rd2.forward(request, response);
    		}
}

	
}
