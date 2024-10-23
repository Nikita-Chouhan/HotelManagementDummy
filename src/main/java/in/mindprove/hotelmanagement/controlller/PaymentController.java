package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import java.util.regex.Pattern;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve input values
		String cardholderName = request.getParameter("cardholderName");
		String cardNumber = request.getParameter("cardNumber");
		String expiryDate = request.getParameter("expiryDate");
		String cvv = request.getParameter("cvv");
		String amount = request.getParameter("amount");
		
		// Validation flags
		boolean isError = false;
		StringBuilder errorMessages = new StringBuilder();
		
		// Basic validation rules
		if (cardholderName == null || cardholderName.isEmpty()) {
			isError = true;
			request.setAttribute("cardholdernameerror","Cardholder name is required. ");
		}
		if (cardNumber == null || !isValidCardNumber(cardNumber)) {
			isError = true;
			request.setAttribute("cardNumbererror","Invalid card number. ");
		}
		if (expiryDate == null || !isValidExpiryDate(expiryDate)) {
			isError = true;
			request.setAttribute("expiryDateerror","Invalid expiry date. ");
		}
		if (cvv == null || !isValidCVV(cvv)) {
			isError = true;
			request.setAttribute("cvverrror","Invalid CVV. ");
		}
		if (amount == null || !isValidAmount(amount)) {
			isError = true;
			request.setAttribute("amounterror","Invalid amount. ");
		}
		RequestDispatcher rd = null;

		if (isError==true){
			rd=request.getRequestDispatcher("payment.jsp");
			request.setAttribute("error", errorMessages.toString());

		}
		else {

			PaymentDto payment = new PaymentDto();
			payment.setCardholder_name(cardholderName);
			payment.setCardnumber(cardNumber);
			payment.setExpirydate(expiryDate);
			payment.setAmount(amount);
			payment.setCvv(cvv);
			
			// Process the payment
			PaymentServices paymentServices = new PaymentServices();
			int x = paymentServices.MakePayment(payment);
			if (x >= 1) {
				request.setAttribute("message", "Payment Successful");
			} else {
				request.setAttribute("message", "Payment Failed");
			}
			rd=request.getRequestDispatcher("payment.jsp");

		}
		
		rd.forward(request,response);

	}
	private boolean isValidCardNumber(String cardNumber) {
		return Pattern.matches("\\d{16}", cardNumber);
	}

	private boolean isValidExpiryDate(String expiryDate) {
		return Pattern.matches("(0[1-9]|1[0-2])/\\d{2}", expiryDate);
	}
	
	private boolean isValidCVV(String cvv) {
		return Pattern.matches("\\d{3}", cvv);
	}
	
	private boolean isValidAmount(String amount) {
		try {
			double amt = Double.parseDouble(amount);
			return amt > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
