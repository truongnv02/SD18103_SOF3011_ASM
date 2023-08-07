<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/20/2023
  Time: 5:48 PM
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
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Sản phẩm</h3>
        <div class="text-danger">${mess_error}</div>
        <form action="/san-pham/update" method="post" enctype="multipart/form-data">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${detailSanPham.ma}">
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${detailSanPham.ten}">
            </div>
            <div class="col-6">
                <label class="form-label">Hình ảnh</label> <br>
                <c:if test="${detailSanPham.image != null}">
                    <img src="<c:url value="/images/${detailSanPham.image}"/>" width="100px" height="80px">
                </c:if>
                <input type="file" class="form-control" name="image" value="${detailSanPham.image}">
            </div>
            <div class="row mt-4" style="justify-content: center">
                <a href="/san-pham/hien-thi" class="btn btn-success col-1 m-3">Exit</a>
                <button class="btn btn-success col-1 m-3">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
