<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Service</title>
    <link rel="stylesheet" href="assert/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2>List of Service</h2>
<p>
    <c:if test='${message != null}'>
        <span class="message" style="color: green">${message}</span>
    </c:if>
</p>
<div class="col-lg-12">
    <form action="/" method="post">
        <input type="text" placeholder="Search" name="search">
        <input type="submit" value="Search">
    </form>
    <a href="/createService">Create</a>
    <table class="table table-striped table-bordered" id="tableCustomer">
        <thead>
        <tr>
            <th scope="col">ID Service</th>
            <th scope="col">Name</th>
            <th scope="col">Area</th>
            <th scope="col">Cost</th>
            <th scope="col">Max_people</th>
            <th scope="col">Rent_type_id</th>
            <th scope="col">Service_type_id</th>
            <th scope="col">Standard_room</th>
            <th scope="col">Description_other_convenience</th>
            <th scope="col">Pool_area</th>
            <th scope="col">Number_of_floors</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${listServices}">
            <tr>
                <td>${service.service_id}</td>
                <td>${service.service_name}</td>
                <td>${service.service_area}</td>
                <td>${service.service_cost}</td>
                <td>${service.service_max_people}</td>
                <td>${service.rent_type_id}</td>
                <td>${service.service_type_id}</td>
                <td>${service.standard_room}</td>
                <td>${service.description_other_convenience}</td>
                <td>${service.pool_area}</td>
                <td>${service.number_of_floors}</td>
                <td>
                    <a href="/?id=${service.service_id}">Edit</a>
                    <a href="/?id=${service.service_id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="assert/bootstrap/js/bootstrap.min.js"></script>
<script src="assert/jquery/jquery-3.5.1.min.js"></script>
<script src="assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
</body>
</html>
