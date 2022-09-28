<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add City</title>
</head>
<body>
	<h1>Add a City to ${country.country}</h1>
		<form action="addCityServlet" method="post">
		<input type = "hidden" name = "id" value = "${country.id}">
			City Name: <input type="text" name="cityName"> 
			Population: <input type="text" name="population"> 
			Size (sq mi): <input type="text" name="size"> 
			<input type="submit" value="add" name="doThisToCity">
		</form>
</body>
</html>