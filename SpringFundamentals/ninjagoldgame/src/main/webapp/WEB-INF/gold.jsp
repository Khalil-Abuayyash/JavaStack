<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gold Ninja Game</title>
    <link rel="stylesheet" href="css/gold.css">
</head>
<body>
    <main>
        <section>
                <h1>Your Gold: <input type="text" value="${gold}" disabled></h1>
        </section>

        <section id="forms">
            <form action="/gold" method="POST">
                <h1>Farm</h1>
                <h4>(earns 10-20 gold)</h4>
                <input type="hidden" name="place" value="farm" id="">
                <input type="submit" value="Find Gold!">
            </form>

            <form action="/gold" method="POST">
                <h1>Cave</h1>
                <h4>(earns 5-10 gold)</h4>
                <input type="hidden" name="place" value="cave" id="">
                <input type="submit" value="Find Gold!">
            </form>

            <form action="/gold" method="POST">
                <h1>House</h1>
                <h4>(earns 2-5 gold)</h4>
                <input type="hidden" name="place" value="house" id="">
                <input type="submit" value="Find Gold!">
            </form>

            <form action="/gold" method="POST">
                <h1>Casino!</h1>
                <h4>(earns/takes 0-50 gold)</h4>
                <input type="hidden" name="place" value="casion" id="">
                <input type="submit" value="Find Gold!">
            </form>    
        </section>

        <section>
            <h1>Activities:</h1>
            <c:forEach items="${activities}" var="activity">
                <p>${activity}</p>
            </c:forEach>
        </section>

    </main>
</body>
</html>