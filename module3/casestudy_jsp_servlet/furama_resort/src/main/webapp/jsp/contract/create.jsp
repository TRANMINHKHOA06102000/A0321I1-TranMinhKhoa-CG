<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<h2>Insert A Contract</h2>
<a href="/contracts">Back</a>
<div>
    <form method="post" action="/createContract">
        <table border="1" cellpadding="5">
            <tr>
                <th>contract_start_date:</th>
                <td>
                    <input type="text" name="contract_start_date" id="contract_start_date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>contract_end_date:</th>
                <td>
                    <input type="text" name="contract_end_date" id="contract_end_date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>contract_deposit:</th>
                <td>
                    <input type="text" name="contract_deposit" id="contract_deposit" size="45"/>
                </td>
            </tr>
            <tr>
                <th>contract_total_money:</th>
                <td>
                    <input type="text" name="contract_total_money" id="contract_total_money" size="45"/>
                </td>
            </tr>
            <tr>
                <th>employee_id:</th>
                <td>
                    <input type="text" name="employee_id" id="employee_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>customer_id:</th>
                <td>
                    <input type="text" name="customer_id" id="customer_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>service_id:</th>
                <td>
                    <input type="text" name="service_id" id="service_id" size="45"/>
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
