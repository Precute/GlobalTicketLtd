package global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEmployee {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public DAOEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/**
	 * @param e is the the employee bean 
	 * this method is used to insert a new employee to the 
	 * database from the user interface
	 */
	public void add(BeanEmployee e) {
		try {
			String queryString = "INSERT INTO global_employeeaccount(empFirstname, empOthername, empSurname, "
					+ "empDOB, empStartDate, empRole, empSalary,  custEmail, custTel) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, e.getFirstName());
			ptmt.setString(2, e.getOtherName());
			ptmt.setString(3, e.getLastName());
			ptmt.setString(4, e.getDOB());
			ptmt.setString(5, e.getStartDate());
			ptmt.setString(6, e.getRole());
			ptmt.setDouble(7, e.getSalary());
			ptmt.setString(8, e.getEmailAddress());
			ptmt.setString(9, e.getTel());
			ptmt.executeUpdate();
			//System.out.println("Data Added Successfully");
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (Exception s) {
				s.printStackTrace();
			}

		}

	}


}
