<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit customer</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row bg-white p-lg-5">
        <div class="col-lg-12">
            <h3 class="text-center">Edit customer</h3>
            <form action="/customer?action=update&id=${customer.customer_id}" method="post">
                <div class="form-group">
                    <label for="type">Customer type</label>
                    <select class="form-control" id="type" name="type" required>
                        <c:forEach var="customerType" items="${customerTypes}">
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
                    <input type="text" class="form-control" id="name" name="name" value="${customer.customer_name}"
                           required>
                </div>

                <div class="form-group">
                    <label for="birthday">Birthday</label>
                    <input type="date" class="form-control" id="birthday" name="birthday"
                           value="${customer.customer_birthday}" required>
                </div>

                <div class="form-group">
                    <label for="birthday">Gender</label>
                    <select class="form-control" id="gender" name="gender" required>
                        <option ${customer.customer_gender ? 'selected':''} value="true">Nam</option>
                        <option ${customer.customer_gender ? '':'selected'} value="false">Nữ</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idCard">Card ID</label>
                    <input type="text" class="form-control" id="idCard" name="idCard" value="${customer.customer_id_card}"
                           required minlength="9"
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
                           value="${customer.customer_address}" required>
                </div>
                <button type="submit" class="btn btn-primary">Lưu</button>
                <button type="button" class="btn btn-success">
                    <a href="/" class="text-white">Quay Lại</a>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>