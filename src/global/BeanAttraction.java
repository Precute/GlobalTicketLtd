package global;

import java.io.Serializable;


public class BeanAttraction implements Serializable{
	private int attractionID;
	private String attName;
	private String attDescript;
	private String attFullDescript;
	private int attAvailabilityCount;
	
	private int locationID;
	private String city;
	private String country;
	
	private double ticketPrice;
	
	private int attTypeID;
	private String attType;
	
	private int ticketTypeID;
	private String tktType;
	
	public BeanAttraction() {
		// blank
	}
	public BeanAttraction(int attTypeID, String typeNme) {
		//for attrtype
		this.attTypeID = attTypeID;
		attType = typeNme;
	}
	public BeanAttraction(int attID, int tktTypeID, double tktPrice) {
		//for attractionpricelist
		attractionID = attID;
		ticketTypeID = tktTypeID;
		ticketPrice = tktPrice;
	}
	public BeanAttraction(String typeNme, int typeID) {
		//for tickettype
		ticketTypeID = typeID;
		tktType = typeNme;
	}

	public BeanAttraction(int atID, String aName, String aDscript, String aFullDescript, int aAvalCt, int aTypeID, int locID) {
		// for catalogue
		attractionID = atID;
		attName  = aName;
		attDescript = aDscript;
		attFullDescript=aFullDescript;
		attAvailabilityCount = aAvalCt;
		attTypeID = aTypeID;
		locationID = locID;
	}
	
	public BeanAttraction( String aName, String aDscript, String aFullDescript, int aAvalCt, int aTypeID, int locID) {
		// for catalogue
		attName  = aName;
		attDescript = aDscript;
		attFullDescript=aFullDescript;
		attAvailabilityCount = aAvalCt;
		attTypeID = aTypeID;
		locationID = locID;
	}
	
	public BeanAttraction(int locationID, String locCity, String locCountry) {
		this.locationID = locationID;
		city = locCity;
		country = locCountry;
	}
	
	//for att catalogue
	public int getAttractionID (){
		return attractionID;
	}
	public void setAttractionID (int attractionID){
		this.attractionID = attractionID;
	}
	
	public String getAttName (){
		return attName;
	}
	public void setAttName(String attName){
		this.attName = attName;
	}
	
	public String getAttDescript (){
		return attDescript;
	}
	public void setAttDescript(String attDescript){
		this.attDescript = attDescript;
	}
	
	public String getAttFullDescript (){
		return attFullDescript;
	}
	public void setAttFullDescript(String attFDescript){
		this.attFullDescript = attFDescript;
	}
	
	public int getAttAvailabilityCount(){
		return attAvailabilityCount;	
	}
	public void setAttAvailabilityCount(int attAvailabilityCount){
		this.attAvailabilityCount = attAvailabilityCount;
	}

	
	//bean pricelist
	public double getTktPrice() {
		return ticketPrice;
	}
	public void setTktPrice(double tktPrice) {
		this.ticketPrice = tktPrice;
	}

	//bean att Type
	public int getAttTypeID() {
		return attTypeID;
	}
	public void setAttTypeID(int typeID) {
		this.attTypeID = typeID;
	}

	public String getAttType() {
		return attType;
	}
	public void setAttType(String type) {
		this.attType = type;
	}
	
	//bean tkt type
	public int getTicketTypeID() {
		return ticketTypeID;
	}
	public void setTktTypeID(int typeID) {
		this.ticketTypeID = typeID;
	}

	public String getTicketType() {
		return tktType;
	}
	public void setTicketType(String type) {
		this.tktType = type;
	}

	//for bean location
	public int getLocationID(){
		return locationID;
	}
	public void setLocationID (int locationID){
		this.locationID = locationID;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String locCity) {
		this.city = locCity;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String locCountry) {
		this.country = locCountry;
	}
	
	@Override
	public String toString() {
		return "BeanAttraction [attractionID=" + attractionID + ", attName="
				+ attName + ", attDescript=" + attDescript
				+ ", attAvailabilityCount=" + attAvailabilityCount
				+ ", locationID=" + locationID + ", city=" + city
				+ ", country=" + country + ", ticketPrice=" + ticketPrice
				+ ", attTypeID=" + attTypeID + ", attType=" + attType
				+ ", ticketTypeID=" + ticketTypeID + ", tktType=" + tktType
				+ "]";
	}

}
