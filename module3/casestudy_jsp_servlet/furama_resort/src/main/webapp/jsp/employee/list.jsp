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
        <input type="submit" value="Search" class="btn btn-success">
    </form>
    <a href="/createEmployee" class="btn btn-primary">Create</a>
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
            <th scope="col" colspan="2" style="text-align: center">Action</th>
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
                    <a class="btn btn-primary" href="/editEmployee?id=${employee.employee_id}">Edit</a>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal"
                            onclick="setValueForm('${employee.employee_id}')">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/deleteEmployee">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input name="employee_id" id="employee_id" hidden>
                        Bạn có chắc muốn xoá ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
<script>
    function setValueForm(employee_id) {
        document.getElementById("employee_id").value = employee_id;
    }
</script>
</body>
</html>
