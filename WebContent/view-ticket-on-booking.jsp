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
					<%Cookie ck[]=request.getCookies();  
				String username=null;
				String type=null;
				 if (ck != null) {
				for (Cookie cookie : ck) {
					   if(cookie.getName().equals("username")){
						  username=cookie.getValue();
					   }
					   if(cookie.getName().equals("usertype")){
						   type=cookie.getValue();
						 
					   }
				   } 
				}
				DAOLogin lconnect = new DAOLogin();
				DAOBooking bconnect = new DAOBooking();
					DAOCustomer cconnect = new DAOCustomer();
					 BeanLogin usr =null;
					 String enqd = null;
					 usr=lconnect.retrieveUserByUsername(username);
					 int custID = usr.getID();
					 ArrayList<BeanBookingDetails> BBD=null;
					 BBD = bconnect.findBookingByCustID(custID);%>
			<input type="button" value="Back" onclick="window.history.back()" /> <br>
					  
         
			<% 
	
	String bokID= request.getParameter("bookingid");
			
			ArrayList<BeanTicketOnBooking> BK=null;
	BK = bconnect.findBookingByBookingID (bokID);   %>
	
	<br><h4>Here are the Ticket(s) for Booking, 000<%=bokID%>.</h4>
	 <table border="1">
	 <tr>
         	<th>Attraction Type</th>
         	<th>Ticket Type</th>
         	<th>Ticket Date</th>
         	<th>Ticket Quantity</th>
         	<th>Ticket Per Person</th>
         	<th>Ticket Total Cost</th>
         	
      </tr>
      <% for(BeanTicketOnBooking bok: BK ) {%>
    	  <tr><td><%=bok.getAttractionID() %></td>
    	  <td><%=bok.getTktTypeID() %></td>
    	  <td><%=bok.getTicketDate() %></td>
    	  <td><%=bok.getTicketQty() %></td>
    	  <%float ppp = bok.getTktTotalCost()/bok.getTicketQty();%>
    	  <td>£<%=ppp %></td>
    	  <td>£<%=bok.getTktTotalCost() %></td>
    	  </tr>
    	  
      <%}%>
     
	 
	 </table>
			
	<% %>		
			<br><button type="button" onclick="location.href = 'customer-account.jsp';">Go to Your Acount</button>		
			<%
    	  
    	      	  %>
    	      	  	
				</div>
			</div>
		</div>
		<div id="leftcolumnwrap">
			<div id="leftcolumn">
			<jsp:include page="basket-view.jsp" />
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