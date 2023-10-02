<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/19/2023
  Time: 10:30 PM
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
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Cửa Hàng</h3>
        <div class="text-danger">${sessionScope.mess_error}</div>
        <form action="/cua-hang/add" method="post">
            <div class="mb-3">
                <label class="form-label">Ma</label>
                <input type="text" class="form-control" name="ma">
            </div>
            <div class="mb-3">
                <label class="form-label">Ten</label>
                <input type="text" class="form-control" name="ten">
            </div>
            <div class="mb-3">
                <label class="form-label">Dia chi</label>
                <input type="text" class="form-control" name="diaChi">
            </div>
            <div class="mb-3">
                <label class="form-label">Thanh pho</label>
                <input type="text" class="form-control" name="thanhPho">
            </div>
            <div class="mb-3">
                <label class="form-label">Quoc Gia</label>
                <input type="text" class="form-control" name="quocGia">
            </div>
            <button type="submit" class="btn btn-primary">ADD</button>
        </form>
    </div>
</body>
</html>
