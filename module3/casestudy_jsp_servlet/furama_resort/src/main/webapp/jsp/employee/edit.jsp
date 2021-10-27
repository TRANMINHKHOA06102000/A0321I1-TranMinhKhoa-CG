<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="assert/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<h2>Edit A Employee</h2>
<a href="/employees" class="btn btn-secondary" style="margin: 1px auto 5px 5px;">Back</a>
<div style="margin-left: 5px">
    <form method="post" action="/editEmployee">
        <table border="1" cellpadding="5">
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="${employee.employee_id}"/>
            </c:if>
            <tr>
                <th>employee_name:</th>
                <td>
                    <input type="text" name="employee_name" id="employee_name" size="45"
                           value="${employee.employee_name}"/>
                </td>
            </tr>
            <tr>
                <th>employee_birthday:</th>
                <td>
                    <input type="text" name="employee_birthday" id="employee_birthday" size="45"
                           value="${employee.employee_birthday}"/>
                </td>
            </tr>
            <tr>
                <th>employee_id_card:</th>
                <td>
                    <input type="text" name="employee_id_card" id="employee_id_card" size="45"
                           value="${employee.employee_id_card}"/>
                </td>
            </tr>
            <tr>
                <th>employee_salary:</th>
                <td>
                    <input type="text" name="employee_salary" id="employee_salary" size="45"
                           value="${employee.employee_salary}"/>
                </td>
            </tr>
            <tr>
                <th>employee_phone:</th>
                <td>
                    <input type="text" name="employee_phone" id="employee_phone" size="45"
                           value="${employee.employee_phone}"/>
                </td>
            </tr>
            <tr>
                <th>employee_email:</th>
                <td>
                    <input type="text" name="employee_email" id="employee_email" size="45"
                           value="${employee.employee_email}"/>
                </td>
            </tr>
            <tr>
                <th>employee_address:</th>
                <td>
                    <input type="text" name="employee_address" id="employee_address" size="45"
                           value="${employee.employee_address}"/>
                </td>
            </tr>
            <tr>
                <th>position_id:</th>
                <td>
                    <input type="text" name="position_id" id="position_id" size="45" value="${employee.position_id}"/>
                </td>
            </tr>
            <tr>
                <th>education_degree_id:</th>
                <td>
                    <input type="text" name="education_degree_id" id="education_degree_id" size="45"
                           value="${employee.education_degree_id}"/>
                </td>
            </tr>
            <tr>
                <th>division_id:</th>
                <td>
                    <input type="text" name="division_id" id="division_id" size="45" value="${employee.division_id}"/>
                </td>
            </tr>
            <tr>
                <th>username:</th>
                <td>
                    <input type="text" name="username" id="username" size="45" value="${employee.username}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" class="btn btn-primary"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
