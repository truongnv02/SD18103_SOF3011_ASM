<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/30/2023
  Time: 11:02 PM
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
        <h3 style="text-align: center;margin-top:15px;">Quản lý Hoá Đơn</h3>
        <c:if test="${ f:length(listHoaDon) == 0}">
            <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(listHoaDon) != 0}">
            <table class="table">
                <thead>
                    <tr>
                        <td>STT</td>
                        <td>Mã</td>
                        <td>Mã Khách Hàng</td>
                        <td>Tên Khách Hàng</td>
                        <td>Địa Chỉ Khách Hàng</td>
                        <td>SDT Khách Hàng</td>
                        <td>Ngày Tạo</td>
                        <td>Ngày Thành Toán</td>
                        <td>Ngày Ship</td>
                        <td>Ngày Nhận</td>
                        <td>Ngày Thanh Toán</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach varStatus="status" items="${listHoaDon}" var="hd">
                        <tr>
                            <td>${status.index + 1}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
