<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Result Calculator</h2>
<c:if test="${err != null}">
    <h3 style="color: red">Error: ${err}</h3>
</c:if>
<c:if test="${err == null}">
    <h3 style="color:darkblue;">Result: ${number1} ${ope} ${number2} = ${result}</h3>
</c:if>
</body>
</html>
