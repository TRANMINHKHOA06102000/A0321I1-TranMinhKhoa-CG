<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<h2>Insert A Contract Detail</h2>
<a href="/contractDetail">Back</a>
<div>
    <form method="post" action="/createContractDetail">
        <table border="1" cellpadding="5">
            <tr>
                <th>contract_id:</th>
                <td>
                    <input type="text" name="contract_id" id="contract_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>attach_service_id:</th>
                <td>
                    <input type="text" name="attach_service_id" id="attach_service_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
