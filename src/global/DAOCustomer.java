package global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCustomer {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public DAOCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	public void add(BeanCustomer c) {
		try {
			String queryString = "INSERT INTO global_customeraccount(custFirstname, custOthername, custSurname, custAddress, "
					+ "custPCode, custCity, custCountry, custDOB, custEmail, custTel, custMob) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, c.getFirstName());
			ptmt.setString(2, c.getOtherName());
			ptmt.setString(3, c.getLastName());
			ptmt.setString(4, c.getAddress());
			ptmt.setString(5, c.getPostcode());
			ptmt.setString(6, c.getCity());
			ptmt.setString(7, c.getCountry());
			ptmt.setString(8, c.getDOB());
			ptmt.setString(9, c.getEmailAddress());
			ptmt.setString(10, c.getTel());
			ptmt.setString(11, c.getMob());
			ptmt.executeUpdate();
			//System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public ArrayList<BeanCustomer> viewAlCustomer() {
		ArrayList<BeanCustomer> c = null;
		try {
			String queryString = "SELECT * from globel_customeraccount";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			c = new ArrayList<BeanCustomer>();
			while(rs1.next()) {
				BeanCustomer temp = new BeanCustomer();
				temp.setCustID(rs1.getInt("customerID"));
				temp.setFirstName(rs1.getString("custFirstname"));
				temp.setOtherName(rs1.getString("custOthername"));
				temp.setLastName(rs1.getString("custSurname"));
				temp.setAddress(rs1.getString("custAddress"));
				temp.setPostcode(rs1.getString("custPCode"));
				temp.setCity(rs1.getString("custCity"));
				temp.setCountry(rs1.getString("custCuntry"));
				temp.setDOB(rs1.getString("custDOB"));
				temp.setEmailAddress(rs1.getString("custEmail"));
				temp.setTel(rs1.getString("custTel"));
				temp.setMob(rs1.getString("custMob"));
				c.add(temp);

			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return c;

	}
	
	
	/**
	 * @param ID id the customer ID
	 * @return its returns the details of of the customer 
	 * this is used to view customer by their ID
	 */
	public ArrayList<BeanCustomer> viewCustByID(int ID) {
		ArrayList<BeanCustomer> c = null;
		try {
			String queryString = "SELECT * from globel_customeraccount where customerID like '%"+ID+"%' " ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			c = new ArrayList<BeanCustomer>();
			while(rs1.next()) {
				BeanCustomer temp = new BeanCustomer();
				temp.setCustID(rs1.getInt("customerID"));
				temp.setFirstName(rs1.getString("custFirstname"));
				temp.setOtherName(rs1.getString("custOthername"));
				temp.setLastName(rs1.getString("custSurname"));
				temp.setAddress(rs1.getString("custAddress"));
				temp.setPostcode(rs1.getString("custPCode"));
				temp.setCity(rs1.getString("custCity"));
				temp.setCountry(rs1.getString("custCuntry"));
				temp.setDOB(rs1.getString("custDOB"));
				temp.setEmailAddress(rs1.getString("custEmail"));
				temp.setTel(rs1.getString("custTel"));
				temp.setMob(rs1.getString("custMob"));
				c.add(temp);

			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return c;

	}
	
	/**
	 * @param email
	 * @return
	 * this method view or find a customer with
	 * their email address
	 */
	public ArrayList<BeanCustomer> viewCustByEmail(String email) {
		ArrayList<BeanCustomer> c = null;
		try {
			String queryString = "SELECT * from globel_customeraccount where custEmail like '%"+email+"%' " ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			c = new ArrayList<BeanCustomer>();
			while(rs1.next()) {
				BeanCustomer temp = new BeanCustomer();
				temp.setCustID(rs1.getInt("customerID"));
				temp.setFirstName(rs1.getString("custFirstname"));
				temp.setOtherName(rs1.getString("custOthername"));
				temp.setLastName(rs1.getString("custSurname"));
				temp.setAddress(rs1.getString("custAddress"));
				temp.setPostcode(rs1.getString("custPCode"));
				temp.setCity(rs1.getString("custCity"));
				temp.setCountry(rs1.getString("custCuntry"));
				temp.setDOB(rs1.getString("custDOB"));
				temp.setEmailAddress(rs1.getString("custEmail"));
				temp.setTel(rs1.getString("custTel"));
				temp.setMob(rs1.getString("custMob"));
				c.add(temp);

			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return c;

	}
	
	/**
	 * @param surname
	 * @return
	 * this is to view a customer by their surname
	 */
	public ArrayList<BeanCustomer> viewCustBySurname(String surname) {
		ArrayList<BeanCustomer> c = null;
		try {
			String queryString = "SELECT * from globel_customeraccount where custSurname like '%"+surname+"%' " ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			c = new ArrayList<BeanCustomer>();
			while(rs1.next()) {
				BeanCustomer temp = new BeanCustomer();
				temp.setCustID(rs1.getInt("customerID"));
				temp.setFirstName(rs1.getString("custFirstname"));
				temp.setOtherName(rs1.getString("custOthername"));
				temp.setLastName(rs1.getString("custSurname"));
				temp.setAddress(rs1.getString("custAddress"));
				temp.setPostcode(rs1.getString("custPCode"));
				temp.setCity(rs1.getString("custCity"));
				temp.setCountry(rs1.getString("custCuntry"));
				temp.setDOB(rs1.getString("custDOB"));
				temp.setEmailAddress(rs1.getString("custEmail"));
				temp.setTel(rs1.getString("custTel"));
				temp.setMob(rs1.getString("custMob"));
				c.add(temp);

			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return c;
	}
}
