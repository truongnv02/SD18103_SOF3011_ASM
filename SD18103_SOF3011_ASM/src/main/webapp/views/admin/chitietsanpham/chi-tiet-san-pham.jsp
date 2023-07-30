<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/28/2023
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Quản lý Chi Tiết Sản Phẩm</h3>
        <a href="/chi-tiet-san-pham/view-add" class="btn btn-primary">Add</a>
        <c:if test="${ f:length(listCTSP) ==0}">
            <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listCTSP) != 0}">
            <table class="table">
                <thead>
                    <tr>
                        <td>STT</td>
                        <td>Sản phẩm</td>
                        <td>Màu sắc</td>
                        <td>Nhà sản xuất</td>
                        <td>Dòng sản phẩm</td>
                        <td>Năm bảo hành</td>
                        <td>Số lượng</td>
                        <td>Giá nhập</td>
                        <td>Giá bán</td>
                        <td>Mô tả</td>
                        <td>Active</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCTSP}" var="ctsp" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${ctsp.sanPham.getTen()}</td>
                            <td>${ctsp.mauSac.getTen()}</td>
                            <td>${ctsp.nsx.getTen()}</td>
                            <td>${ctsp.dongSP.getTen()}</td>
                            <td>${ctsp.namBH}</td>
                            <td>${ctsp.soLuongTon}</td>
                            <td>${ctsp.giaNhap}</td>
                            <td>${ctsp.giaBan}</td>
                            <td>${ctsp.moTa}</td>
                            <td>
                                <a href="/chi-tiet-san-pham/detail?id=${ctsp.id}" class="btn btn-primary">Detail</a>
                                <a href="/chi-tiet-san-pham/delete?id=${ctsp.id}" class="btn btn-primary">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
