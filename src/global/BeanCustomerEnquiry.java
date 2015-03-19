package global;

import java.io.Serializable;
/** 
 * Customer Bean
 */
public class BeanCustomerEnquiry implements Serializable {
	
	private int enquiryID;
	private String description;
	private String note;
	private String date;
	private int customerID;
	private int employeeID;
	
	//declare constructors
	public BeanCustomerEnquiry() {

	}

	public BeanCustomerEnquiry(int enqID, String desc, String notes, String enqDate, int custID, int empID) {
		enquiryID=enqID;
		description=desc;
		note=notes;
		date=enqDate;
		customerID=custID;
		employeeID=empID;
	}
	
	public BeanCustomerEnquiry(String desc, String notes, String enqDate,  int custID, int empID) {
		description=desc;
		note=notes;
		date=enqDate;
		customerID=custID;
		employeeID=empID;
	}
	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	public int getEnquiryID() {
		return enquiryID;
	}

	public void setEnquriyID(int enqID) {
		this.enquiryID=enqID;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description=desc;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String notes) {
		this.note=notes;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String enqDate) {
		this.date=enqDate;
	}
	public int getCustID() {
		return customerID;
	}

	public void setCustID(int custID) {
		this.customerID=custID;
	}
	
	public int getEmpID() {
		return employeeID;
	}

	public void setEmpID(int empID) {
		this.employeeID=empID;
	}

	@Override
	public String toString() {
		return "BeanCustomerEnquiry [enquiryID=" + enquiryID + ", description="
				+ description + ", note=" + note + ", date=" + date
				+ ", customerID=" + customerID + ", employeeID=" + employeeID
				+ "]";
	}
	
	
}
