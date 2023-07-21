<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/20/2023
  Time: 3:21 PM
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
        <form action="/khach-hang/add" method="post">
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma">
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem">
                </div>
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <input type="text" class="form-control" name="thanhPho">
                </div>
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <input type="text" class="form-control" name="quocGia">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">SDT</label>
                    <input type="tel" class="form-control" name="sdt">
                </div>
                <div class="col-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau">
                </div>
            </div>

            <div class="row mt-4" style="justify-content: center">
                <a href="/khach-hang/hien-thi" class="btn btn-success col-1 m-3">Exit</a>
                <button class="btn btn-success col-1 m-3">Add</button>
            </div>
        </form>
    </div>
</body>
</html>
