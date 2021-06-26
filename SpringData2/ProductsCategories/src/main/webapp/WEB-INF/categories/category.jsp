<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Page</title>
</head>
<body>
    <header>
        <h1>${category.name}</h1>
    </header>
    <main>
        <section>
            <h3>
                Products:
            </h3>
            <c:forEach items="${category.products}" var="product">
                 <p>- ${product.name}</p>
            </c:forEach>
            
        </section>
        <section>
            <form action="/categories/${category.id}/addProduct" method="POST">
                <input type="hidden" name="_method" value="put">
                Add Product:
                <select name="product">
                    <c:forEach items="${productsNotinCategory}" var="product">
                        <option value="${product.id}">
                            ${product.name}
                        </option>
                    </c:forEach>
                </select>
                <input type="submit" value="submit"/>
            </form>
        </section>
    </main>
</body>
</html>