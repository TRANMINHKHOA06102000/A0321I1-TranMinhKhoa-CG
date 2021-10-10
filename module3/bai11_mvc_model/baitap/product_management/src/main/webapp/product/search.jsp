<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/10/2021
  Time: 6:35 PM
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
        <legend>Product information</legend>
        <label for="fname">Name product:</label><br>
        <input type="text" id="fname" name="nameSearch"><br>
    </fieldset>
    <input type="submit" value="Submit"/>
</form>
<label><c:out value="${msgErr}"/>
</body>
</html>
