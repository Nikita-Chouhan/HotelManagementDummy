package in.mindprove.hotelmanagement.dto;

public class HotelDto {


    private int hotel_id;
    private String hotelname;
    private String hotellocation;
    private String hoteltype;
    private String hotelpayment;
    private String totalrooms;
	
	public String gethotelname() {
		return hotelname;
	}
	public String sethotelname(String hotelname) {
		return this.hotelname = hotelname;
	}
	public String getHoteltype() {
		return hoteltype;
	}
	public String setHoteltype(String hoteltype) {
		return this.hoteltype = hoteltype;
	}
	public String getHotellocation() {
		return hotellocation;
	}
	public String setHotellocation(String hotellocation) {
		return this.hotellocation = hotellocation;
	}
	
	public int getHotel_id() {
	    return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotelPayment() {
		return hotelpayment;
	}
	public String setHotelPayment(String hotelPayment) {
		return hotelpayment = hotelPayment;
	}
	public String getTotalrooms() {
		return totalrooms;
	}
	public String setTotalrooms(String totalrooms) {
		return this.totalrooms = totalrooms;
	}

  
}
