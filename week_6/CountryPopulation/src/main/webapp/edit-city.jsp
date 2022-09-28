<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit City</title>
</head>
<body>
	<form action="editCityServlet" method="post">
		<input type="hidden" name="countryId" value="${selectedCountry.id}"> 
		<input type="hidden" name="cityId" value="${cityToEdit.id}"> 
		<p>City: <input type="text" name="cityName" value="${cityToEdit.cityName}"></p>
		<p>Population: <input type="text" name="population" value="${cityToEdit.cityPopulation}"></p>
		<p>Size: <input type="text" name="size" value="${cityToEdit.size}"></p>
		<p><input type="submit" value="Save Edited City"></p>
	</form>
</body>
</html>