<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h2>SIMPLE CALCULATOR</h2>
<form action="/CalculatorServlet" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand:</td>
                <td><input name="num_one" type="text" id="num1" placeholder="Type first number here"/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator">
                        <option name="+" value="+">Addition</option>
                        <option name="-" value="-">Subtraction</option>
                        <option name="*" value="*">Multiplication</option>
                        <option name="/" value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second operand:</td>
                <td><input name="num_second" type="text" id="num2" placeholder="Type second number here"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
