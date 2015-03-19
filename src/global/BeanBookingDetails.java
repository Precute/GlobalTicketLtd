package global;


import java.io.Serializable;
/** 
 * Attraction Type Bean
 */
public class BeanBookingDetails implements Serializable {

	private int bookingID;
	private String date;
	private double totalCost;
	private int customerID;
	//declare constructors
	public BeanBookingDetails() {

	}

	public BeanBookingDetails(int bID, String date, double totalCost, int custID) {
		bookingID=bID;
		this.date=date;
		this.totalCost=totalCost;
		customerID=custID;
	}
	public BeanBookingDetails(String date, double totalCost, int custID) {
		this.date=date;
		this.totalCost=totalCost;
		customerID=custID;
	}
	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bID) {
		this.bookingID= bID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int tCost) {
		this.totalCost = tCost;
	}

	public int getCustID() {
		return customerID;
	}

	public void setCustID(int custID) {
		this.customerID= custID;
	}

	@Override
	public String toString() {
		return "BeanBookingDetails [bookingID=" + bookingID + ", date=" + date
				+ ", totalCost=" + totalCost + ", customerID=" + customerID
				+ "]";
	}

}
