<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees || Global Tickets Ltd</title>
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
				 if (!type.equals("admin") && type!=null){
					 request.setAttribute("errorMessage", "Sorry customers and non-admin staff cannot login to admin area!"); 
					 request.getRequestDispatcher("login.jsp").forward(request, response);  
					 return;
				 }
				
			DAOEmployee econnect = new DAOEmployee();%>
			
			<input type="button" value="Back" onclick="window.history.back()" /> <br>
				<a href ='new-employee-account.jsp'>Register new employee</a>
				<br>
				<br>
				<i>Use this search function helps to find an employee <br>(If
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
							<th>Manager Name</th>
						</tr>
						
					<% ArrayList<BeanEmployee> emp = econnect.viewAllEmpDetail();
					for(BeanEmployee e: emp){%>
						<tr><td><%=e.getEmpID()%></td>
						<td><%=e.getFirstName()%> <%=e.getLastName()%></td>
						<td><%=e.getRole()%></td>
						<td><%=e.getManFirstName()%> <%=e.getManLastName()%></td></tr>
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