<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <header>
        <a href="/songs/new">Add New</a>
        <a href="/search/topTen">Top Songs</a>
        <form action="/search" method="GET">
            <input type="text" name="q">
            <input type="submit" value="Search Artist"> 
        </form>
        
    </header>

    <main>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                    <th>actions</th>
                </tr>
            
            </thead>

            <tbody>
                <c:forEach items="${songs}" var="song">
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