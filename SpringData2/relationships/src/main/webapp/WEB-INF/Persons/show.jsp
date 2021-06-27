<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${person.firstName}${person.lastName}</h1>
	<p>License Number: ${person.license.number}</p>
	<p>State: ${person.license.state}</p>
	<p>Expiration Date: ${person.license.expirationDate}</p>
</body>
</html>