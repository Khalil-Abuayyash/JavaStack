<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
</head>
<body>
    <header>
        <h4>Songs by artist: ${searched}</h4> 
        <form action="/search" method="GET">
            <input type="text" name="q">
            <input type="submit" value="Search Artist"> 
        </form>
        <a href="/dashboard">Dashboard</a>
    </header>

    <main>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>rating</th>
                    <th>actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${resultSongs}" var="song">
                    <tr>
                        <td><a href="/songs/${song.id}">${song.title}</a></td>
                        <td>${song.rating}</td>
                        <td>
                            <form action="/songs/${song.id}" method="POST">
                                <input type="hidden" name="_method" value="delete">
                                <input type="submit" value="Delete">
                            </form> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>