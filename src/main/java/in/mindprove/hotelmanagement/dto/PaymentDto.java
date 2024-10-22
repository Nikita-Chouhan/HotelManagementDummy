package in.mindprove.hotelmanagement.dto;
public class PaymentDto {
     private String cardholder_name;
     private String cardnumber;
     private String Expirydate;
     private String cvv;
     private String amount;
	public String getCardholder_name() {
		return cardholder_name;
	}
	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getExpirydate() {
		return Expirydate;
	}
	public void setExpirydate(String expirydate) {
		Expirydate = expirydate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
     
}
