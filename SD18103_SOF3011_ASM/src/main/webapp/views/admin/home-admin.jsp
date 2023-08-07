<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="d-flex mt-5" style="margin-left: 20px" id="wrapper" >
        <!-- Sidebar-->
        <div class="border-end bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading border-bottom bg-light">ADMIN</div>
            <div class="list-group list-group-flush">
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/chuc-vu/hien-thi">Chức vụ</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/cua-hang/hien-thi">Cửa Hàng</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/nhan-vien/hien-thi">Nhân Viên</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/khach-hang/hien-thi">Khách Hàng</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/san-pham/hien-thi">Sản phẩm</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/nsx/hien-thi">Nhà sản xuất</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/mau-sac/hien-thi">Màu sắc</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/dong-sp/hien-thi">Dòng sản phẩm</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3"
                   href="/chi-tiet-san-pham/hien-thi">Chi tiết Sản phẩm</a>
            </div>
        </div>
        <div class="container-fluid">
            <h1></h1>
            <jsp:include page="${ view_chucVu }"/>
            <jsp:include page="${ view_cuaHang }"/>
            <jsp:include page="${ view_nhanVien }"/>
            <jsp:include page="${ view_khachHang }"/>
            <jsp:include page="${ view_sanPham }"/>
            <jsp:include page="${ view_NSX }"/>
            <jsp:include page="${ view_mauSac }"/>
            <jsp:include page="${ view_dongSP }"/>
            <jsp:include page="${ view_CTSP }"/>
        </div>
    </div>
</body>
</html>
