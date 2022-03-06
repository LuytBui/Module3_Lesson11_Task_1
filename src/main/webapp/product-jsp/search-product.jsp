<%@ page import="com.codegym.model.com.codegym.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
    </style>
</head>
<body>
<div class="container">
    <h1>Search product</h1>
    <form class="d-flex" method="post">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="key">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>
</body>
</html>