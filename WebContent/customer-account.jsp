<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Account || Global Tickets Ltd</title>
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
				  
				 if (username == null || username.equals("")){
					 request.setAttribute("errorMessage", "Please login first!"); 
					 request.getRequestDispatcher("login.jsp").forward(request, response);  
					 return;
					 }
				 if (!type.equals("customer") && type!=null){
					 request.setAttribute("errorMessage", "Sorry employees cannot login to customer area!"); 
					 request.getRequestDispatcher("login.jsp").forward(request, response);  
					 return;
				 }%>
				<h3>Welcome to the customer area. You can view your bookings and customer profile here.</h3>
				
				<a href='tbc'>Customer Profile</a><br>
				<a href='tbc'>View Bookings</a><br>
				<br> <br><button type="button" onclick="location.href = 'view-response.jsp';">View enquiry Response</button>	
				<br> <br><button type="button" onclick="location.href = 'view-transactions.jsp';">View All Transactions </button>
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