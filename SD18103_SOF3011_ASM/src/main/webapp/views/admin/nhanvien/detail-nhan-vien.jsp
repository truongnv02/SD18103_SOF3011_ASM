<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/19/2023
  Time: 11:14 PM
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
        <h3 style="text-align: center;margin-top:15px;">Thông tin nhân viên</h3>
        <div class="text-danger">${mess_error}</div>
        <form action="/nhan-vien/update" method="post">
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" value="${detailNhanVien.ma}">
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" value="${detailNhanVien.ten}">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" value="${detailNhanVien.tenDem}">
                </div>
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" value="${detailNhanVien.ho}">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" required value="${detailNhanVien.ngaySinh}">
                </div>
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" value="${detailNhanVien.diaChi}">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">SDT</label>
                    <input type="tel" class="form-control" name="sdt" value="${detailNhanVien.sdt}">
                </div>
                <div class="col-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" value="${detailNhanVien.matKhau}">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Cửa hàng</label>
                    <select class="form-control" name="idCuaHang" required>
                        <c:forEach items="${listCuaHang}" var="cuaHang">
                            <option value="${cuaHang.id}" ${cuaHang.id == idCuaHang ? "selected" : ""}>${cuaHang.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Chức vụ</label>
                    <select class="form-control" name="idChucVu" required>
                        <c:forEach items="${listChucVu}" var="chucVu">
                            <option value="${chucVu.id}" ${chucVu.id == idChucVu ? "selected" : ""}>${chucVu.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Giới tính</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="Nam" ${detailNhanVien.gioiTinh == "Nam" ? "checked" : ""} name="gioiTinh" checked>
                        <label class="form-check-label">
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="Nữ" ${detailNhanVien.gioiTinh == "Nữ" ? "checked" : ""} name="gioiTinh">
                        <label class="form-check-label">
                            Nữ
                        </label>
                    </div>
                </div>
                <div class="col-6">
                    <label class="form-label">Trạng thái</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="1" ${detailNhanVien.trangThai == 1 ? "checked" : ""} name="trangThai" checked>
                        <label class="form-check-label">
                            Đang làm
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="0" ${detailNhanVien.trangThai == 0 ? "checked" : ""} name="trangThai">
                        <label class="form-check-label">
                            Đã nghỉ
                        </label>
                    </div>
                </div>
            </div>
            <div class="row mt-4" style="justify-content: center">
                <a href="/nhan-vien/hien-thi" class="btn btn-primary col-1 m-3">Exit</a>
                <button class="btn btn-success col-1 m-3">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
