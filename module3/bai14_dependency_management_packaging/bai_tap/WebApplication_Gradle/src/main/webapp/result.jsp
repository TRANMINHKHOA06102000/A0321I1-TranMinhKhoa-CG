<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/14/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            margin-left: auto;
            margin-right: auto;
            font-family: arial, sans-serif;
            border-collapse: collapse;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        a {
            text-decoration: none;
        }

        h2 {
            text-align: center;
        }
        a.back {
            background: #ff6a1b;
            margin-left: 61px;
            font-size: 18px;
            width: 123px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 32px;
            margin-top: 15px;
            padding-top: 7px;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Result User</h1>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/user?actionUser=edit&id=${user.id}">Edit</a>
                    <a href="/user?actionUser=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/user" class="back">Back to index</a>
</div>
</body>
</html>
