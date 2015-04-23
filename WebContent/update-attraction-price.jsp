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
					
					<form action ="price-update" method ="post">
					
					<tr><td>(*)Ticket Type:</td> 
					<td>	<select name="type" required>
							<option value=" ">Attraction Type</option>
							<%
								for (BeanAttraction t : ticket) {
							%>
							<option value="<%=t.getTicketTypeID()%>">
								 <%=t.getTicketType()%></option>
							<%
								}
							%>
						</select>
						
					</tr><br>	
					<tr><td>(*)Enter Price:</td> 
					<td><input type ="text" name="attprice" placeholder ="0.00" ></td>
					</tr>
					</form>
					

					<%if (request.getParameter("addmore") !=null ) {%>
					<form action ="update-attraction-price.jsp" method ="get">
					
					<tr><td>(*)Ticket Type:</td> 
					<td>	<select name="tkttype" required>
							<option placeholder =" ">Attraction Type</option>
							<%
								for (BeanAttraction t : ticket) {
							%>
							<option value="<%=t.getTicketTypeID()%>">
								 <%=t.getTicketType()%></option>
							<%
								}
							%>
						</select>
						
					</tr><br>	
					<tr><td>(*)Enter Price:</td> 
					<td><input type ="text" name="attprice" placeholder ="0.00" ></td>
					</tr>
					</form>	
						
					<%}%>	
						
							
					
					<br><input type="submit"  name ="addmore" value ="Add More Ticket"/>
					<br><input type ="submit" name ="submit" value ="Sumbit"/><br>
					
					<script>
					function verify(form) {
						  if (
									form.tkttype.value.replace(/\s+/g,'') == ''
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