package global;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/** 13153439 Huseyin Arpalikli
 * DAO for orders
 */
public class DAOBooking {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public DAOBooking() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	//add order details to database
	public void addDetails(BeanBookingDetails det) {
		try {
			String queryString = "INSERT INTO global_bookingdetails(bookingdate, customer_id) VALUES(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, det.getDate());
			ptmt.setInt(2, det.getCustID());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
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
	//add order line to database
	public void addLine(BeanTicketOnBooking line) {
		try {
			String queryString = "INSERT INTO global_ticketonbooking(bookingid, attractionid, tkttypeid, ticketdate, ticketqty, tkttotalcost) VALUES(?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, line.getBookingID());
			ptmt.setInt(2, line.getAttractionID());
			ptmt.setInt(3, line.getTktTypeID());
			ptmt.setString(4, line.getTicketDate());
			ptmt.setInt(5, line.getTicketQty());
			ptmt.setFloat(6, line.getTktTotalCost());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
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

	//find order by date and customer id
	public BeanBookingDetails findOrderByDateAndCustID(String date, int custID) {
		BeanBookingDetails det = null;
		try {
			String queryString = "SELECT * FROM order_details WHERE customer_id = "+custID+" AND date(order_date)= '"+date+"' ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			det = new BeanBookingDetails();
			if(rs1.next()) {
				BeanBookingDetails temp = new BeanBookingDetails();
				temp.setOrderID(rs1.getInt("order_id"));
				temp.setOrderDate(rs1.getString("order_date"));
				temp.setOrderTotal(rs1.getFloat("order_total"));
				temp.setCustID(rs1.getInt("customer_id"));

				det=temp;

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
		return det;

	}

	//find order by customer id
	public ArrayList<BeanBookingDetails> findOrderByCustID(int custID) {
		ArrayList<BeanBookingDetails> det = null;
		try {
			String queryString = "SELECT order_id, DATE_FORMAT(date(order_date),'%d/%m/%Y') AS date, order_total, customer_id FROM order_details WHERE customer_id = "+custID+" ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			det = new ArrayList<BeanBookingDetails>();
			while(rs1.next()) {
				BeanBookingDetails temp = new BeanBookingDetails();
				temp.setOrderID(rs1.getInt("order_id"));
				temp.setOrderDate(rs1.getString("date"));
				temp.setOrderTotal(rs1.getFloat("order_total"));
				temp.setCustID(rs1.getInt("customer_id"));

				det.add(temp);

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
		return det;

	}
	//find all orders
	public ArrayList<BeanBookingDetails> findAllOrder() {
		ArrayList<BeanBookingDetails> det = null;
		try {
			String queryString = "SELECT order_id, DATE_FORMAT(date(order_date),'%d/%m/%Y') AS date, order_total, customer_id FROM order_details";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			det = new ArrayList<BeanBookingDetails>();
			while(rs1.next()) {
				BeanBookingDetails temp = new BeanBookingDetails();
				temp.setOrderID(rs1.getInt("order_id"));
				temp.setOrderDate(rs1.getString("date"));
				temp.setOrderTotal(rs1.getFloat("order_total"));
				temp.setCustID(rs1.getInt("customer_id"));

				det.add(temp);

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
		return det;

	}

}
