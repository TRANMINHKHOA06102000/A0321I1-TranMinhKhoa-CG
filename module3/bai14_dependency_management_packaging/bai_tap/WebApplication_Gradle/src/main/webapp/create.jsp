
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post">
    <label for="fname">Id user:</label><br>
    <input type="text" id="fid" name="id" disabled="disabled" value="<c:out value="${idAuto}"/>"><br>
    <label for="fname">Name user:</label><br>
    <input type="text" id="fname" name="name"><br>
    <label>Email :</label><br>
    <input type="text" name="email"><br>
    <label>Country:</label><br>
    <input type="text" name="country"><br>
    <input type="submit" value="submit">
</form>
<%--<label><c:out value="${msg}"/>--%>
</body>
</html>
