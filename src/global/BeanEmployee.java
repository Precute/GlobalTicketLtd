package global;

import java.io.Serializable;
/** 
 * Customer Bean
 */
public class BeanEmployee implements Serializable {
	
	private int customerID;
	private String firstName;
	private String otherName;
	private String lastName;
	private String address;
	private String postcode;
	private String city;
	private String country;
	private String DOB;
	private String email;
	private String tel;
	private String mob;
	//declare constructors
	public BeanEmployee() {

	}

	public BeanEmployee(int custID, String fName, String oName, String lName, String cAddress, String cPostcode, String cCity, String cCountry, String cDOB, String cEmail, String cTel, String cMob) {
		customerID=custID;
		firstName=fName;
		otherName=oName;
		lastName=lName;
		address=cAddress;
		postcode=cPostcode;
		city=cCity;
		country=cCountry;
		DOB=cDOB;
		email=cEmail;
		tel=cTel;
		mob=cMob;
	}
	
	public BeanEmployee(String fName, String oName, String lName, String cAddress, String cPostcode, String cCity, String cCountry, String cDOB, String cEmail, String cTel, String cMob) {
		firstName=fName;
		otherName=oName;
		lastName=lName;
		address=cAddress;
		postcode=cPostcode;
		city=cCity;
		country=cCountry;
		DOB=cDOB;
		email=cEmail;
		tel=cTel;
		mob=cMob;
	}
	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	
	public int getCustID() {
		return customerID;
	}

	public void setCustID(int custID) {
		this.customerID=custID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String oName) {
		this.otherName = oName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String cAddress) {
		this.address = cAddress;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String custCity) {
		this.city = custCity;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String cCountry) {
		this.country = cCountry;
	}
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String pcode) {
		this.postcode = pcode;
	}
	
	public String getEmailAddress() {
		return email;
	}

	public void setEmailAddress(String email) {
		this.email = email;
	}
	
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String cDOB) {
		this.DOB = cDOB;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String cTel) {
		this.tel = cTel;
	}
	
	public String getMob() {
		return mob;
	}

	public void setMob(String cMob) {
		this.mob = cMob;
	}

	@Override
	public String toString() {
		return "BeanCustomer [customerID=" + customerID + ", firstName="
				+ firstName + ", otherName=" + otherName + ", lastName="
				+ lastName + ", address=" + address + ", postcode=" + postcode
				+ ", city=" + city + ", country=" + country + ", DOB=" + DOB
				+ ", email=" + email + ", tel=" + tel + ", mob=" + mob + "]";
	}

	
}
