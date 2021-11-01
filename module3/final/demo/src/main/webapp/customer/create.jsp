<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/customer?action=create" method="post">
        <div class="form-group">
            <label for="idCustomerType">Type Name</label>
            <select class="form-control" id="idCustomerType" name="idCustomerType" required>
                <c:forEach var="customerType" items="${list}">
                    <c:choose>
                        <c:when test="${customerType.customer_type_id == customer.customer_type_id}">
                            <option selected value="${customerType.customer_type_id}">${customerType.customer_type_name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${customerType.customer_type_id}">${customerType.customer_type_name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" value="${customer.customer_name}" name="name" required  minlength=1 maxlength="50">
        </div>

        <div class="form-group">
            <label for="birthDay">Birthday</label>
            <input type="date" class="form-control" id="birthDay" name="birthDay" value="${customer.customer_birthday}" required>
        </div>

        <div class="form-group">
            <label for="gender">Gender</label>
            <select class="form-control" id="gender" name="gender" required>
                <option ${customer.customer_gender ? 'selected':''} value="true">Nam</option>
                <option ${customer.customer_gender ? '':'selected'} value="false">Nữ</option>
            </select>
        </div>

        <div class="form-group">
            <label for="idCard">Card ID</label>
            <input type="text" class="form-control" id="idCard" name="idCard" value="${customer.customer_id_card}"
                   required minlength="7"
                   maxlength="15">
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${customer.customer_phone}"
                   required minlength="10">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${customer.customer_email}"
                   required>
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address"
                   value="${customer.customer_address}" required maxlength="50">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
        <button type="button" class="btn btn-success">
            <a href="/" class="text-white">Quay Lại</a>
        </button>
    </form>
</div>
<%--<a href="/" class="btn btn-success">back</a>--%>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
