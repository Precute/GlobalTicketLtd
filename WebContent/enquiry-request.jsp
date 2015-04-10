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
<body onload="myFunction()">
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
				} %>
					
					<table>
					<form action="send-enquiry" onsubmit= "return  verify(this);"  method="post"> 
							<tr><td>(*)Customer ID :</td> 
							<td><input type="text" name="custid" placeholder="Customer ID" maxlength="10" required></td></tr>
							
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