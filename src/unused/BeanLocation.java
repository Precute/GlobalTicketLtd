package unused;


import java.io.Serializable;
/** 
 * Attraction Type Bean
 */
public class BeanLocation implements Serializable {

	private int id;
	private String city;
	private String country;
	//declare constructors
	public BeanLocation() {

	}

	public BeanLocation(int locationID, String locCity, String locCountry) {
		id = locationID;
		city = locCity;
		country = locCountry;
	}

	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	public int getID() {
		return id;
	}

	public void setID(int locationID) {
		this.id = locationID;
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
		return "BeanLocation [id=" + id + ", city=" + city + ", country="
				+ country + "]";
	}


}
