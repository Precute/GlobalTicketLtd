package global;


import java.io.Serializable;
/** 
 * Attraction Type Bean
 */
public class BeanAttractionType implements Serializable {

	private int id;
	private String type;
	//declare constructors
	public BeanAttractionType() {

	}

	public BeanAttractionType(int typeID, String typeNme) {
		id = typeID;
		type = typeNme;
	}

	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	public int getID() {
		return id;
	}

	public void setID(int typeID) {
		this.id = typeID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BeanAttractionType [id=" + id + ", type=" + type + "]";
	}

}
