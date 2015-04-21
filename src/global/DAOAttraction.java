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
	
	public void add(BeanAttraction a) {
		try {
			String queryString = "INSERT INTO global_attractioncatalogue(attName, attDescript, attFullDescription, "
					+ "attAvailabilityCount, attTypeID, locationID) "
					+ "VALUES(?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, a.getAttName());
			ptmt.setString(2, a.getAttDescript());
			ptmt.setString(3, a.getAttFullDescript());
			ptmt.setInt(4, a.getAttAvailabilityCount());
			ptmt.setInt(5, a.getAttTypeID());
			ptmt.setInt(6, a.getLocationID());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
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
	
	
	public void addPrice(BeanAttraction a) {
		try {
			String queryString = "INSERT INTO global_attractionpricelist(attractionID, tktTypeID, ticketPrice) "
					+ "VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, a.getAttractionID());
			ptmt.setInt(2, a.getTicketTypeID());
			ptmt.setDouble(3, a.getTktPrice());
			
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
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
	
	public BeanAttraction findAllCatalogue(String attName, String descript) {
		BeanAttraction att = null;
		try {
			String queryString = "SELECT * FROM global_attractioncatalogue WHERE attName = "+attName+"  AND attDescript ="+descript+"";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			att = new BeanAttraction();
			while(rs1.next()) {
				BeanAttraction temp = new BeanAttraction();
				temp.setAttractionID(rs1.getInt("attractionID"));
				temp.setAttName(rs1.getString("attName"));
				temp.setAttDescript(rs1.getString("attDescript"));
				temp.setAttFullDescript(rs1.getString("attFullDescription"));
				temp.setAttAvailabilityCount(rs1.getInt("attAvailabilityCount"));
				temp.setAttType(rs1.getString("attType"));
				temp.setCity(rs1.getString("city"));
				temp.setCountry(rs1.getString("country"));
				att=temp;

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
	
	
	public ArrayList<BeanAttraction> findByAttTypeCityCountry(String type, String city, String country) {
		ArrayList<BeanAttraction> att = null;
		try {
			String queryString = "SELECT c.attractionID, attName, attDescript, attFullDescription, attAvailabilityCount, attType, city, country " //, tktType, ticketPrice "
					+ "FROM global_attractioncatalogue c, global_attractiontype att, global_location l " //,global_tickettype tt ,global_attractionpricelist p "
					+ "WHERE l.locationID=c.locationID "
					+ "AND att.attTypeID=c.attTypeID "
					//+ "AND p.attractionID=c.attractionID "
					//+ "AND p.tktTypeID=tt.tktTypeID"
					+ "AND (att.atttype IS NULL OR att.atttype LIKE '%"+type+"%') "
					+ "AND (l.country IS NULL OR l.country LIKE '%"+country+"%') "
					+ "AND (l.city IS NULL OR l.city LIKE '%"+city+"%') ";
					//+ "AND (p.ticketprice IS NULL OR p.ticketprice >= "+minPrice+" "
					//+ "AND p.ticketprice <= "+maxPrice+")";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			att = new ArrayList<BeanAttraction>();
			while (rs1.next()) {
				BeanAttraction temp = new BeanAttraction();
				temp.setAttractionID(rs1.getInt("attractionID"));
				temp.setAttName(rs1.getString("attName"));
				temp.setAttDescript(rs1.getString("attDescript"));
				temp.setAttFullDescript(rs1.getString("attFullDescription"));
				temp.setAttAvailabilityCount(rs1.getInt("attAvailabilityCount"));
				temp.setAttType(rs1.getString("attType"));
				temp.setCity(rs1.getString("city"));
				temp.setCountry(rs1.getString("country"));
				//temp.setTicketType(rs1.getString("tktType"));
				//temp.setTktPrice(rs1.getFloat("ticketPrice"));
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
	
	public ArrayList<BeanAttraction> findAttByID(int ID) {
		ArrayList<BeanAttraction> att = null;
		try {
			String queryString = "SELECT *" //, tktType, ticketPrice "
					+ "FROM global_attractioncatalogue c, global_attractiontype att, global_location l " //,global_tickettype tt ,global_attractionpricelist p "
					+ "WHERE l.locationID=c.locationID "
					+ "AND att.attTypeID=c.attTypeID "
					+ "AND attractionID="+ID+"";
					
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			att = new ArrayList<BeanAttraction>();
			while (rs1.next()) {
				BeanAttraction temp = new BeanAttraction();
				temp.setAttractionID(rs1.getInt("attractionID"));
				temp.setAttName(rs1.getString("attName"));
				temp.setAttDescript(rs1.getString("attDescript"));
				temp.setAttFullDescript(rs1.getString("attFullDescription"));
				temp.setAttAvailabilityCount(rs1.getInt("attAvailabilityCount"));
				temp.setAttType(rs1.getString("attType"));
				temp.setCity(rs1.getString("city"));
				temp.setCountry(rs1.getString("country"));
				//temp.setTicketType(rs1.getString("tktType"));
				//temp.setTktPrice(rs1.getFloat("ticketPrice"));
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
	
	public ArrayList<BeanAttraction> findPricesByAttID(int attID) {
		ArrayList<BeanAttraction> att = null;
		try {
			String queryString = "SELECT c.attractionID, tktType, ticketPrice "
					+ "FROM global_tickettype tt, global_attractionpricelist p, global_attractioncatalogue c "
					+ "WHERE p.attractionID=c.attractionID "
					+ "AND p.tktTypeID=tt.tktTypeID "
					+ "AND c.attractionID="+attID+" ";
					
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			att = new ArrayList<BeanAttraction>();
			while (rs1.next()) {
				BeanAttraction temp = new BeanAttraction();
				temp.setAttractionID(rs1.getInt("attractionID"));
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
	
	//get minimum and maximum prices in database and return in array
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
		public Float[] getTicketsMinMaxPriceByType(int attractionID) {
			Float[] minMax= new Float[2];
			try {
				String queryString = "SELECT ROUND(MIN(ticketprice),2) AS MIN, ROUND(MAX(ticketprice),2) AS MAX FROM global_attractionpricelist WHERE attractionid="+attractionID+" ";
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
		public ArrayList<BeanAttraction> findAllCountry() {
			ArrayList<BeanAttraction> att = null;
			try {
				String queryString = "SELECT * FROM global_location";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				att = new ArrayList<BeanAttraction>();
				while (rs1.next()) {
					BeanAttraction temp = new BeanAttraction();
					temp.setLocationID(rs1.getInt("locationID"));
					temp.setCountry(rs1.getString("country"));
					temp.setCity(rs1.getString("city"));
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
		
		public ArrayList<BeanAttraction> findAllCity() {
			ArrayList<BeanAttraction> att = null;
			try {
				String queryString = "SELECT DISTINCT city FROM global_location";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				att = new ArrayList<BeanAttraction>();
				while (rs1.next()) {
					BeanAttraction temp = new BeanAttraction();
					temp.setCity(rs1.getString("city"));
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
		public ArrayList<BeanAttraction> findAttType( int attID) {
			ArrayList<BeanAttraction> att = null;
			try {
				String queryString = "SELECT * FROM global_attractioncatalogue WHERE attractionID = "+attID+"";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				att = new ArrayList<BeanAttraction>();
				while (rs1.next()) {
					BeanAttraction temp = new BeanAttraction();
					temp.setAttTypeID(rs1.getInt("attTypeID"));
					temp.setAttName(rs1.getString("attName"));
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
		public ArrayList<BeanAttraction> findTickettype( ) {
			ArrayList<BeanAttraction> att = null;
			try {
				String queryString = "SELECT * FROM global_tickettype ";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				att = new ArrayList<BeanAttraction>();
				while (rs1.next()) {
					BeanAttraction temp = new BeanAttraction();
					temp.setTktTypeID(rs1.getInt("tktTypeID"));
					temp.setTicketType(rs1.getString("tktType"));
					
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
		
		public ArrayList<BeanAttraction> findtype( int tID) {
			ArrayList<BeanAttraction> att = null;
			try {
				String queryString = "SELECT * FROM global_tickettype WHERE tktTypeID = "+tID+"";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				rs1 = ptmt.executeQuery();

				att = new ArrayList<BeanAttraction>();
				while (rs1.next()) {
					BeanAttraction temp = new BeanAttraction();
					temp.setTktTypeID(rs1.getInt("tktTypeID"));
					temp.setTicketType(rs1.getString("tktType"));
					
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
