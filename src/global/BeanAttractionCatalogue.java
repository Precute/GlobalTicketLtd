package global;

import java.io.Serializable;


public class BeanAttractionCatalogue implements Serializable{
	private int attractionID;
	private String attName;
	private String attDescript;
	private int attAvailabilityCount;
	private int attTypeID;
	private int locationID;

	public BeanAttractionCatalogue() {
		// TODO Auto-generated constructor stub
	}
	public BeanAttractionCatalogue(int atID, String aName, String aDscript, int aAvalCt, int aTypeID, int locID) {
		// TODO Auto-generated constructor stub
		attractionID = atID;
		attName  = aName;
		attDescript = aDscript;
		attAvailabilityCount = aAvalCt;
		attTypeID = aTypeID;
		locationID = locID;
	}
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
	public String AttDescript (){
		return attDescript;
	}
	public void setAttDescript(String attDescript){
		this.attDescript = attDescript;
	}
	public int getAttAvailabilityCount(){
		return attAvailabilityCount;	
	}
	public void setAttAvailabilityCount(int attAvailabilityCount){
		this.attAvailabilityCount = attAvailabilityCount;
	}
	public int getAttTypeID(){
		return attTypeID;
	}
	public void setAttTypeID(int attTypeID){
		this.attTypeID = attTypeID;
	}
	public int getLocationID(){
		return locationID;
	}
	public void setLocationID (int locationID){
		this.locationID = locationID;
	}
	@Override
	public String toString() {
		return "BeanAttractionCatalogue [attractionID=" + attractionID
				+ ", attName=" + attName + ", attDescript=" + attDescript
				+ ", attAvailabilityCount=" + attAvailabilityCount
				+ ", attTypeID=" + attTypeID + ", locationID=" + locationID
				+ "]";
	}
	
}
