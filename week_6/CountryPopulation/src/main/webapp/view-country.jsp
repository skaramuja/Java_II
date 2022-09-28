<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country List</title>
</head>
<body>
	<h1> List of Countries</h1>
	<form method="post" action="navigationServlet">
		<table>
		<!-- jsp process allitems to display in a table-->
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<!-- ID is not displayed to the user but is passed to the  navigationServlet as a parameter-->
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.country}</td>
					<td>${currentitem.capital}</td>
					<td>${currentitem.population}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- user can view details, edit, delete, and add countries-->
		<input type="submit" value="edit" name="doThisToCountry"> 
		<input type="submit" value="delete" name="doThisToCountry"> 
		<input type="submit" value="add" name="doThisToCountry">
		<input type="submit" value="viewdetails" name="doThisToCountry">
	</form>
</body>
</html>