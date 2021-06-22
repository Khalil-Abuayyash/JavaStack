<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Song</title>
</head>
<body>
    <header>
        <a href="/dashboard">Dashboard</a>
    </header>

    <main>
        <form:form  action="/songs" method="POST" modelAttribute="song">
            <p>
                <form:label path="title">Name</form:label>
                <form:errors path="title"/>
                <form:input path="title"/>
            </p>

            <p>
                <form:label path="artist">Artist</form:label>
                <form:errors path="artist"/>
                <form:input path="artist"/>
            </p>
            
            <p>
                <form:label path="rating">Rating</form:label>
                <form:errors path="rating"/>
                <form:input type="number" path="rating"/>
            </p>

            <input type="submit" value="Add Song"/>

        </form:form>
    </main>
</body>
</html>

