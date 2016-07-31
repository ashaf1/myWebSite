<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
	</head>
	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="pageTitle" value="Welcome!" />
	</c:import>
<div id="welcome">
	<h2 class="headerText">Here's a bit about me:</h2>
</div>

<div id="doingNow">
	<h3>What I'm doing now:</h3>
</div>
<div id="doingNowP">
	<p>
	I am currently a Java bootcamp student at Tech Elevator in Cleveland, Ohio. Tech Elevator is a 14-week  
	intensive program focused on developing the skills necessary to create dynamic web-based applications using 
	 Java, Spring MVC, HTML, CSS, JavaScript, JQuery, AJAX, JavaServer Pages (JSP), Apache Tomcat, PostgreSQL, Java  
	Database Connectivity (JDBC), JUnit testing, unix command line, and the Eclipse IDE, among other things.   
	</p>
</div>
<div id="did">
	<h3>What I've done:</h3>
</div>
<div id="didP">
	<p>
	- After reading <a href="freakonomics.com"><i>Freakonomics</i></a> during my freshman year of high school, I fell in love with economics     
	</p>
	<p>
	- Fall of my freshman year (2009), I bought my first stock. Since then, I have traded equities, options, futures, and currencies using 
	fundamental as well as quantitative methods.   
	</p>
	<p>
	- Sophomore year, I founded the Shaker Heights High School Investment Club.             
	</p>
	<p>
	
	</p>
</div>	
	
<c:import url="/WEB-INF/jsp/footer.jsp" />