<%@ page import="com.codegym.model.com.codegym.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Delete product</h1>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
    <form method="post">
        <div class="mb-3">
            <label for="productId" class="form-label">Product ID</label>
            <input type="text" disabled class="form-control" id="productId" name="id" value="${requestScope["product"].getId()}">
        </div>
        <div class="mb-3">
            <label for="productName" class="form-label">Product Name</label>
            <input type="text" disabled class="form-control" id="productName" name="name" value="${requestScope["product"].getName()}">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="text" disabled class="form-control" id="price" name="price" value="${requestScope["product"].getPrice()}">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" disabled class="form-control" id="description" name="description" value="${requestScope["product"].getDescription()}">
        </div>
        <h3>Are you sure to delete this product?</h3>
        <button type="submit" class="btn btn-primary">Delete this product</button>
        <a href="/products">Back to list</a>

    </form>
</div>
</body>
</html>