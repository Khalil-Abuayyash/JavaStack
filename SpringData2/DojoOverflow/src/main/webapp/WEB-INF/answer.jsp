<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question Profile</title>
</head>
<body>
    <header>
        <h1>
            ${question.question}
        </h1>
    </header>
    <main>
        <h2>Tags:
            <c:forEach items="${question.tags}" var="tag">
                <span>${tag}</span>
            </c:forEach>
        </h2>
        <section>
            <table>
                <thead>
                    <tr>
                        <th>Answers</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${question.answers}" var="answer">
                        <tr>
                            <td>${answer.answer}</td>
                        </tr>                 
                    </c:forEach>
                </tbody>
            </table>

            <form:form action="/questions/${question.id}" method="POST" modelAttribute="an">
                <h1>Add your answer:</h1>
                <p>
                    Answer: <form:input path="answer" />
                </p>
                <input type="submit" value="Answer it">
            </form:form>
        </section>
    </main>
</body>
</html>