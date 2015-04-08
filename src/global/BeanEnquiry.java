package global;

import java.io.Serializable;

public class BeanEnquiry implements Serializable{
 
	private int enquiryID;
	private String eqyDespt;
	private  String eqyNote;
	private String eqyDate;
	private int customerID;
	private int employeeID;
	
	public BeanEnquiry() {
		// TODO Auto-generated constructor stub
	}
	public BeanEnquiry( String eqyDs, String enqDt, int cID ){
		eqyDespt =eqyDs;
		eqyDate = enqDt;
		customerID = cID;
	}
	public BeanEnquiry(int id, String eqyDs, String enqDt, int cID ){
		enquiryID = id;
		eqyDespt =eqyDs;
		eqyDate = enqDt;
		customerID = cID;
	}
	public BeanEnquiry(int id, String note, int eID) {
		enquiryID = id;
		eqyNote = note;
		employeeID = eID;
	}

	public BeanEnquiry(int id, String eqyDs,String note, String enqDt, int cID, int eID) {
		enquiryID = id;
		eqyDespt =eqyDs;
		eqyNote = note;
		eqyDate = enqDt;
		customerID = cID;
		employeeID = eID;
	}
	public int getEnquiryID (){
		return enquiryID;
	}
	public void setEnquiryID(int enquiryID){
		this.enquiryID = enquiryID;
	}
	
	public String getEnqDescpt (){
		return eqyDespt;
	}
	public void setEnqDespt(String eqyDespt){
		this.eqyDespt = eqyDespt;
	}
	
	public String getEnqNote(){
		return eqyNote;
	}
	public void setEnqNote(String eqyNote){
		this.eqyNote = eqyNote;
	}
	
	public String getEnqDate(){
		return eqyDate;
	}
	public void setEnqDate (String enqDate){
		this.eqyDate = enqDate;
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
		return "BeanEnquiry [enquiryID=" + enquiryID + ", eqyDespt=" + eqyDespt
				+ ", eqyNote=" + eqyNote + ", eqyDate=" + eqyDate
				+ ", customerID=" + customerID + ", employeeID=" + employeeID
				+ "]";
	}
	
	
}
