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
					+ "empDOB, empStartDate, empRole, empSalary,  empEmail, empTel) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, e.getFirstName());
			ptmt.setString(2, e.getOtherName());
			ptmt.setString(3, e.getLastName());
			ptmt.setString(4, e.getDOB());
			ptmt.setString(5, e.getStartDate());
			ptmt.setString(6, e.getRole());
			ptmt.setFloat(7, e.getSalary());
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
	/**
	 * @return 
	 * view all the employee 
	 * 
	 */
	public ArrayList<BeanEmployee> viewAllEmp() {
		ArrayList<BeanEmployee> s = null;
		try {
			String queryString = "SELECT * from globel_employeeaccount" ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			s = new ArrayList<BeanEmployee>();
			while(rs1.next()) {
				BeanEmployee temp = new BeanEmployee();
				temp.setEmployeeID(rs1.getInt("employeeID"));
				temp.setFirstName(rs1.getString("empFirstname"));
				temp.setOtherName(rs1.getString("empOthername"));
				temp.setLastName(rs1.getString("empSurname"));
				temp.setDOB(rs1.getString("empDOB"));
				temp.setStartDate(rs1.getString("empStartDate"));
				temp.setRole(rs1.getString("empRole"));
				temp.setSalary(rs1.getFloat("empSalay"));
				temp.setEmailAddress(rs1.getString("empEmail"));
				temp.setTel(rs1.getString("empTel"));
				temp.setManagerID(rs1.getInt("managerID"));
				s.add(temp);

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
		return s;

	}
	
	
	public ArrayList<BeanEmployee> viewAllEmpDetail() {
		ArrayList<BeanEmployee> emp = null;
		try {
			String queryString = "SELECT employeeID, empFirstname, empSurname, empRole FROM global_employeeaccount" ;
			//String queryString = "SELECT employeeID, CONCAT(empFirstname,  '   ',empSurname) AS Name, empRole FROM global_employeeaccount" ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			emp = new ArrayList<BeanEmployee>();
			while(rs1.next()) {
				BeanEmployee temp = new BeanEmployee();
				temp.setEmployeeID(rs1.getInt("employeeID"));
				temp.setFirstName(rs1.getString("empFirstname"));
				temp.setLastName(rs1.getString("empSurname"));
				temp.setRole(rs1.getString("empRole"));
				emp.add(temp);

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
		return emp;

	}

	/**
	 * @param ID
	 * @return all employee details 
	 * this method finds customers by their ID
	 */
	public ArrayList<BeanEmployee> findEmpByID(int ID) {
		ArrayList<BeanEmployee> s = null;
		try {
			String queryString = "SELECT * from globel_employeeaccount where employeeID = "+ID+ "" ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			s = new ArrayList<BeanEmployee>();
			while(rs1.next()) {
				BeanEmployee temp = new BeanEmployee();
				temp.setEmployeeID(rs1.getInt("employeeID"));
				temp.setFirstName(rs1.getString("empFirstname"));
				temp.setOtherName(rs1.getString("empOthername"));
				temp.setLastName(rs1.getString("empSurname"));
				temp.setDOB(rs1.getString("empDOB"));
				temp.setStartDate(rs1.getString("empStartDate"));
				temp.setRole(rs1.getString("empRole"));
				temp.setSalary(rs1.getFloat("empSalay"));
				temp.setEmailAddress(rs1.getString("empEmail"));
				temp.setTel(rs1.getString("empTel"));
				temp.setManagerID(rs1.getInt("managerID"));
				s.add(temp);

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
		return s;

	}
	public BeanEmployee findEmpByEmailAndLastname(String email, String lastname){
		BeanEmployee c = null;
		try {
			String queryString = "SELECT * from global_employeeaccount WHERE empEmail ='"+email+"' AND empSurname='"+lastname+"'" ;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			c = new BeanEmployee();
			while(rs1.next()) {
				BeanEmployee temp = new BeanEmployee();
				temp.setEmployeeID(rs1.getInt("employeeID"));
				temp.setFirstName(rs1.getString("empFirstname"));
				temp.setOtherName(rs1.getString("empOthername"));
				temp.setLastName(rs1.getString("empSurname"));
				temp.setDOB(rs1.getString("empDOB"));
				temp.setStartDate(rs1.getString("empStartDate"));
				temp.setRole(rs1.getString("empRole"));
				temp.setSalary(rs1.getFloat("empSalary"));
				temp.setEmailAddress(rs1.getString("empEmail"));
				temp.setTel(rs1.getString("empTel"));
				c =temp;
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
