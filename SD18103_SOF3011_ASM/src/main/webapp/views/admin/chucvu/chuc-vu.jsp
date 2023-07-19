<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/19/2023
  Time: 8:05 PM
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
        <h3 style="text-align: center;margin-top:15px;">Quản lý Chức Vụ</h3>
        <a href="/chuc-vu/view-add" class="btn btn-primary">ADD</a>
        <table class="table">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Ma</td>
                    <td>Ten</td>
                    <td>Active</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listChucVu}" var="cv">
                    <tr>
                        <td>${cv.id}</td>
                        <td>${cv.ma}</td>
                        <td>${cv.ten}</td>
                        <td>
                            <a href="/chuc-vu/detail?ma=${cv.ma}" class="btn btn-primary">Detail</a>
                            <a href="/chuc-vu/delete?ma=${cv.ma}" class="btn btn-primary">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
