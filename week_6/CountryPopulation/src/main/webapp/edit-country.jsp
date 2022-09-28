<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Country</title>
</head>
<body>
<!-- User modifies a country and editCountryServlet gets called at submission-->
	<h1>Edit Country:</h1>
	<form action="editCountryServlet" method="post">
		<p>Country: <input type="text" name="country" value="${countryToEdit.country}"></p>
		<p>Capital City: <input type="text" name="capital" value="${countryToEdit.capital}"></p>
		<p>Total Population: <input type="text" name="population" value="${countryToEdit.population}"></p>
		<input type="hidden" name="id" value="${countryToEdit.id}"> 
		<p><input type="submit" value="Save Edited Country"></p>
	</form>
</body>
</html>