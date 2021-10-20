<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<h2>Insert A Service</h2>
<a href="/services">Back</a>
<div>
    <form method="post" action="/createService">
        <table border="1" cellpadding="5">
            <%--            <input type="hidden" name="service_id" id="service_id" size="45"/>--%>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="service_name" id="service_name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="service_area" id="service_area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td>
                    <input type="text" name="service_cost" id="service_cost" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Max_people:</th>
                <td>
                    <input type="text" name="service_max_people" id="service_max_people" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Rent_type_id:</th>
                <td>
                    <input type="text" name="rent_type_id" id="rent_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service_type_id:</th>
                <td>
                    <input type="text" name="service_type_id" id="service_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Standard_room:</th>
                <td>
                    <input type="text" name="standard_room" id="standard_room" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description_other_convenience:</th>
                <td>
                    <input type="text" name="description_other_convenience" id="description_other_convenience"
                           size="45"/>
                </td>
            </tr>
            <tr>
                <th>Pool_area:</th>
                <td>
                    <input type="text" name="pool_area" id="pool_area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Number_of_floors:</th>
                <td>
                    <input type="text" name="number_of_floors" id="number_of_floors" size="45"/>
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
