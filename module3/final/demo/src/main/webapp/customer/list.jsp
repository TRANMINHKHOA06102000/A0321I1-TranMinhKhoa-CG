<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<p>
    <c:if test='${message != null}'>
        <span class="message" style="color: green">${message}</span>
    </c:if>
</p>
<div class="container">
    <a href="/customer?action=create" class="btn btn-success mt-3">Thêm mới</a>
    <form action="/customer" method="get">
        <input name="action" value="search" hidden>
        <input type="text" name="nameSearch" placeholder="tìm kiếm theo tên">
        <input type="text" name="addressSearch" placeholder="tìm kiếm theo địa chỉ">
        <input type="text" name="typeNameSearch" placeholder="tìm kiếm theo loại khách">
        <button class="btn btn-success">Tìm kiếm</button>
    </form>
    <table id="page" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">STT</th>
<%--            <th scope="col">ID Customer</th>--%>
            <th scope="col">Name</th>
            <th scope="col">BirthDay</th>
            <th scope="col">Gender</th>
            <th scope="col">ID Card</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Customer Type</th>
            <th scope="col">Action</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="loop" var="customer" items="${customerList}">
            <tr>
                    <%--            count đếm từ 1--%>
                    <%--            index đếm từ 0--%>
                <td>${loop.count}</td>
<%--                <td>${customer.customer_id}</td>--%>
                <td>${customer.customer_name}</td>
                <td>${customer.customer_birthday}</td>
                <td>${customer.customer_gender ? 'Nam': 'Nữ'}</td>
                <td>${customer.customer_id_card}</td>
                <td>${customer.customer_phone}</td>
                <td>${customer.customer_email}</td>
                <td>${customer.customer_address}</td>
                <td>${customer.customer_type_name}</td>
                <td>
                    <button type="button" class="btn btn-info">
                        <a href="/customer?action=update&id=${customer.customer_id}" class="text-white">Sửa</a>
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="setValueForm('${customer.customer_id}')"
                            data-toggle="modal" data-target="#modalDelete">
                        Xoá
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Modal confirm delete -->
    <div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post" action="/customer?action=delete">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input name="idDelete" id="idDelete" hidden>
                        Bạn có chắc muốn xoá ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                        <button type="submit" class="btn btn-danger">Xoá</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#page').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
</script>
<script>
    function setValueForm(idDelete) {
        document.getElementById("idDelete").value = idDelete;
    }
</script>
</body>
</html>
