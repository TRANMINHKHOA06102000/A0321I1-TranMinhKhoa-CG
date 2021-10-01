<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>currency_converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/CurrencyConverterServlet" method="post">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" /><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>