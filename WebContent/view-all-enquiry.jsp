<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home || Global Tickets Ltd</title>
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body>
<div id="wrapper">
		
		<jsp:include page="header.html" />
		
		<div id="contentliquid">
			<div id="contentwrap">
				<div id="content">
				<%session = request.getSession(true);
				Cookie ck[]=request.getCookies();  
				Cookie user, type;
				if(ck==null || ck.length==1){
				user=new Cookie("username", "");
				type=new Cookie("usertype", "");
				response.addCookie(user); 
				response.addCookie(type); 
				}
			DAOEnquiry econnect = new DAOEnquiry();%>
				
				<i>View all Enquiry from Customers <br>(Ensure the Customer reply as soon as possible)
					</i> <br> <br>
				
				<form action="view-all-enquiry.jsp" method="get">
				<%
				
				ArrayList<BeanEnquiry> eqy = econnect.viewAllEnquiry();
						%>
				<input type="submit" value="View Customer Enquiry" name="view">
				</form>
				<%
					if (request.getParameter("view") != null) {
				%>
					<h2>Here are all enquiry requested by our customers:</h2>
					<table border="1">
						<tr>
							<th>Enquiry ID</th>
							<th>Description</th>
							<th>Date</th>
							<th>Customer ID </th>
						</tr>
						
				<% ArrayList<BeanEnquiry> enq = econnect.viewAllEnquiry();
					for(BeanEnquiry e : enq){%>
						<tr><td><%e.getEnquiryID();%></td>
						<td><% e.getEnqDescpt();%></td>
						<td><%=e.getCustID()%></td></tr>
					<%} %>
					
					</table>
					<%}%>
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