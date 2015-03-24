package unused;


import java.io.Serializable;
/** 
 * Attraction Type Bean
 */
public class BeanAttractionPriceList implements Serializable {

	private int attractionID;
	private int ticketTypeID;
	private double ticketPrice;
	//declare constructors
	public BeanAttractionPriceList() {

	}

	public BeanAttractionPriceList(int attID, int tktTypeID, double tktPrice) {
		attractionID = attID;
		ticketTypeID = tktTypeID;
		ticketPrice = tktPrice;
	}

	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	public int getAttractionID() {
		return attractionID;
	}

	public void setAttractionID(int attID) {
		this.attractionID= attID;
	}

	public int getTktTypeID() {
		return ticketTypeID;
	}

	public void setTktTypeID(int tktType) {
		this.ticketTypeID = tktType;
	}
	
	public double getTktPrice() {
		return ticketPrice;
	}

	public void setTktPrice(int tktPrice) {
		this.ticketPrice = tktPrice;
	}

	@Override
	public String toString() {
		return "BeanAttractionPriceList [attractionID=" + attractionID
				+ ", ticketTypeID=" + ticketTypeID + ", ticketPrice="
				+ ticketPrice + "]";
	}

}
