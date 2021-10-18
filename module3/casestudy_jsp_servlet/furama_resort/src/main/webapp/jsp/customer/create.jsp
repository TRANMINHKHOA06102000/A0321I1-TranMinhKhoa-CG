<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<h2>Insert A Customer</h2>
<a href="/customers">Back</a>
<div>
    <form method="post" action="/createCustomer">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID Customer Type:</th>
                <td>
                    <input type="text" name="idCustomerType" id="idCustomerType" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                    <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgName}"/>
                </td>
            </tr>
            <tr>
                <th>BirthDay:</th>
                <td>
                    <input type="text" name="birthDay" id="birthDay" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" id="gender" size="45"/>
                </td>
            </tr>
            <tr>
                <th>ID Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45"/>
                    <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgIdCard}"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                    <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgPhone}"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                    <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgEmail}"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
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
