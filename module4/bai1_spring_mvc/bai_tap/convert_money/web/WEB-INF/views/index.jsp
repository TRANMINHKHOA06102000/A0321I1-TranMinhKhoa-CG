<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>convert</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
    <label>USD</label>
    <input type="number" name="usd"><br>
    <label>Rate: 23000 VND/USD</label><br>
    <input type="submit" value="convert">
</form>
</body>
</html>
