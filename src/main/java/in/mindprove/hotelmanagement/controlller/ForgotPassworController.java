package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;

import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.service.ForgotPasswordService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ForgotPassworController")
public class ForgotPassworController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Userdto userdto = new Userdto();
		userdto.setemail(request.getParameter("email"));
		userdto.setpassword(request.getParameter("password"));

		ForgotPasswordService forgot = new ForgotPasswordService();
		int z = forgot.updatePassword(userdto);
		if (z > 0) {
			System.out.println("updated");
			request.setAttribute("sms", "Updated Successfully");
		}
		RequestDispatcher rd1 = request.getRequestDispatcher("/Index.jsp");
		try {
			rd1.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
