<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount</title>
</head>
<body>
<form action="/ProductDiscountServlet" method="post">
    <h2>Product description</h2>
    <input type="text" name="description">
    <h2>Price</h2>
    <input type="text" name="price">
    <h2>Discount percent</h2>
    <input type="text" name="discount-percent">
    <br>
    <input type="submit" value="Submit" style="margin-top: 10px">
</form>
</body>
</html>