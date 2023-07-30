<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 7/28/2023
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form action="/chi-tiet-san-pham/update" method="post">
            <h3 style="text-align: center;margin-top:15px;">Thông tin Chi Tiết Sản Phẩm</h3>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Sản phẩm</label>
                    <select class="form-control" name="idSanPham" required>
                        <c:forEach items="${listSanPham}" var="sanPham">
                            <option value="${sanPham.id}" ${sanPham.id == idSanPham ? "selected" : ""}>${sanPham.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Màu sắc</label>
                    <select class="form-control" name="idMauSac" required>
                        <c:forEach items="${listMauSac}" var="mauSac">
                            <option value="${mauSac.id}" ${mauSac.id == idMauSac ? "selected" : ""}>${mauSac.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Nhà sản xuất</label>
                    <select class="form-control" name="idNSX" required>
                        <c:forEach items="${listNSX}" var="nsx">
                            <option value="${nsx.id}" ${nsx.id == idNSX ? "selected" : ""}>${nsx.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Dòng sản phẩm</label>
                    <select class="form-control" name="idDongSP" required>
                        <c:forEach items="${listDongSP}" var="dongSP">
                            <option value="${dongSP.id}" ${dongSP.id == idDongSP ? "selected" : ""}>${dongSP.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Năm bảo hành</label>
                    <input type="number" min="1" class="form-control" name="namBH" value="${chiTietSP.namBH}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Số lượng tồn</label>
                    <input type="number" min="1" class="form-control" name="soLuongTon" value="${chiTietSP.soLuongTon}" required>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Giá nhập</label>
                    <input type="number" min="1" class="form-control" name="giaNhap" value="${chiTietSP.giaNhap}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Giá bán</label>
                    <input type="number" min="1" class="form-control" name="giaBan" value="${chiTietSP.giaBan}" required>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Mô tả</label>
<%--                    <textarea class="form-control" id="moTa" name="moTa" rows="3" value="${chiTietSP.moTa}"></textarea>--%>
                    <input type="text" class="form-control" name="moTa" value="${chiTietSP.moTa}" required>
                </div>
                <div class="col-6"></div>
            </div>
            <div class="row mt-4" style="justify-content: center">
                <a href="/chi-tiet-san-pham/hien-thi" class="btn btn-primary col-1 m-3">Exit</a>
                <button class="btn btn-success col-1 m-3">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
