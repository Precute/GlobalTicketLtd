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
					<%int attID = Integer.parseInt(request.getParameter("attractionid"));
					String attName = request.getParameter("attractionname");
					String attType = request.getParameter("attractiontype");
					String attFullDescript = request.getParameter("attractionfulldescript");
					String attCity = request.getParameter("city");
					String attCountry = request.getParameter("country");
					%>
					
					<h2><%=attName%> is a <%=attType%> located in <%=attCity%>, <%=attCountry%>.</h2>
					<br>
					<i><%=attFullDescript%></i>
					<h3>Here are the ticket pricing details for <i><u><%=attName%></u></i>:</h3>
					<table border="1">
						<tr>
							<th>Ticket Type</th>
							<th>Ticket Price</th>
						</tr>
						
						<%
							ArrayList<BeanAttraction> att = aconnect.findPricesByAttID(attID);
						
							for (BeanAttraction a : att) { %>
								<tr><td><%=a.getTicketType()%></td>
								<td>£<%=a.getTktPrice()%></td></tr>
							<%}%>
							</table>
							<br><button type="button" onclick="location.href = 'booking-page.jsp';">Book Ticket</button>						
				</div>
			</div>
		</div>
		<div id="leftcolumnwrap">
					<div id="leftcolumn">
			bask
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