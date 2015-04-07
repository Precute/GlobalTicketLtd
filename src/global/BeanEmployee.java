package global;

import java.io.Serializable;
/** 
 * Customer Bean
 */
public class BeanEmployee implements Serializable {
	
	private int employeeID;
	private String firstName;
	private String otherName;
	private String lastName;
	private String DOB;
	private String startDate;
	private float salary;
	private String email;
	private String tel;
	private String role;
	private int managerID;
	private String manManagerID;
	private String manFirstName;
	private String manLastName;
	//declare constructors
	public BeanEmployee() {

	}

	public BeanEmployee(int employeeID, String fName, String oName, String lName, String DOB, String startDate, float salary, String email, String tel, String role, int managerID) {
		this.employeeID=employeeID;
		firstName=fName;
		otherName=oName;
		lastName=lName;
		this.DOB=DOB;
		this.startDate=startDate;
		this.salary=salary;
		this.email=email;
		this.tel=tel;
		this.role=role;
		this.managerID=managerID;
	}
	
	public BeanEmployee(String fName, String oName, String lName, String DOB, String startDate, float salary, String email, String tel, String role, int managerID) {
		firstName=fName;
		otherName=oName;
		lastName=lName;
		this.DOB=DOB;
		this.startDate=startDate;
		this.salary=salary;
		this.email=email;
		this.tel=tel;
		this.role=role;
		this.managerID=managerID;
	}
	public BeanEmployee(String fName, String oName, String lName, String DOB, String startDate, float salary, String email, String tel, String role) {
		firstName=fName;
		otherName=oName;
		lastName=lName;
		this.DOB=DOB;
		this.startDate=startDate;
		this.salary=salary;
		this.email=email;
		this.tel=tel;
		this.role=role;
	}
	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	
	public int getEmpID() {
		return employeeID;
	}

	public void setEmployeeID(int empID) {
		this.employeeID=empID;
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
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
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
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getManFirstName() {
		return manFirstName;
	}

	public void setManFirstName(String fName) {
		this.manFirstName = fName;
	}


	public String getManLastName() {
		return manLastName;
	}

	public void setManLastName(String lName) {
		this.manLastName = lName;
	}
	@Override
	public String toString() {
		return "BeanEmployee [employeeID=" + employeeID + ", firstName="
				+ firstName + ", otherName=" + otherName + ", lastName="
				+ lastName + ", DOB=" + DOB + ", startDate=" + startDate
				+ ", salary=" + salary + ", email=" + email + ", tel=" + tel
				+ ", role=" + role + ", managerID=" + managerID + "]";
	}

}
