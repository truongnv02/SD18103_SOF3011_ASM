<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/19/2023
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Quản lý Nhân viên</h3>
        <a href="/nhan-vien/view-add" class="btn btn-primary">Add</a>
        <c:if test="${ f:length(listNhanVien) ==0}">
            <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listNhanVien) != 0}">
            <table class="table">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Mã</td>
                    <td>Họ và tên</td>
                    <td>Giới tính</td>
                    <td>Ngày sinh</td>
                    <td>Địa chỉ</td>
                    <td>SDT</td>
                    <td>Mật khẩu</td>
                    <td>Cửa hàng</td>
                    <td>Chức vụ</td>
                    <td>Trạng thái</td>
                    <td>Active</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listNhanVien}" var="nv" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${nv.ma}</td>
                        <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                        <td>${nv.gioiTinh}</td>
                        <td>${nv.ngaySinh}</td>
                        <td>${nv.diaChi}</td>
                        <td>${nv.sdt}</td>
                        <td>${nv.matKhau}</td>
                        <td>${nv.cuaHang.getTen()}</td>
                        <td>${nv.chucVu.getTen()}</td>
                        <td>${nv.trangThai == 1 ? "Đang làm" : "Đã nghỉ"}</td>
                        <td>
                            <a href="/nhan-vien/detail?ma=${nv.ma}" class="btn btn-primary">Detail</a>
                            <a href="/nhan-vien/delete?ma=${nv.ma}" class="btn btn-primary">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
