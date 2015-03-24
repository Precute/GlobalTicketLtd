package global;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
	
	public ArrayList<BeanAttraction> findAtrByAttTypePriceCountry(String type, float minPrice, float maxPrice, String city, String country) {
		ArrayList<BeanAttraction> att = null;
		try {
			String queryString = "SELECT c.attractionID, attName, attDescript, attAvailabilityCount, attType, city, country, tktType, ticketPrice FROM global_attractionpricelist p, global_tickettype tt, global_attractioncatalogue c, global_attractiontype att, global_location l WHERE l.locationID=c.locationID AND att.attTypeID=c.attTypeID AND p.attractionID=c.attractionID AND p.tktTypeID=tt.tktTypeID AND (att.atttype IS NULL OR att.atttype LIKE '%"+type+"%') AND (l.country IS NULL OR l.country LIKE '%"+country+"%') AND (l.city IS NULL OR l.city LIKE '%"+city+"%') AND (p.ticketprice IS NULL OR p.ticketprice >= "+minPrice+" AND p.ticketprice <= "+maxPrice+")";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			att = new ArrayList<BeanAttraction>();
			while (rs1.next()) {
				BeanAttraction temp = new BeanAttraction();
				temp.setAttractionID(rs1.getInt("attractionID"));
				temp.setAttName(rs1.getString("attName"));
				temp.setAttDescript(rs1.getString("attDescript"));
				temp.setAttAvailabilityCount(rs1.getInt("attAvailabilityCount"));
				temp.setAttType(rs1.getString("attType"));
				temp.setCity(rs1.getString("city"));
				temp.setCountry(rs1.getString("country"));
				temp.setTicketType(rs1.getString("tktType"));
				temp.setTktPrice(rs1.getFloat("ticketPrice"));
				att.add(temp);

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
		return att;

	}
	
	//get music minimum and maximum prices in database and return in array
		public Float[] getAttTicketsMinMaxPrice() {
			Float[] minMax= new Float[2];
			try {
				String queryString = "SELECT ROUND(MIN(ticketprice),2) AS MIN, ROUND(MAX(ticketprice),2) AS MAX FROM global_attractionpricelist";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				
				if(rs1.next()){
					minMax[0]=(rs1.getFloat("MIN"));
					minMax[1]=(rs1.getFloat("MAX"));
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
			return minMax;
		}
		
		//find all music categories
		public ArrayList<BeanAttraction> findAllAttType() {
			ArrayList<BeanAttraction> att = null;
			try {
				String queryString = "SELECT * FROM global_attractiontype";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				att = new ArrayList<BeanAttraction>();
				while (rs1.next()) {
					BeanAttraction temp = new BeanAttraction();
					temp.setAttTypeID(rs1.getInt("attTypeID"));
					temp.setAttType(rs1.getString("attType"));
					att.add(temp);

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
			return att;
		}
		
		//round prices to a specified number of places
		public double roundPrice(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();

		    BigDecimal bd = new BigDecimal(value);
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    return bd.doubleValue();
		}
}
