package global;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOAttraction {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public DAOAttraction() {

	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
}
