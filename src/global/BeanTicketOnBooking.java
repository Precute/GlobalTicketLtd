package global;

import java.io.Serializable;


public class BeanTicketOnBooking implements Serializable {
private int bookingID;
private int attractionID;
private int tktTypeID;
private String ticketDate;
private int ticketQty;
private Double tktTotalCost;

	public BeanTicketOnBooking() {
		// TODO Auto-generated constructor stub
	}

	public BeanTicketOnBooking( int bID, int aID, int tID, String tDate,
	int tQty, Double tCost) {
		// TODO Auto-generated constructor stub
		bookingID = bID;
		attractionID = aID;
		tktTypeID = tID;
		ticketDate = tDate;
		ticketQty = tQty;
		tktTotalCost = tCost;
	}
	public int getBookingID(){
		return bookingID;
	}
	public void setBookingID(int bookingID){
		this.bookingID = bookingID;
	}
	public int getAttractionID(){
		return attractionID;
	}
	public void setAttractionID( int attractionID){
		this.attractionID = attractionID;
	}
	public int getTktTypeID(){
		return tktTypeID;
	}
	public void setTktTypeID( int tktTypeID){
		this.tktTypeID = tktTypeID;
	}
	public String getTicketDate(){
		return ticketDate;
	}
	public void setTicketDate( String ticketDate){
		this.ticketDate = ticketDate;
	}
	public int getTicketQty(){
		return ticketQty;
	}
	public void setTicketQty( int ticketQty){
		this.ticketQty = ticketQty;
	}
	public Double getTktTotalCost(){
		return tktTotalCost;
	}
	public void setTktTotalCost(Double tktTotalCost){
		this.tktTotalCost = tktTotalCost;
	}

	@Override
	public String toString() {
		return "BeanTicketOnBooking [bookingID=" + bookingID
				+ ", attractionID=" + attractionID + ", tktTypeID=" + tktTypeID
				+ ", ticketDate=" + ticketDate + ", ticketQty=" + ticketQty
				+ ", tktTotalCost=" + tktTotalCost + "]";
	}
	
}

