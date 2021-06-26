<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
</head>
<body>
    <header>
        <h1>${product.name}</h1>
    </header>
    <main>
        <section>
            <h3>
                Categories:
            </h3>
            <c:forEach items="${product.categories}" var="category">
                 <p>- ${category.name}</p>
            </c:forEach>
            
        </section>
        <section>
            <form action="/products/${product.id}/addCategory" method="POST">
                <input type="hidden" name="_method" value="put">
                Add Category:
                <select name="category">
                    <c:forEach items="${categoriesNotinProduct}" var="category">
                        <option value="${category.id}">
                            ${category.name}
                        </option>
                    </c:forEach>
                </select>
                <input type="submit" value="submit"/>
            </form>
        </section>
    </main>
</body>
</html>