<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/24/2021
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title></title>
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

    a.create {
      background: #ff6a1b;
      margin-left: 36px;
      font-size: 25px;
      width: 100px;
      display: inline-block;
      border-radius: 45%;
      text-align: center;
      height: 40px;
    }

    a.search {
      background: #ff6a1b;
      margin-left: 61px;
      font-size: 25px;
      width: 100px;
      display: inline-block;
      border-radius: 45%;
      text-align: center;
      height: 40px;
    }
  </style>
</head>
<body>
<center>

  <form class="example"  action="/user?actionUser=search" style="margin:auto;max-width:300px">
    <input type="hidden" name="actionUser" value="search">
    <input type="text" placeholder="Type user's name" name="searchName">
    <input type="submit" value="Submit">
  </form>

  <h1>User Management</h1>
  <div class="flex" style="display: flex;width: 50%;
  margin: 0 auto;justify-content: center;">
    <a class="create" href="/user?actionUser=create">Create</a>
    <%--        cách 2--%>
    <a class="search" href="/search">Search</a>
  </div>
</center>
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
    <c:forEach var="user" items="${listUser}">
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
  <label><c:out value="${msg}"/></label>
</div>
</body>
</html>
