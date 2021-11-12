<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/caculator", method="post">
    <input type="text" name="number1" required>
    <input type="text" name="number2" required><br><br>
    <button type="submit" name="operator" value="+">Addition</button>
    <button type="submit" name="operator" value="-">Subtraction</button>
    <button type="submit" name="operator" value="*">Multiple</button>
    <button type="submit" name="operator" value="/">Division</button>
</form>
<hr>
    <c:if test="${error != null}">
        <h2 style="color: red">${error}</h2>
    </c:if>
    <c:if test="${result != null}">
        <h2 style="color: black">${result}</h2>
    </c:if>
</body>
</html>
