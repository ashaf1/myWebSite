<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Contact Me</title>
		<script src="javascript/jquery-2.2.2.js"></script>
		<script src="javascript/jquery.validate.js"></script>
	</head>
	<c:import url="/WEB-INF/jsp/header.jsp">
	   <%--  <c:param name="pageTitle" value="Contact Me" /> --%>
	</c:import> 
	<body>

<div id="content">
    <div class="container-fluid">
    <nav class="nav navbar-default col-sm-12">
    		<ul class="nav navbar-nav">
    			<li><a href="home">Home</a></li>
    			<li><a href="favoriteThings">My Favorite Things</a></li>
    			<li><a href="funWithStocks">Fun With Stocks!</a></li>
    			<li><a href="contact">Contact Me</a></li>
    		</ul>
    </nav>
    </div>
    <%-- <c:param name="pageTitle" value="Contact Me"/> --%>
    <h1 id="pageTitle">Contact Me</h1>
	<h3>Email me at aaronshafron@gmail.com</h3>
	<h3>Connect with me on <a href="https://www.linkedin.com/in/aaronshafron" target="_blank">LinkedIn</a></h3>
	
	</div> 

<p class="footer"> Aaron Shafron 2016</br>
Hosted by Heroku, Domain through NameCheap
</p>

</body>

</html>
	
<%-- <c:import url="/WEB-INF/jsp/footer.jsp" /> --%>