<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/search" , method="post">
    <label>English</label>
    <input type="text" name="word" required placeholder="search">
    <input type="submit" value="search">
</form>
<hr>
<c:if test="${vietnamese != null}">
    <h3>English: ${english}</h3>
    <h3 style="color: red">Tiếng Việt: ${vietnamese}</h3>
</c:if>
</body>
</html>
