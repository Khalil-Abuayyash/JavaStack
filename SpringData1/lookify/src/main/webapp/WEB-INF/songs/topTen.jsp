<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Top Ten Songs</title>
</head>
<body>
    <header>
        <h1>Top Ten Songs:</h1>
        <a href="/dashboard">Dashboard</a>
    </header>

    <main>
        <c:forEach items="${topTenSongs}" var="song">
            <p>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
        </c:forEach>
    </main>
</body>
</html>