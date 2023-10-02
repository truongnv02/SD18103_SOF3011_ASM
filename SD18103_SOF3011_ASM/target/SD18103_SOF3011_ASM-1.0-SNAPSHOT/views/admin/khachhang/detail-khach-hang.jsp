<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/20/2023
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin khách hàng</h3>
        <div class="text-danger">${mess_error}</div>
        <form action="/khach-hang/update" method="post">
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" value="${detailKhachHang.ma}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" value="${detailKhachHang.ten}" required>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" value="${detailKhachHang.tenDem}" required >
                </div>
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" value="${detailKhachHang.ho}" required>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" value="${detailKhachHang.ngaySinh}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" value="${detailKhachHang.diaChi}" required>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <input type="text" class="form-control" name="thanhPho" value="${detailKhachHang.thanhPho}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <input type="text" class="form-control" name="quocGia" value="${detailKhachHang.quocGia}" required>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">SDT</label>
                    <input type="tel" class="form-control" name="sdt" value="${detailKhachHang.sdt}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" value="${detailKhachHang.matKhau}" required>
                </div>
            </div>
        </form>
        <div class="row mt-4" style="justify-content: center">
            <a href="/khach-hang/hien-thi" class="btn btn-success col-1 m-3">Exit</a>
            <button class="btn btn-success col-1 m-3">Update</button>
        </div>
    </div>
</body>
</html>
