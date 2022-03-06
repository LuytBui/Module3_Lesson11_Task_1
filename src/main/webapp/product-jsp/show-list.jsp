<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-around mt-5">
        <h1>${requestScope["listName"]}</h1>
        <a href="/products?action=search">
            <button class="btn btn-outline-success" >Search</button>
        </a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getId()}</a></td>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescription()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="6">
                <a href="/products?action=add" <c:if test = '${requestScope["hideAddNewProduct"]}'>style="visibility:hidden"</c:if> >Add new Product</a>
                <a href="/products" <c:if test = '${requestScope["hideBackToList"]}'>style="visibility:hidden"</c:if>>Back to list</a>
            </td>
        </tr>
        </tbody>
    </table>

</div>
</body>
</html>