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
    <form action="/result" method="POST">
        <p>
            Your Name: <input type="text" name="name" required>
        </p>
        <p>
            Dojo Location: <input type="text" name="location" required> 
        </p>
        <p>
            Favorite Language:
            <select name="language" id="" required>
                <option value="python">Python</option>
                <option value="java">Java</option>
                <option value="php">Php</option>
            </select>
        </p>
        <p>
            Comment (optional): <br>
            <textarea name="comment" id="" cols="30" rows="10" name="comment">
                I love programming!
            </textarea>
        </p>
        <p>
            <input type="submit" placeholder="Submit">
        </p>
    </form>
</body>
</html>