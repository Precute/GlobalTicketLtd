<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Response || Global Tickets Ltd</title>
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body>
<div id="wrapper">
		
		<jsp:include page="header.html" />
		
		<div id="contentliquid">
			<div id="contentwrap">
				<div id="content">
				<%   Cookie ck[]=request.getCookies();  
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
				 
				 DAOEnquiry econnect = new DAOEnquiry();
					DAOLogin lconnect = new DAOLogin();
					DAOEmployee empconnect = new DAOEmployee();
					 BeanLogin usr =null;
					 String enqd = null;
					 usr=lconnect.retrieveUserByUsername(username);
					 int custID = usr.getID();
					 ArrayList<BeanEnquiry> ENQUIRY =null;
					 ENQUIRY=econnect.findEnqByCustID(custID);
					for(BeanEnquiry enq :ENQUIRY){
						 enqd = enq.getEnqDescpt();
						}
					 
					%>
					 <input type="button" value="Back" onclick="window.history.back()" /> <br>
					 
		         	<% if (enqd == null || enqd.equals("")){
					 out.println("<h3> Dear customer,<br> Global ticket limited do not have any record of your enquiry. <br> You can contact us by calling the office<br> or by clicking the button below : <br></h3>");
	%> 
				<br><button type="button" onclick="location.href = 'enquiry-request.jsp';">Make Enquiry</button>
			 <br><button type="button" onclick="location.href = 'customer-account.jsp';">Go to Your Acount</button>					
		         	
		         	<%}if (enqd != null ){ %>
		         		<h3> Here is a list of your Enquiry and Reply, <%=username %>!</h3>
		             	<table border="1">
		             	<tr>
		             	<th>Enquiry ID</th>
		             	<th>Your enquiry</th>
		             	<th>Response</th>
		             	<th>Staff's</th>
		             	</tr>
		    					<%for(BeanEnquiry oDeto: ENQUIRY){%>
		             		<tr><td><%=oDeto.getEnquiryID()%></td>
		    				<td><%=oDeto.getEnqDescpt()%></td>
		    				<% if (oDeto.getEnqNote() == null) {
		    										out.println("<td>We will get back to you as soon as possible.<br><br>Regards <br>The Global Ticket Limited<br> </td>");
		    									} else
		    										out.println("<td>" + oDeto.getEnqNote() + "</td>");%>
		    				<%  int ID = oDeto.getEmpID();
		    					 ArrayList<BeanEmployee> employee = null;
		    						employee =empconnect.findEmpByID(ID);
		    						for(BeanEmployee empy : employee){%>
		    						<% String empname = empy.getFirstName(); %> 
		    						<% String empname2 =empy.getLastName(); %>
		    						
		    						<% out.println("<td>"+ empname + " "+ empname2 +"</td>");%>
		    				<%} %>
		    					</tr>
		    				
		    			 <%}%>
		             	</table>
		    					
		    				<br> <br><button type="button" onclick="location.href = 'customer-account.jsp';">Go to Your Acount</button>	
		    				<br> <br><button type="button" onclick="location.href = 'enquiry-request.jsp';">Make a New Enquiry</button>
		         	
					 	<%} %>
         
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