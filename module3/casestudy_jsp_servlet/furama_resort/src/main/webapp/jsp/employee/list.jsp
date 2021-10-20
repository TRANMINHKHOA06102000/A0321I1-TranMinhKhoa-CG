<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Employee</title>
    <link rel="stylesheet" href="assert/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2>List of Employee</h2>
<p>
    <c:if test='${message != null}'>
        <span class="message" style="color: green">${message}</span>
    </c:if>
</p>
<div class="col-lg-12">
    <form action="/searchEmployee" method="post">
        <input type="text" placeholder="Search" name="search">
        <input type="submit" value="Search">
    </form>
    <a href="/createEmployee">Create</a>
    <table class="table table-striped table-bordered" id="tableCustomer">
        <thead>
        <tr>
            <th scope="col">employee_id</th>
            <th scope="col">employee_name</th>
            <th scope="col">employee_birthday</th>
            <th scope="col">employee_id_card</th>
            <th scope="col">employee_salary</th>
            <th scope="col">employee_phone</th>
            <th scope="col">employee_email</th>
            <th scope="col">employee_address</th>
            <th scope="col">position_id</th>
            <th scope="col">education_degree_id</th>
            <th scope="col">division_id</th>
            <th scope="col">username</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td>${employee.employee_id}</td>
                <td>${employee.employee_name}</td>
                <td>${employee.employee_birthday}</td>
                <td>${employee.employee_id_card}</td>
                <td>${employee.employee_salary}</td>
                <td>${employee.employee_phone}</td>
                <td>${employee.employee_email}</td>
                <td>${employee.employee_address}</td>
                <td>${employee.position_id}</td>
                <td>${employee.education_degree_id}</td>
                <td>${employee.division_id}</td>
                <td>${employee.username}</td>
                <td>
                    <a href="/editEmployee?id=${employee.employee_id}">Edit</a>
                    <a href="/deleteEmployee?id=${employee.employee_id}">Delete</a>
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
