package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/** Class that makes connection to the database
 */
public class ConnectionFactory {
	 //declare database information
	String driverClassName = "com.mysql.jdbc.Driver";
	String dBase = "arpalikh"; // Name of database
	String dbUser = "arpalikh"; //
	String dbPwd = "queonitH8";
	String connectionUrl = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk/" + dBase; 
	
	/*//declare database information
	String driverClassName = "com.mysql.jdbc.Driver";
	String dBase = "arpalikh"; // Name of database
	String dbUser = "root"; //
	String dbPwd = "password";
	String connectionUrl = "jdbc:mysql://localhost:3306/" + dBase;*/
	
	private static ConnectionFactory connectionFactory = null;
	//declare constructor
	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//get the connection using declared variables
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
