<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things</title>
	</head>
	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="pageTitle" value="My Favorite Things" />
	</c:import>
	<div id="favoriteBooks">
	<h2>Favorite Books:</h2>
		<img id="freak" src="https://images-na.ssl-images-amazon.com/images/I/51mb6DELsQL._SX330_BO1,204,203,200_.jpg"/>
		<img id="roaso" src="https://images-na.ssl-images-amazon.com/images/I/61m0lVmBNLL._SX394_BO1,204,203,200_.jpg"/>
		<img id="crowds" src="https://images-na.ssl-images-amazon.com/images/I/51WcufjcOpL._SX398_BO1,204,203,200_.jpg"/>
		<img id="predictioneer" src="https://images-na.ssl-images-amazon.com/images/I/512Tb60u71L._SX327_BO1,204,203,200_.jpg"/>
		<img id="artOfWar" src="https://images-na.ssl-images-amazon.com/images/I/41%2BK7kV3iTL._SX325_BO1,204,203,200_.jpg"/>
		<img id="daVinci" src="https://images-na.ssl-images-amazon.com/images/I/41cXJLj3BkL._SX277_BO1,204,203,200_.jpg"/>
		<img id="crash" src="https://images-na.ssl-images-amazon.com/images/I/51%2BGPmtiL%2BL._SX325_BO1,204,203,200_.jpg"/>
		<img id="wizards" src="https://images-na.ssl-images-amazon.com/images/I/51IE-eZrxTL._SX332_BO1,204,203,200_.jpg"/>
	</div>
	<div id="favoriteFood">
	<h2>Favorite Food:</h2>
	<h3 id="sushi">Sushi or <a href="https://chipotle.com">Chipotle</a></h3>
	<img src="https://yourlifeisastory.files.wordpress.com/2013/02/omi-sushi-2.png"/>
	</div>
	<div id="activities">
		<h2>Favorite Activities (other than programming and trading):</h2>
		<ul>
			<li>Sportz (table tennis, basketball, soccer)</li>
			<li>Hiking</li>
			<li>Poker</li>
			<li>Bananagrams</li>
		</ul>
	</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />