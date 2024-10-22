package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;

import in.mindprove.hotelmanagement.dto.PaymentDto;
import in.mindprove.hotelmanagement.service.PaymentServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		{
			PaymentDto payment= new PaymentDto();
			payment.setCardholder_name(request.getParameter("cardholderName"));
			payment.setCardnumber(request.getParameter("cardNumber"));
			payment.setExpirydate(request.getParameter("expiryDate"));
			payment.setAmount(request.getParameter("cvv"));
			payment.setCvv(request.getParameter("amount"));
			
			PaymentServices Paymentservices= new PaymentServices();
			int x = Paymentservices.MakePayment(payment);
			if (x >= 1) {
				request.setAttribute("", "Payment Successfull");
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);
	}
		
	}
	