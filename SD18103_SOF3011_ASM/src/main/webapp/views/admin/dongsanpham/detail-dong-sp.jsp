<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/20/2023
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Dòng Sản Phẩm</h3>
        <div class="text-danger">${mess_error}</div>
        <form action="/dong-sp/update" method="post">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${detailDongSP.ma}">
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${detailDongSP.ten}">
            </div>
            <div class="row mt-4" style="justify-content: center">
                <a href="/dong-sp/hien-thi" class="btn btn-success col-1 m-3">Exit</a>
                <button class="btn btn-success col-1 m-3">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
