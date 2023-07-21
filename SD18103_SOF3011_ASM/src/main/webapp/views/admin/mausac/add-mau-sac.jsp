<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/20/2023
  Time: 7:31 PM
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
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Màu Sắc</h3>
        <div class="text-danger">${mess_error}</div>
        <form action="/mau-sac/add" method="post">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control"  name="ma">
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control"  name="ten">
            </div>
            <div class="row mt-4" style="justify-content: center">
                <a href="/mau-sac/hien-thi" class="btn btn-success col-1 m-3">Exit</a>
                <button class="btn btn-success col-1 m-3">Add</button>
            </div>
        </form>
    </div>
</body>
</html>
