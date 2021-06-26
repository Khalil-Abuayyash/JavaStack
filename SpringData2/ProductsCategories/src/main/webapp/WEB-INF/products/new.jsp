<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Product</title>
</head>
<body>
    <h1>New Product</h1>
    <form:form method="post" action="/products" modelAttribute = "product"> 
        <p>
            Name:
            <form:input path="name"/>
            <form:errors path="name"/>
        </p>
        <p>
            Description:
            <form:input path="description"/>
            <form:errors path="description"/>
        </p>
        <p>
            Price:
            <form:input path="price"/>
            <form:errors path="price"/>
        </p>
        <p>
            <input type="submit" value="submit"/>
        </p>
        
    </form:form>
</body>
</html>