<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enquiry || Global Tickets Ltd</title>
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body onload="myFunction()">
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
				 
				 if (username == null || username.equals("")){
					 request.setAttribute("errorMessage", "Please login first!"); 
					 request.getRequestDispatcher("login.jsp").forward(request, response);  
					 return;
					 }
				 if (!type.equals("customer") && type!=null){
					 request.setAttribute("errorMessage", "Sorry admin staff cannot login to customer area!"); 
					 request.getRequestDispatcher("login.jsp").forward(request, response);  
					 return;
				 }
				 
				  DAOEnquiry econnect = new DAOEnquiry();
					DAOLogin lconnect = new DAOLogin();
					 BeanLogin usr =null;
					 usr=lconnect.retrieveUserByUsername(username);
					 int custID = usr.getID();
					%>
								<input type="button" value="Back" onclick="window.history.back()" /> <br>
								<p>By Phone<br>
								Within the UK: 0344 499 6690<br>
								International:00 800 0926 0926<br>
  
				Our UK and International Customer Service team are here to help Monday to Saturday: 8am to 8pm and Sunday: 10am to 6pm GMT and longer during peak periods.<br> 
				Calls are charged at a basic rate. Please refer to your service provider for all charges. </p>
					<table>
					<form action="send-enquiry" onsubmit= "return  verify(this);"  method="post"> 
							<tr><td>(*)Customer ID :</td> 
							<td><input type="text" name="custid" value ="<%=custID%>"></td></tr>
							
							<tr><td>(*)Date: </td>
							<td><input type="date" id="writeDay" name ="enqdate"/></td></tr>
	
							
							<script>
							function myFunction() {
							document.getElementById('writeDay').valueAsDate = new Date();
							}
							</script>
							
							<tr><td>(*)Enquiry Details :</td>
							<td><textarea name="enquirydetail" placeholder="What Do You Want To Say ?" rows="10" cols="60" maxlength="500" ></textarea></td></tr>
							
							
							<tr><br><td><input type="submit" value="Send" ></td></tr>
							</form>
							</table>
						
					<script>
function verify(form) {
  if (form.custfname.value.replace(/\s+/g,'') == '' 
		  || form.custid.value.replace(/\s+/g,'') == ''  
		  || form.enquirydetail.value.replace(/\s+/g,'') == ''
		  ) {
    alert('Please ensure all mandatory fields(*) are filled.');
    return false;
  }
}
					</script>
					
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