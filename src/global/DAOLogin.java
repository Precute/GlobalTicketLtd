package global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/** 
 * DAO for user management
 */
public class DAOLogin {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;
	//declare constructor
	public DAOLogin() {

	}
	//make connection to object
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	//add user to the database
	public void addUser(BeanLogin usr) {
		try {
			String queryString = "INSERT INTO user_reg(id, username, password, usertype) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, usr.getID());
			ptmt.setString(2, usr.getUsername());
			ptmt.setString(3, usr.getPassword());
			ptmt.setString(4, usr.getUserType());
			ptmt.executeUpdate();
			System.out.println("Login Data Added Successfully");
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
	//validate user when logging in using boolean value
	public boolean validateLogin(String username,String password) {
		boolean status = false;
		try {
			String queryString = "SELECT * FROM user_reg WHERE username=? AND password=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, username);
			ptmt.setString(2, password);

			ResultSet rs= ptmt.executeQuery();
			
			status=rs.next();
			
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
		return status;
	}
	//retrieve the login details based on username and password 
	public BeanLogin retrieveUser (String username,String password) {
		BeanLogin usr = null;
		try {
			String queryString = "SELECT * FROM user_reg WHERE username=? AND password=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, username);
			ptmt.setString(2, password);

			ResultSet rs= ptmt.executeQuery();
			usr = new BeanLogin();
			if(rs.next()){
				BeanLogin temp = new BeanLogin();
				temp.setID(rs.getInt("id"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setUserType(rs.getString("usertype"));
				usr=temp;
			}
			
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
		return usr;
	}
	//retrieve user by username to access the user id
	public BeanLogin retrieveUserByUsername (String username) {
		BeanLogin usr = null;
		try {
			String queryString = "SELECT * FROM user_reg WHERE username=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, username);

			ResultSet rs= ptmt.executeQuery();
			usr = new BeanLogin();
			if(rs.next()){
				BeanLogin temp = new BeanLogin();
				temp.setID(rs.getInt("id"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setUserType(rs.getString("usertype"));
				usr=temp;
			}
			
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
		return usr;
	}
	
}
