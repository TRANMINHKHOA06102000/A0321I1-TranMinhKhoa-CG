<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Menu condiment Sandwich</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="/save" method="post">
    <input type="checkbox" id="condiment1" name="condiment" value="Lettuce">
    <label for="condiment1">Lettuce</label><br>
    <input type="checkbox" id="condiment2" name="condiment" value="Tomato">
    <label for="condiment2">Tomato</label><br>
    <input type="checkbox" id="condiment3" name="condiment" value="Mustard">
    <label for="condiment3"> Mustard</label><br>
    <input type="checkbox" id="condiment4" name="condiment" value="Sprouts">
    <label for="condiment4"> Sprouts</label><br><br>
    <input type="submit" value="Submit">
</form>
<label>List condiments chose: <span style="color: red">
   <c:if test="${listcondiment.isEmpty()}">
       <c:out value="you need to choose at least one condiment"/>
   </c:if>
    ${listcondiment}
</span></label>
<label><c:out value="${message}"/></label>
</body>
</html>
