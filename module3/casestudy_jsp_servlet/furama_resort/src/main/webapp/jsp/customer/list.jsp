<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="assert/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2>List of Customer</h2>
<div class="col-lg-12">
    <a href="/customers?action=create">Create</a>
    <a href="/customers?action=search" style="margin-left: 5px;">Search</a>
    <table class="table table-striped table-bordered" id="tableCustomer">
        <thead>
        <tr>
            <th scope="col">ID Customer</th>
            <th scope="col">ID Customer Type</th>
            <th scope="col">Name</th>
            <th scope="col">BirthDay</th>
            <th scope="col">Gender</th>
            <th scope="col">ID Card</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td>${customer.customer_id}</td>
                <td>${customer.customer_type_id}</td>
                <td>${customer.customer_name}</td>
                <td>${customer.customer_birthday}</td>
                <td>${customer.customer_gender}</td>
                <td>${customer.customer_id_card}</td>
                <td>${customer.customer_phone}</td>
                <td>${customer.customer_email}</td>
                <td>${customer.customer_address}</td>
                <td>
                    <a href="/customers?action=edit&id=${customer.customer_id}">Edit</a>
                    <a href="/customers?action=delete&id=${customer.customer_id}">Delete</a>
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
            "pageLength": 2
        });
    });
</script>
</body>
</html>
