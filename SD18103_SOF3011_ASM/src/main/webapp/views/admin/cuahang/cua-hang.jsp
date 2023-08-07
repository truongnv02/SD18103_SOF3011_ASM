<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/19/2023
  Time: 10:29 PM
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
        <h3 style="text-align: center;margin-top:15px;">Quản Lý Cửa Hàng</h3>
        <a href="/cua-hang/view-add" class="btn btn-primary">ADD</a>
        <c:if test="${ f:length(listCuaHang) == 0 }">
            <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(listCuaHang) != 0 }">
        <table class="table">
            <thead>
            <tr>
                <td>ID</td>
                <td>Ma</td>
                <td>Ten</td>
                <td>Dia Chi</td>
                <td>Thanh Pho</td>
                <td>Quoc Gia</td>
                <td>Active</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCuaHang}" var="ch">
                <tr>
                    <td>${ch.id}</td>
                    <td>${ch.ma}</td>
                    <td>${ch.ten}</td>
                    <td>${ch.diaChi}</td>
                    <td>${ch.thanhPho}</td>
                    <td>${ch.quocGia}</td>
                    <td>
                        <a href="/cua-hang/detail?ma=${ch.ma}" class="btn btn-primary">Detail</a>
                        <a href="/cua-hang/delete?ma=${ch.ma}" class="btn btn-primary">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
    </div>
</body>
</html>
