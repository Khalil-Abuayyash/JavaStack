<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Questions Dashboard</title>
</head>
<body>
    <header>
        <h1>
            Questions Dashboard
        </h1>
    </header>
    <main>
        <table>
            <thead>
                <tr>
                    <th>Questions</th>
                    <th>Tags</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${questions}" var="question">
                    <tr>
                        <td><a href="/questions/${question.id}">${question.question}</a></td>
                        <td>
                            <c:forEach items="${question.tags}" var="tag">
                                <span>${tag.subject},</span>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/questions/new">New Question</a>
    </main>
    
</body>
</html>