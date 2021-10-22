<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/14/2021
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" disabled="disabled" value="${requestScope["user"].getId()}"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="editName"  value="${requestScope["user"].getName()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="editEmail"  value="${requestScope["user"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="editCountry"  value="${requestScope["user"].getCountry()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update user"></td>
            </tr>
        </table>
    </fieldset>
    <label ><c:out value="${msgEdit}"/></label>
</form>

<a href="/user">Back to list user</a>
</body>
</html>
