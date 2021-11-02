<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/product?action=create" method="post">

        <div class="form-group">
            <label for="product_name">Name</label>
            <input type="text" class="form-control" id="product_name" value="${product.product_name}"
                   name="product_name" required  minlength=1 maxlength="50">
        </div>

        <div class="form-group">
            <label for="product_price">Price</label>
            <input type="text" class="form-control" id="product_price" name="product_price"
                   value="${product.product_price}"
                   required minlength="1"
                   maxlength="15">
        </div>

        <div class="form-group">
            <label for="product_quantity">Quantity</label>
            <input type="text" class="form-control" id="product_quantity" name="product_quantity"
                   value="${product.product_quantity}"
                   required minlength="1"
                   maxlength="15">
        </div>

        <div class="form-group">
            <label for="product_color">Color</label>
            <select class="form-control" id="product_color" name="product_color" required>
                <option value="ĐỎ">Đỏ</option>
                <option value="Xanh">Xanh</option>
                <option value="Đen">Đen</option>
                <option value="Trắng">Trắng</option>
                <option value="Vàng">Vàng</option>
            </select>
        </div>

        <div class="form-group">
            <label for="product_description">Description</label>
            <input type="text" class="form-control" id="product_description" name="product_description"
                   value="${product.product_description}"
                   required minlength="1"
                   maxlength="15">
        </div>

        <div class="form-group">
            <label for="category_id">Category</label>
            <select class="form-control" id="category_id" name="category_id" required>
                <c:forEach var="category" items="${list}">
                    <option value="${category.category_id}">${category.category_name}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Lưu</button>
        <button type="button" class="btn btn-success">
            <a href="/" class="text-white">Quay Lại</a>
        </button>
    </form>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
