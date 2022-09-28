<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Details</title>
</head>
<body>
<form action="cityNavigationServlet" method="post">
		<input type = "hidden" name = "countryId" value = "${countryToViewDetails.id}">
		<h1>${countryToViewDetails.country} </h1>
		<br /> 

		Capital: ${countryToViewDetails.capital}
		<br /> 
	
		Total Population: ${countryToViewDetails.population}
		<br /> 
	
		Cities:
		<br />  
		<table>
			<c:forEach items="${requestScope.allCities}" var="currentitem">
				<tr>
					<td><input type="radio" name="cityId" value="${currentitem.id}"></td>
					<td>${currentitem.getCityName()}</td>
					<td>${currentitem.getCityPopulation()}</td>
					<td>${currentitem.getSize()}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> 
		
		 <p>Add, Edit or Delete City:</p>
		 
		<!-- user can view details, edit, delete, and add city-->
		<input type="submit" value="edit" name="doThisToCity"> 
		<input type="submit" value="delete" name="doThisToCity"> 
		<input type="submit" value="add" name="doThisToCity">
	</form>
	
	<a href="viewAllCountriesServlet">Back To All Countries</a>
</body>
</html>