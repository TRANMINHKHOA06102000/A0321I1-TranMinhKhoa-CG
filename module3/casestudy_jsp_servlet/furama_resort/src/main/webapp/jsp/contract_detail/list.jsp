<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Contract Detail</title>
    <link rel="stylesheet" href="assert/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2>List of Contract Detail</h2>
<p>
    <c:if test='${message != null}'>
        <span class="message" style="color: green">${message}</span>
    </c:if>
</p>
<div class="col-lg-12">
<%--    <form action="/searchEmployee" method="post">--%>
<%--        <input type="text" placeholder="Search" name="search">--%>
<%--        <input type="submit" value="Search">--%>
<%--    </form>--%>
    <a href="/createContractDetail">Create</a>
    <table class="table table-striped table-bordered" id="tableCustomer">
        <thead>
        <tr>
            <th scope="col">contract_detail_id</th>
            <th scope="col">contract_id</th>
            <th scope="col">attach_service_id</th>
            <th scope="col">quantity</th>
<%--            <th scope="col">Action</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contractDetail" items="${listContractDetail}">
            <tr>
                <td>${contractDetail.contract_detail_id}</td>
                <td>${contractDetail.contract_id}</td>
                <td>${contractDetail.attach_service_id}</td>
                <td>${contractDetail.quantity}</td>
<%--                <td>--%>
<%--                    <a href="/editEmployee?id=${employee.employee_id}">Edit</a>--%>
<%--                    <a href="/deleteEmployee?id=${employee.employee_id}">Delete</a>--%>
<%--                </td>--%>
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
