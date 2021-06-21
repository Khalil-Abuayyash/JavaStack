<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/languages">Dashboard</a>
<p>${language.name}</p>
<p>${language.creator}</p>
<p>${language.currentVersion}</p>

<a href="/languages/delete/${language.id}">delete</a>
<a href="/languages/edit/${language.id}">edit</a> 
</body>
</html>