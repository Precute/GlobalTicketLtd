package global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEnquiry {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;
	
	public DAOEnquiry() {
		// TODO Auto-generated constructor stub
		
	}
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public ArrayList<BeanEnquiry> viewAllEnquiry() {
		ArrayList<BeanEnquiry> e = null;
		try {
			String queryString = "SELECT * from global_customerenquiry";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			e = new ArrayList<BeanEnquiry>();
			while(rs1.next()) {
				BeanEnquiry enq = new BeanEnquiry();
				enq.setEnquiryID(rs1.getInt("enquiryID"));
				enq.setEnqDespt(rs1.getString("eqyDescription"));
				enq.setEnqNote(rs1.getString("eqyNote"));
				enq.setEnqDate(rs1.getString("eqyDate"));
				enq.setCustID(rs1.getInt("customerID"));
				enq.setEmpID(rs1.getInt("employeeID"));
				e.add(enq);
			}
		
	} catch (SQLException c) {
		c.printStackTrace();
	} finally {
		try {
			if (rs1 != null)
				rs1.close();
			if (ptmt != null)
				ptmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException c) {
			c.printStackTrace();
		} catch (Exception c) {
			c.printStackTrace();
		}

	}
	return e;
}
	
	
}
