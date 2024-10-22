package in.mindprove.hotelmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.mindprove.hotelmanagement.dto.PaymentDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;

public class PaymentServices {
      Connection conn= databaseConnectionUtil.getConnection();
      public int MakePayment(PaymentDto payment) {
		int x = 0;

		try {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO paymentforhotel (cardholder_name,cardnumber,Expirydate,cvv,amount)values(?,?,?,?,?)");
			ps.setString(1, payment.getCardholder_name());
			ps.setString(2, payment.getCardnumber());
			ps.setString(3, payment.getExpirydate());
			ps.setString(4, payment.getCvv());
			ps.setString(5, payment.getAmount());
			;
			x = ps.executeUpdate();
			if (x > 0) {
				System.out.println(" payment Success");
			} else {
				System.out.println("Not success");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return 0;
	}

}
