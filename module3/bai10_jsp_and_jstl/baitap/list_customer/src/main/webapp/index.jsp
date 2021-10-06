<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <style>
        table {
            border: 1px solid black;
            border-collapse: collapse;
            width: 50%;
        }
        th {
            padding: 5px;
            margin: 5px;
            border: 1px solid black;
            border-collapse: collapse;
        }
        td {
            margin: auto;
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
        img{
            width: 100px;
        }
    </style>
</head>
<body>
<h2>Danh Sách Khách Hàng</h2>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach varStatus="loop" var="customer" items="${customerFromServlet}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.address}</td>
            <td><img src="<c:url value="${customer.image}"/>"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
