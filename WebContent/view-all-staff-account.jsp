<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee || Global Tickets Ltd</title>
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
				
			DAOEmployee econnect = new DAOEmployee();%>
				
				<i>Use this search function to find an employee <br>(If
						search isn't required, pressing 'View' to displays all Employee)
					</i> <br> <br>
				
				<form action="view-all-staff-account.jsp" method="get">
				<%
				
				ArrayList<BeanEmployee> allEmp = econnect.viewAllEmpDetail();
						%>
				
				
				 <input type="submit" value="View" name="view">
				</form>
				<%
					if (request.getParameter("view") != null) {
				%>
					<h2>Here are the details of all Staffs:</h2>
					<table border="1">
						<tr>
							<th>Employee ID</th>
							<th>Name</th>
							<th>Role</th>
						</tr>
						
					<% ArrayList<BeanEmployee> emp = econnect.viewAllEmpDetail();
					for(BeanEmployee e: emp){%>
						<tr><td><%=e.getEmpID()%></td>
						<td><%=e.getFirstName()%> <%=e.getLastName()%></td>
						<td><%=e.getRole()%></td></tr>
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