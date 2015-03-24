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
					<i>Use this search function to find attractions to book <br>(If
						search isn't required, pressing 'Search' displays all attraction)
					</i> <br> <br>
					<form action="ticket-search.jsp" method="get">
						<%
							ArrayList<BeanAttraction> type = aconnect.findAllAttType();
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

						<%
							Float[] pri = aconnect.getAttTicketsMinMaxPrice();
											float min = (float)aconnect.roundPrice(pri[0]-1, 2);
											float max = pri[1];
						%>
						<select name="minprice">
							<option value="<%=min-1%>">Min Price</option>
							<%
								float i = 0;
													for (i = min; i <= max; i += 2) {
							%>
							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select> <select name="maxprice">
							<option value="<%=max%>">Max Price</option>
							<%
								float j = 0;
							for (j = max; j >= min; j -= 2) {
							%>
							<option value="<%=j%>"><%=j%></option>
							<%
								}
							%>
						</select> <input type="text" name="city" placeholder="City">
						</select> <input type="text" name="country" placeholder="Country">
						<br> <input type="submit" value="Search" name="search">
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
							<th>Ticket Type</th>
							<th>Price</th>
							<th>Availability</th>
							<th>Book?</th>
						</tr>
						
							<%
								String attType = request.getParameter("atttype");
												String city = request.getParameter("city");
												String country = request.getParameter("country");
												Float minPrice = Float.parseFloat(request
															.getParameter("minprice"));
												Float maxPrice = Float.parseFloat(request
															.getParameter("maxprice"));
												ArrayList<BeanAttraction> att = aconnect.
														findAtrByAttTypePriceCountry(attType, minPrice, maxPrice, city, country);
												
													for (BeanAttraction a : att) {
														%>
														<tr><td><%=a.getAttName()%></td>
														
							
						
							<td><form id="descriptionform" action="attraction-details.jsp" method="get"> 
							<input type='hidden' name="attractionid" value="<%=a.getAttractionID()%>">
							  <input type="submit" class="submitLink" value="<%=a.getAttDescript()%>" >
							</form></td>
							
							<td><%=a.getAttType()%></td>
							<td><%=a.getCity()%></td>
							<td><%=a.getCountry()%></td>
							<td><%=a.getTicketType()%></td>
							<td><%=a.getTktPrice()%></td>
							
										<%if (a.getAttAvailabilityCount() == 0) {
											out.println("<td>No Tickets Available</td>");
										} else if(a.getAttAvailabilityCount()<=100){
											out.println("<td>Limited Ticket Available</td>");
										}
										else
											out.println("<td>Tickets Available</td>");	%>
									    <td><form action="book-tickets" method="post">
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
				</div>
			</div>
		</div>
		<div id="leftcolumnwrap">
					<div id="leftcolumn">
			bask
 				<hr>
				log
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