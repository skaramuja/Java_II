<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Truth or Dare</title>
</head>
	<body>
		<h1>Truth or Dare</h1>
		<form action="getTruthOrDare" method="post">
			<p>
				What would you like to do?
			<p>
			<input type="submit" value="Truth" name="truth" /> <input
				type="submit" value="Dare" name="dare" />
		</form>
	</body>
</html>