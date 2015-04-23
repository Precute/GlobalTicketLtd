<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp is for employee to create account-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Employee Up || Global Tickets Ltd</title>
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
				 }%>
				 <input type="button" value="Back" onclick="window.history.back()" /> 
					<table>
					<form action="add-employee" onsubmit= "return  verify(this);"  method="post"> 
							<tr><td>(*)First Name:</td> 
							<td><input type="text" name="empfname" placeholder="First Name" maxlength="50" required></td></tr>
							
							<tr><td>Other Name:</td>
							<td><input type="text" name="emponame" placeholder="Other Name" maxlength="50" ></td></tr>
							
							<tr><td>(*)Last Name:</td>
							<td><input type="text" name="emplname" placeholder="Last Name" maxlength="50" required></td></tr>
							
							<tr><td>Date of Birth:</td> 
							<td><input type="date" name="empdob" placeholder="dd/mm/yyyy" ></td></tr>
							
							<tr><td>State Date:</td> 
							<td><input type="date" name="startdate" placeholder="dd/mm/yyyy" ></td></tr>
							
							<tr><td>Role:</td> 
							<td><input type="text" name="emprole" placeholder="Role" maxlength="20" ></td></tr>
							
							<tr><td>(*)Salary:</td> 
							<td><input type="currency" name="empsalary" placeholder="Salary" maxlength="100" required></td></tr>
							
							<tr><td>(*)Email Address:</td> 
							<td><input type="email" name="empemail" placeholder="Email Address" maxlength="200" required></td></tr>
							
							<tr><td>Telephone:</td> 
							<td><input type="telephone" name="emptel" placeholder="Telephone" maxlength="14" ></td></tr>
							
							<tr><td>(*)Username:</td> 
							<td><input type="text" name="empusername" placeholder="Username" maxlength="100" required></td></tr>
							
							<tr><td>(*)Password:</td> 
							<td><input type="password" id="emppassword" name="emppassword" placeholder="Password" maxlength="100" required></td></tr>
							
							<tr><td>(*)Confirm Password:</td> 
							<td><input type="password" id="empverpassword" name="empverpassword" placeholder="Verify Pasword" maxlength="100" required></td></tr>
						
							<tr><br><td><input type="submit" value="Register" ></td></tr>
							</form>
							</table>
					<script>
function verify(form) {
  if (form.empfname.value.replace(/\s+/g,'') == '' 
		  || form.emplname.value.replace(/\s+/g,'') == '' 
		  //form.empaddress.value.replace(/\s+/g,'') == ''
		  //|| form.empcity.value.replace(/\s+/g,'') == ''
		  || form.emppostcode.value.replace(/\s+/g,'') == ''
		|| form.empusername.value.replace(/\s+/g,'') == ''
		 || form.emppassword.value.replace(/\s+/g,'') == ''
			 || form.empverpassword.value.replace(/\s+/g,'') == ''
		  ) {
    alert('Please ensure all mandatory fields(*) are filled.');
    return false;
  }
  var pass1 = document.getElementById("emppassword").value;
  var pass2 = document.getElementById("empverpassword").value;
  if (pass1 != pass2) {
      alert("Passwords do not match! Please verify and try again.");
      document.getElementById("emppassword").style.borderColor = "#E34234";
      document.getElementById("empverpassword").style.borderColor = "#E34234";
      return false;
  }
}
</script>
					
					
					
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