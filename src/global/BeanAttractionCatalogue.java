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


}
