<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
<!-- 
This jsp displays search and the results in a table -->
<%
	DAOAttraction aconnect = new DAOAttraction();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body>
				
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
		    	  <table border="0">
					<tr>
						<th>Attraction Name</th>
						<th>Ticket Type</th>
						<th>Price</th>
					</tr>

		        <% float totalPrice=0; arrSize=0; String ticketSplit[];int attID;int ticketTypeID;
		        for(String item: previousItems) {
		        	
		        	ticketSplit=item.split("-");
		        	ticketTypeID=Integer.parseInt(ticketSplit[0]);
		    		attID=Integer.parseInt(ticketSplit[1]);
		        	ticket = aconnect.findPriceByAttIDTicID(attID, ticketTypeID);
		        	

						out.println("<tr><td> " + ticket.getAttName() + "</td>");
						out.println("<td>" + ticket.getTicketType() + "</td>");
						out.println("<td>" + ticket.getTktPrice() + "</td></tr>");
						totalPrice+=ticket.getTktPrice(); %>

					<% //close inner for
						}//close outer for%>

		        <% 
		      }
		    } %> </table>
		    		<form action="index.jsp" method="post">
		    	<input type="submit" value="Edit Items" name="edit">
		    	<input type="submit" value="Reset Basket" name="submit">
		    	</form> 
				<button type="button" onclick="location.href = 'checkout.jsp';">Checkout</button>
		    	<%
		    		if (request.getParameter("edit") != null) {
		    			RequestDispatcher requestDispatcher = request
		    					.getRequestDispatcher("/basket.jsp");
		    			requestDispatcher.forward(request, response);
		    			return;
		    		}
		   
					if (request.getParameter("submit") != null) {
							if (session != null) {
			                session.invalidate();			               
			           %> 
			               <script type="text/javascript">
 							alert('Basket has been emptied. Redirecting to home page.')
 							window.location = 'index.jsp';
 							</script>	
			          <%  }  		
						}
					}catch(NullPointerException e){%>
						<i>The basket is empty</i>
					<% }%>
	</body>
</html>		