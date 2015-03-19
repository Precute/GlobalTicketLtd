package global;

import java.io.Serializable;
/** 
 * User Registration bean
 */
public class BeanLogin implements Serializable {

	private int ID;
	private String userName;
	private String password;
	private String userType;
	//declare constructors
	public BeanLogin() {

	}

	public BeanLogin(int Id, String usrName, String pWord, String usrType) {
		ID=Id;
		userName=usrName;
		password=pWord;
		userType=usrType;
	}
	
	public BeanLogin(String usrName, String pWord) {
		userName=usrName;
		password=pWord;
		
	}

	/*
	 * define all getters and setters here for each instance variable also a
	 * toString method
	 */
	
	public int getID() {
		return ID;
	}

	public void setID(int Id) {
		this.ID=Id;
	}
	
	public String getUsername() {
		return userName;
	}

	public void setUsername(String usrName) {
		this.userName = usrName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String pWord) {
		this.password = pWord;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String usrType) {
		this.userType = usrType;
	}

	public String toString() {
		return "BeanUserReg [ID=" + ID + ", userName=" + userName
				+ ", password=" + password + ", userType=" + userType + "]";
	}

	
}
