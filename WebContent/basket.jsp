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
					The following items are in your basket:
					<%	try{
							int arrSize;
							
							float grandTotalPrice;
							ArrayList<BeanAttraction> att=null;
							BeanAttraction ticket=null;
							synchronized(session) {
								      
							 List<String> previousItems = null;
							 previousItems=  (List<String>)session.getAttribute("previousItems");
								      

		      if (previousItems.size() == 0) {
		        out.println("<I>The basket is empty</I>");
		      } else {%>
		    	  <table border="1">
					<tr>
						<th>Attraction Name</th>
						<th>Ticket Type</th>
						<th>Price</th>
						<th>Quantity</th>
						<th></th>
					</tr>

		        <% float totalPrice=0; arrSize=0; String ticketSplit[];int attID;int ticketTypeID;
		        for(String item: previousItems) {
		        	
		        	ticketSplit=item.split("-");
		        	ticketTypeID=Integer.parseInt(ticketSplit[0]);
		    		attID=Integer.parseInt(ticketSplit[1]);
		        	ticket = aconnect.findPriceByAttIDTicID(attID, ticketTypeID);
		        	

						out.println("<tr><td> " + ticket.getAttName() + "</td>");
						out.println("<td>" + ticket.getTicketType() + "</td>");
						out.println("<td>" + ticket.getTktPrice() + "</td>");
						totalPrice+=ticket.getTktPrice(); %>
						<td></td>
						<td><form id="removeItem" action="delete-item" method="post"> 
						<input type='hidden' name="tkt" value="<%=ticket.getTicketTypeID()%>-<%=ticket.getAttractionID()%>">
						<input type="submit" name="submit" value="Remove item">
						</form></td></tr>
					<% //close inner for
						}//close outer for%>
				
				<%
		        grandTotalPrice=totalPrice;
		        session.setAttribute("ordertotal", grandTotalPrice);%>
		      
		        	
		        	<tr><th></th><th></th><th></th><td></td><th>Total Price</th></tr>
				<tr><td></td><td></td><td></td><td></td><td><%=grandTotalPrice%></td></tr> </table>
		        <form action="checkout.jsp" method="post">
		    	<input type='hidden' name="ordertotal" value="<%=grandTotalPrice%>">
		    	<input type="submit" value="Checkout" name="checkout"></form> 
		        <% 
		      }
		    } %>
		    	<form action="index.jsp" method="post">
		    	<input type="submit" value="Reset Basket" name="submit"></form> 
		    	

				
		    	<%
					//if (request.getParameter("submit") != null) {
					//		if (session != null) {
			           //     session.invalidate();			               
			           %> 
			               <script type="text/javascript">
 							//alert('Basket has been emptied. Redirecting to home page.')
 							//window.location = 'index.jsp';
 							</script>	
			          <% // }
		    	
					}catch(NullPointerException e){%>
						<i>The basket is empty</i>
					<% }//close catch
					 %>
				</div>
			</div>
		</div>
		<div id="leftcolumnwrap">
					<div id="leftcolumn">
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