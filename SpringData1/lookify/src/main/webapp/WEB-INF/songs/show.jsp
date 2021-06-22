<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Song Show Page</title>
</head>
<body>
    <header>
        <a href="/dashboard">Dashboard</a>
    </header>

    <main>
        <section>
            <h1>Title</h1>
            <h1>${song.title}</h1>
        </section>
        <section>
            <h1>Atrist</h1>
            <h1>${song.artist}</h1>
        </section>
        <section>
            <h1>Rating (1-10)</h1>
            <h1>${song.rating}</h1>
        </section>
        <section>
            <form action="/songs/${song.id}" method="POST">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form>     
        </section>
        
    </main>
</body>
</html>