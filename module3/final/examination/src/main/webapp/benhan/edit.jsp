<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sửa Thông tin bệnh án</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row bg-white p-lg-5">
        <div class="col-lg-12">
            <h3 class="text-center">Sửa Thông tin bệnh án</h3>
            <form action="/benhan?action=update&id=${customer.customer_id}" method="post">

                <div class="form-group">
                    <label for="ma_benh_an">Mã Bệnh Án</label>
                    <input type="text" class="form-control" id="ma_benh_an" name="ma_benh_an"
                           value="${benhAn.ma_benh_an}"
                           required readonly>
                </div>

                <div class="form-group">
                    <label for="ma_benh_nhan">Mã Bệnh Nhân</label>
                    <input type="text" class="form-control" id="ma_benh_nhan" name="ma_benh_nhan"
                           value="${benhAn.ma_benh_nhan}"
                           required readonly>
                </div>

                <div class="form-group">
                    <label for="benh_nhan">Tên Bệnh Nhân</label>
                    <select class="form-control" id="benh_nhan" name="ma_benh_nhan" required>
                        <c:forEach var="benhNhan" items="${benhNhanList}">
                            <c:choose>
                                <c:when test="${benhNhan.ma_benh_nhan == benhAn.ma_benh_nhan}">
                                    <option selected value="${benhNhan.ma_benh_nhan}">${benhNhan.ten_benh_nhan}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${benhNhan.ma_benh_nhan}">${benhNhan.ten_benh_nhan}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group">
                    <label for="ngay_nhap_vien">Ngày Nhập Viện</label>
                    <input type="date" class="form-control" id="ngay_nhap_vien" name="ngay_nhap_vien"
                           value="${benhAn.ngay_nhap_vien}" required>
                </div>

                <div class="form-group">
                    <label for="ngay_ra_vien">Ngày Ra Viện</label>
                    <input type="date" class="form-control" id="ngay_ra_vien" name="ngay_ra_vien"
                           value="${benhAn.ngay_ra_vien}" required>
                </div>

                <div class="form-group">
                    <label for="ly_do">Lý Do</label>
                    <input type="text" class="form-control" id="ly_do" name="ly_do"
                           value="${benhAn.ly_do}"
                           required>
                </div>
                <button type="submit" class="btn btn-primary">Lưu</button>
                <button type="button" class="btn btn-success">
                    <a href="/" class="text-white">Quay Lại</a>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>