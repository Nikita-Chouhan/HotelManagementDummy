package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.service.UserService;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Userdto u = new Userdto();
		
		u.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		u.setname(request.getParameter("name"));
		u.setemail(request.getParameter("email"));
		u.setAddress(request.getParameter("address"));
		u.setcontactnumber(request.getParameter("contact"));
		u.setpassword(request.getParameter("password"));
		u.setRole(request.getParameter("role"));

//		boolean isError = false;
//		if(name==null || name.trim().length()==0) {
//			isError = true;
//		}
//		
//		if(email == null || email.trim().length()==0)
//		{
//		    isError=true;	
//		}
//		if( password == null || password.trim().length()==0)
//		{
//		    isError=true;	
//		}
//		if(confirm_password == null || confirm_password.trim().length()==0 || confirm_password!=password)
//		{
//		    isError=true;	
//		}
//		RequestDispatcher rd= null;
//	    if(isError==true)
//	    {
//	    	rd=request.getRequestDispatcher("Signup.jsp");
//	    }
//	    else {
		UserService db = new UserService();
		int x = db.saveSignUpInfo(u);
		String target = "";

		if (x >= 1) {
			request.setAttribute("sms", "Signup Successfully");
			target = "/Index.jsp";
		} else {
			request.setAttribute("sms", "Invalid Username/Password");
			target = "/Login.jsp";
		}
		// RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("user_id", u.getUser_id());
	}
//	public int autoGenerate() {
//	    int Id =0;
//
//	    try (Connection con = databaseConnectionUtil.getConnection()) {
//	        con.setAutoCommit(false);
//	        
//	        String selectQuery = "SELECT MAX(Id) FROM user"; 
//	        try (PreparedStatement ps = con.prepareStatement(selectQuery);
//	             ResultSet rs = ps.executeQuery()) {
//
//	            if (rs.next()) {
//	                int maxId = rs.getInt(1);
//	                if (maxId > 0) {
//	                    Id = maxId + 1;
//	                }
//	            }
//	        }
//	        
//	        // Commit transaction
//	        con.commit();
//	        
//	    } catch (Exception e) {
//	        e.printStackTrace(); // Consider using a proper logger instead of printing the stack trace
//	    }
//
//	    return Id;
//	}

}
