<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/19/2023
  Time: 8:06 PM
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
        <h3 style="text-align: center;margin-top:15px;">Thông tin Chức Vụ</h3>
        <form action="/chuc-vu/update" method="post">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" value="${detailChucVu.id}" type="hidden" name="id">
            </div>
            <div class="mb-3">
                <label class="form-label">Ma</label>
                <input type="text" class="form-control" value="${detailChucVu.ma}" name="ma">
            </div>
            <div class="mb-3">
                <label class="form-label">Ten</label>
                <input type="text" class="form-control" value="${detailChucVu.ten}" name="ten">
            </div>
            <a href="/chuc-vu/hien-thi" class="btn btn-primary">Thoat</a>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
</body>
</html>
