<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country</title>
</head>
<body>
<h1>Add Country</h1>
	<!-- user selects to add country -->
	<form action="addCountryServlet" method="post">
		<p> Country: <input type="text" name="country" required> </p>
		<p> Capital City: <input type="text" name="capital" required> </p>
		<p> Total Population: <input type="text" name="population" required></p>
		<input type="submit" value="Add Country"> 
	</form>
	<br />
	<!--user selects to view all countries and link goes to viewAllCountriesServlet URL-->
	<a href="viewAllCountriesServlet">View list of Countries</a>
</body>
</html>