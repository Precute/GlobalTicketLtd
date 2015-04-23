<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
<!-- 
This jsp displays search and the results in a table -->
<%
	DAOAttraction aconnect = new DAOAttraction();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tickets Search || Global Tickets Ltd</title>
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body>	
<div id="wrapper">
		<jsp:include page="header.html" />
		
		<div id="contentliquid">
			<div id="contentwrap">
				<div id="content">
				<input type="button" value="Back" onclick="window.history.back()" /> <br>
					<i>Use this search function to find attractions to book <br>(If
						search isn't required, pressing 'Search' displays all attraction)
					</i> <br> <br>
					<form action="ticket-search.jsp" method="get">
						<%
							ArrayList<BeanAttraction> type = aconnect.findAllAttType();
						ArrayList<BeanAttraction> city = aconnect.findAllCity();
						ArrayList<BeanAttraction> country = aconnect.findAllCountry();
						%>
						<select name="atttype">
							<option value="">Attraction Type</option>
							<%
								for (BeanAttraction a : type) {
							%>
							<option value="<%=a.getAttType()%>">
								<%=a.getAttType()%></option>
							<%
								}
							%>
						</select>
						
						<select name="city">
							<option value="">City</option>
							<%
								for (BeanAttraction a : city) {
							%>
							<option value="<%=a.getCity()%>">
								<%=a.getCity()%></option>
							<%
								}
							%>
						</select>
						
						<select name="country">
							<option value="">Country</option>
							<%
								for (BeanAttraction a : country) {
							%>
							<option value="<%=a.getCountry()%>">
								<%=a.getCountry()%></option>
							<%
								}
							%>
						</select>
						
						<br><br><br> <input type="submit" value="Search"  name="search">
					</form>


					<%
						if (request.getParameter("search") != null) {
					%>
					<h2>Here are Attraction results:</h2>
					<table border="1">
						<tr>
							<th>Attraction Name</th>
							<th>Description</th>
							<th>Type of Attraction</th>
							<th>City</th>
							<th>Country</th>
							<th>Price</th>
							<th>Availability</th>
							<th>Book?</th>
						</tr>
						
							<%
								String attType = request.getParameter("atttype");
												String locCity = request.getParameter("city");
												String locCountry = request.getParameter("country");
												
												ArrayList<BeanAttraction> att = aconnect.
														findByAttTypeCityCountry(attType, locCity, locCountry);
												
													for (BeanAttraction a : att) {
														%>
							<tr><td><form id="detailsform" action="attraction-details.jsp" method="get"> 
							<input type='hidden' name="attractionid" value="<%=a.getAttractionID()%>">
							<input type='hidden' name="attractionname" value="<%=a.getAttName()%>">
							<input type='hidden' name="attractiontype" value="<%=a.getAttType()%>">
							<input type='hidden' name="attractionfulldescript" value="<%=a.getAttFullDescript()%>">
							<input type='hidden' name="city" value="<%=a.getCity()%>">
							<input type='hidden' name="country" value="<%=a.getCountry()%>">
							 <input type="submit" class="submitLink" value="<%=a.getAttName()%>" >
							</form></td>
							
							<td><%=a.getAttDescript()%></td>
							<td><%=a.getAttType()%></td>
							<td><%=a.getCity()%></td>
							<td><%=a.getCountry()%></td>
							<%Float[] prices = aconnect.getTicketsMinMaxPriceByType(a.getAttractionID());
							 float minPr = (float)aconnect.roundPrice(prices[0], 2);
											float maxPr = prices[1]; %>
							<td>£<%=minPr%> to £<%=maxPr%></td>
							
										<%if (a.getAttAvailabilityCount() == 0) {
											out.println("<td>No Tickets Available</td>");
										} else if(a.getAttAvailabilityCount()<=100){
											out.println("<td>Limited Ticket Available</td>");
										}
										else
											out.println("<td>Tickets Available</td>");	%>
									    <td><form action="booking-page.jsp" method="post">
									    		<input type="hidden" name="attractionname" value="<%=a.getAttName()%>">
									    		<input type="hidden" name="attractionid" value="<%=a.getAttractionID()%>">
									    		<input type="hidden" name="tickettypeid" value="<%=a.getTicketTypeID()%>">
											      <input type="submit" value="Book Tickets" >
											      </form></td></tr>
								<% 	}%>
						
						
					</table>
					<%
						if (att.isEmpty()) {
								out.println("No result were found. Please try again.");
							}

						}
					%>
					<br><button type="button" onclick="location.href = 'customer-account.jsp';">Go to Your Acount</button>	
				</div>
			</div>
		</div>
		<div id="leftcolumnwrap">
					<div id="leftcolumn">
			basket
 				<hr>
				<jsp:include page="loginform.jsp" />
			</div>
			</div>
		<div id="footerwrap">
			<div id="footer">
				<i><span>Global Tickets Ltd, 123 Old Church St, Newton Heath, Manchester, M10 2DA</span></i>

				<div id="accessibility">
					<a href='videos'
						title='Plain-Text Video Listing || CongoCorp Online Store'>See
						plain text video listings here</a>
						<br><a href='music'
						title='Plain-Text Music Listing || CongoCorp Online Store'>See
						plain text music records listings here</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>