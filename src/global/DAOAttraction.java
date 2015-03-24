package global;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import congo.BeanMusicRec;


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
	
	public ArrayList<BeanAttraction> findAtrByAttTypePriceCountry(String type, float minPrice, float maxPrice, String country) {
		ArrayList<BeanAttraction> atr = null;
		try {
			String queryString = "SELECT c.attractionID, attName, attDescript, attAvailabilityCount, attType, city, country, tktType, ticketprice FROM global_attractionpricelist p, global_tickettype tt, global_attractioncatalogue c, global_attractiontype att, global_location l WHERE l.locationID=c.locationID AND att.attTypeID=c.attTypeID AND p.attractionID=c.attractionID AND p.tktTypeID=tt.tktTypeID AND (att.atttype IS NULL OR att.atttype LIKE '%"+type+"%') AND (l.country IS NULL OR l.country LIKE '%"+country+"%') AND (p.ticketprice IS NULL OR p.ticketprice >= "+minPrice+" AND p.ticketprice <= "+maxPrice+")";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			atr = new ArrayList<BeanAttraction>();
			while (rs1.next()) {
				BeanAttraction temp = new BeanAttraction();
				temp.setRecID(rs1.getInt("recording_id"));
				temp.setArtistName(rs1.getString("artist_name"));
				temp.setRecTitle(rs1.getString("title"));
				temp.setCategory(rs1.getString("category"));
				temp.setImageName(rs1.getString("image_name"));
				temp.setNumTracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStockCount(rs1.getInt("stock_count"));
				art.add(temp);

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
		return atr;

	}
	
	//get music minimum and maximum prices in database and return in array
		public Float[] getAtrTicketsMinMaxPrice() {
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
}
