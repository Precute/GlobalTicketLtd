<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>
	
	<!--This jsp displays the home page-->
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Catalogue || Global Tickets Ltd</title>
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
				} %>
				<%
				DAOAttraction aconnect = new DAOAttraction();
				%>
				<%
							ArrayList<BeanAttraction> atype = aconnect.findAllAttType();
						ArrayList<BeanAttraction> country = aconnect.findAllCountry();
						ArrayList<BeanAttraction> ticket = aconnect.findTickettype();
						%>
				<input type="button" value="Back" onclick="window.history.back()" /> <br>
					
					<form action ="update-catalogue" method ="post">
					<tr><td>(*)Attraction Name:</td> 
					<td><input type="text" name="attname" placeholder="Attraction Name" maxlength="50" required></td></tr><br><br>
					
					<tr><td>(*)Attraction Description :</td><br><br>
					<td><textarea name="attdescript" placeholder="Enter a brief description of attraction " rows="10" cols="60" maxlength="500" required ></textarea></td></tr><br>
					
					<tr><td>(*)Full Attraction Description :</td><br><br>
					<td><textarea name="attdescript1" placeholder="Enter a detailed description of attraction " rows="10" cols="100" maxlength="5000" required></textarea></td></tr><br><br>
					
					<tr><td>(*)Numbers of Ticket Available:</td> 
					<td><input type="number" name="attnumber" placeholder="Ticket Number" maxlength="20" required></td></tr><br>
					
					<tr><td>(*)Attraction Type:</td> 
					<td>	<select name="atttype" required>
							<option value=" ">Attraction Type</option>
							<%
								for (BeanAttraction a : atype) {
							%>
							<option value="<%=a.getAttTypeID()%>">
								<%=a.getAttType()%></option>
							<%
								}
							%>
						</select>
					</tr><br>
					
					<tr><td>(*)Location:</td> 
					<td><select name="attlocation" required>
							<option value=" ">Country</option>
							<%
								for (BeanAttraction a : country) {
									
							%>
							<option value="<%=a.getLocationID()%>">
								<%=a.getCountry()%></option>
							<%
								}
							%>
							</select> <br><br><input type="submit" value="Submit" name="submit"><br><br>
							
							
						
						
					</form>

						
						
							
					
					
					
					<script>
					function verify(form) {
						  if (form.attname.value.replace(/\s+/g,'') == '' 
								  || form.attdescript.value.replace(/\s+/g,'') == '' 
								  || form.attdescript1.value.replace(/\s+/g,'') == ''
								  || form.attnumber.value.replace(/\s+/g,'') == ''
								  || form.atttype.value.replace(/\s+/g,'') == ''
								|| form.attlocation.value.replace(/\s+/g,'') == ''
									|| form.tkttype.value.replace(/\s+/g,'') == ''
									|| form.attprice.value.replace(/\s+/g,'') == ''
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