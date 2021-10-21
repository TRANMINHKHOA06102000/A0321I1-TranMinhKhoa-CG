<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Contract</title>
    <link rel="stylesheet" href="assert/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2>List of Contract</h2>
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
    <a href="/createContract">Create</a>
    <table class="table table-striped table-bordered" id="tableCustomer">
        <thead>
        <tr>
            <th scope="col">contract_id</th>
            <th scope="col">contract_start_date</th>
            <th scope="col">contract_end_date</th>
            <th scope="col">contract_deposit</th>
            <th scope="col">contract_total_money</th>
            <th scope="col">employee_id</th>
            <th scope="col">customer_id</th>
            <th scope="col">service_id</th>
<%--            <th scope="col">Action</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contract" items="${listContract}">
            <tr>
                <td>${contract.contract_id}</td>
                <td>${contract.contract_start_date}</td>
                <td>${contract.contract_end_date}</td>
                <td>${contract.contract_deposit}</td>
                <td>${contract.contract_total_money}</td>
                <td>${contract.employee_id}</td>
                <td>${contract.customer_id}</td>
                <td>${contract.service_id}</td>
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
