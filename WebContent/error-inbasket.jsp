<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="global.*,java.util.*"%>

	<!-- 
This jsp displays an error if an item is out of stock-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error || CongoCorp Entertainment Store</title>
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body>
	<div id="wrapper">
			<jsp:include page="header.html" />
		
		<div id="contentliquid">
			<div id="contentwrap">
				<div id="content">
					Sorry but the item is in the basket! To update quantity of this ticket, go to into the basket.<br>
					<br>
					<button onclick="goBack()">Back to previous page</button>
				
				<script>
				function goBack() {
					window.history.go(-1)
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