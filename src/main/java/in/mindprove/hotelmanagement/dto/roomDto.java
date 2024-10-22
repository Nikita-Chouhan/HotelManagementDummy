package in.mindprove.hotelmanagement.dto;

public class roomDto {
	private int booking_id;
	private int user_id;
	private int hotel_id;
	private String roomnumber;
	private String capacity;
	private String checkin;
	private String checkout;

	public String getcapacity() {
		return capacity;
	}

	public String setcapacity(String capacity) {
		return this.capacity = capacity;
	}

	public String getcheckin() {
		return checkin;
	}

	public String setcheckin(String startdate) {
		return this.checkin = startdate;
	}

	public String getcheckout() {
		return checkout;
	}

	public String setcheckout(String lastdate) {
		return this.checkout = lastdate;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public String setRoomnumber(String string) {
		return this.roomnumber = string;
	}

	public int getUser_id() {
		return user_id;
	}

	public int setUser_id(int user_id) {
		return this.user_id = user_id;
	}

	public int getHotel_id() {
	    return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

}
