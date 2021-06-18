<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo Survey Index</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h3>Submitted Info</h3>
    <table>
        <tr>
            <td>Name:</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>Dojo Location:</td>
            <td>${location}</td>
        </tr>
        <tr>
            <td>Favourite Language:</td>
            <td>${language}</td>
        </tr>
        <tr>
            <td>Comment:</td>
            <td>${comment}</td>
        </tr>
    </table>
</body>
</html>