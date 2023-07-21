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
        <h3 style="text-align: center;margin-top:15px;">Quản lý Khách Hàng</h3>
        <a href="/khach-hang/view-add" class="btn btn-primary">Add</a>
        <table class="table">
            <thead>
                <tr>
                    <td>STT</td>
                    <td>Mã</td>
                    <td>Họ và tên</td>
                    <td>Ngày sinh</td>
                    <td>SDT</td>
                    <td>Địa chỉ</td>
                    <td>Thành phố</td>
                    <td>Quốc gia</td>
                    <td>Mật khẩu</td>
                    <td>Active</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listKhachHang}" var="kh" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${kh.ma}</td>
                        <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                        <td>${kh.ngaySinh}</td>
                        <td>${kh.sdt}</td>
                        <td>${kh.diaChi}</td>
                        <td>${kh.thanhPho}</td>
                        <td>${kh.quocGia}</td>
                        <td>${kh.matKhau}</td>
                        <td>
                            <a href="/khach-hang/detail?ma=${kh.ma}" class="btn btn-success">Detail</a>
                            <a href="/khach-hang/delete?ma=${kh.ma}" class="btn btn-success">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
