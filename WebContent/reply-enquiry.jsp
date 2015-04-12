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
	 %>	
				
				
				
				
				
				
				
				
									<input type="button" value="Back" onclick="window.history.back()" /> <br>
					<%int enqID = Integer.parseInt(request.getParameter("enquiryid"));%>
					
						
					<h3>Enquiry ID : <i><u><%=enqID%> </u></i></h3>
					<output></output>
					<table>
					<form action="reply-enquiry" onsubmit= "return  verify(this);"  method="post"> 
					
					
					<% DAOEnquiry econnect = new DAOEnquiry();
					DAOLogin lconnect = new DAOLogin();
					 BeanLogin usr =null;
					 usr=lconnect.retrieveUserByUsername(username);
					 int empID = usr.getID();
					%>
						<tr><td>Enquiry No :</td> 
						<td><input type ="text" name ="enqid" value ="<%=enqID%>"></td></tr>
						
						
						<tr><td>(*)Employee ID :</td> 
							
							
							<td><input type="text" name="empid" value ="<%=empID%>"></td></tr>
							
							
							<tr><td>(*)Note :</td>
							<td><textarea name="enquirynote" placeholder="Reply" rows="10" cols="60" maxlength="500" ></textarea></td></tr>
							
							
							<tr><br><td><input type="submit" value="Send" ></td></tr>
							</form>
							</table>
						
					<script>
function verify(form) {
  if (form.custfname.value.replace(/\s+/g,'') == '' 
		  || form.empid.value.replace(/\s+/g,'') == ''  
		  || form.enquirynote.value.replace(/\s+/g,'') == ''
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