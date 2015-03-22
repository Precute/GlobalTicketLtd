<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="congo.*,java.util.*"%>
	<%DAOMusic mconnect = new DAOMusic();
	DAOVideo vconnect = new DAOVideo(); %>
	<!-- 13153439 Huseyin Arpalikli
This jsp displays the home page-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home || CongoCorp Entertainment Store</title>
<link rel="stylesheet" type="text/css" href="design.css" />
</head>
<body>
	<div id="wrapper">
		<div id="headerwrap">
			<div id="header">
				<div id="logo">
					<img
						style="height: auto; width: auto; max-width: 100px; max-height: 75px;"
						src="images/logo1.png" id="congocorpLogo">
				</div>
				<h1>CongoCorp Entertainment Store</h1>
			</div>
		</div>
		<div id="navigationwrap">
			<div id="navigation">
				<div id="tabs24">
					<ul>
						<li><a href='index.jsp' title='Home Page' class='current'><span>Home
									Page</span></a></li>
						<li><a href='videos.jsp' title='Video Listing'><span>Video
									Listing</span></a></li>
						<li><a href='actors-listing.jsp' title='Video Actors Listing'><span>Video Actors
						Listing</span></a></li>										
						<li><a href='music.jsp' title='Music Listing'><span>Music
									Listing</span></a></li>
						<li><a href='tracks-listing.jsp' title='Music Tracks Listing'><span>Tracks Listing</span></a></li>			
						<li><a href='basket.jsp' title='Shopping Basket'><span>Shopping Basket</span></a></li>			
						<li><a href='customer-account.jsp' title='Customer Area'><span>Customer Area</span></a></li>
						<li><a href='admin-account.jsp' title='Staff Area'><span>Staff Area</span></a></li>
					</ul>
				</div>
			</div>
		</div>
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
					Welcome to our new website!<br> <br> Feel free to browse
					for information about CongoCorp, as well as purchase music and
					videos. This is just the start of our presence online and we are
					expecting to our online presence to expand over the coming months.<br>
					
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
				<i><span>CongoCorp Entertainment Store, 123 Old Church St, Newton Heath, Manchester, M10 2DA</span></i>
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