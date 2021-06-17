<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Secret Code</title>
</head>
<body>
    <p>${wrong}</p>
    <p>What is the code</p>
    <form action="/code" method="POST">
        <input type="text" name="code">
        <input type="submit" placeholder="Try Code">
    </form>
</body>
</html>