<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/20/2023
  Time: 7:32 PM
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
        <h3 style="text-align: center;margin-top:15px;">Quản lý Dòng Sản Phẩm</h3>
        <a href="/dong-sp/view-add" class="btn btn-primary">Add</a>
        <c:if test="${ f:length(listDongSP) == 0 }">
            <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(listDongSP) != 0 }">
            <table class="table">
                <thead>
                <tr>
                    <td>STT</td>
                    <td>Mã</td>
                    <td>Tên</td>
                    <td>Active</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listDongSP}" var="dsp" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${dsp.ma}</td>
                        <td>${dsp.ten}</td>
                        <td>
                            <a href="/dong-sp/detail?ma=${dsp.ma}" class="btn btn-success">Detail</a>
                            <a href="/dong-sp/delete?ma=${dsp.ma}" class="btn btn-success">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
