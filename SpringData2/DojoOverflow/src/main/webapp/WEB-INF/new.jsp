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
    <title>New Question</title>
</head>
<body>
    <header>
        <h1>What is your question?</h1>
    </header>
    <main>
        <form:form method="post" action="/questions" modelAttribute="q">
            <p>
                Question:
                <form:textarea path="question" cols="30" rows="10"></form:textarea>
                <form:errors path="question"/>
            </p>
            <p>
                Tags:
                <form:input path="tags"/>
                <form:errors path="tags"/>
            </p>
            <input type="submit" value="Submit">
        </form:form>
        
    </main>
</body>
</html>