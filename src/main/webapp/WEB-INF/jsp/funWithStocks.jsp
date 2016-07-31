<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Fun With Stocks!</title>
	</head>
	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="pageTitle" value="Fun With Stocks!" />
	</c:import>
	<form action="funWithStocks" method="POST">
		<div id="dateInput">
			<label>Start Date</label><input type="date" name="begin"/>
			<label>End Date</label><input type="date" name="end"/>
		</div>
		<div id="selection1">	
			<div id="sel1Input">
				<input type="radio" name="databaseName1" value="snpdata"/><label>S&P 500</label>
				<input type="radio"	 name="databaseName1" value="aapldata"/><label>Apple</label>
				<input type="radio" name="databaseName1" value="msftdata"/><label>Microsoft</label>
				<input type="radio" name="databaseName1" value="orcldata"/><label>Oracle</label>
			</div>
		</div>
		<div id="selection2">
			<div id="sel2Input">
				<input type="radio" name="databaseName2" value="snpdata"/><label>S&P 500</label>
				<input type="radio"	 name="databaseName2" value="aapldata"/><label>Apple</label>
				<input type="radio" name="databaseName2" value="msftdata"/><label>Microsoft</label>
				<input type="radio" name="databaseName2" value="orcldata"/><label>Oracle</label>
			</div>	
		</div>
		<div id = "submitButton">
			<input type ="submit" name ="Submit"/>
		</div>
	</form>
	<h3>Results</h3>
	<table id="results">
	<c:choose>
		<c:when test="${database1 != null && database2 == null}">
			
				<tr>
					<th>Max Price</th>
					<th>Min Price</th>
					<th>Avg Volume</th> 
					<th>Max Volume</th>
					<th>Min Volume</th>
					<th>Dollar Change</th>
					<th>Percentage Change</th>
					<th>Standard Deviation</th>
				</tr>
				<tr>
					<td>"${data.maxPrice}"</td>
					<td>"${data.minPrice}"</td>
					<td>"${data.avgVolume}"</td>
					<td>"${data.maxVolume}"</td>
					<td>"${data.minVolume}"</td>
					<td>"${data.maxPrice}"</td>
					<td>"${data.maxPrice}"</td>
					<td>"${data.maxPrice}"</td>
				</tr>
			</c:when>
		<c:when test="${database1 != null && database2 != null}">
			<tr>
				<th>Correlation</th>
				<th>Y Intercept</th>
				<th>X Regression Slope</th>
			</tr>
			<tr>
				<td>"${data.correlation}"</td>
				<td>"${data.yIntercept}"</td>
				<td>"${data.regCoef}"</td>
			</tr>
		</c:when>	
	</c:choose>	
	</table>
	
<c:import url="/WEB-INF/jsp/footer.jsp" />