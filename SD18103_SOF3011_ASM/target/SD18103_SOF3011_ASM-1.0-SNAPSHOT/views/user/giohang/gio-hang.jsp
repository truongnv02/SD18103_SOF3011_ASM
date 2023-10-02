<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/4/2023
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
    <jsp:include page="/views/user/page/header.jsp"></jsp:include>
    <section>
        <div class="container py-5">
            <div class="row">
                <!-- 1 -->
<%--                <c:forEach items="${listGioHangChiTiet}" var="ghct">--%>
                    <div class="col-md-8 border border-1">
                        <div class="row py-2">
                            <div class="col-md-2">
<%--                                <img src="#" alt="..." height="120">--%>
                                <c:if test="${ghct.chiTietSanPham.getSanPham().getImage() != null}">
                                    <img class="img" src="<c:url value="/images/${ghct.chiTietSanPham.getSanPham().getImage()}"/>" alt="">
                                </c:if>
                            </div>
                            <div class="col-md-10 py-4">
                                <div class="row">
                                    <div class="col-md-8">
                                        <p>${ghct.chiTietSanPham.getSanPham().getTen()}</p>
                                    </div>
                                    <div class="col-md-4">
                                        <p>${ghct.donGia * ghct.soLuong} VNĐ</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="number-product">
                                            <button class="btn-num">-</button>
                                            <input class="i-so-luong" type="number" value="1" name="soLuong" readonly>
                                            <button class="btn-num">+</button>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <button type="submit" class="btn btn-danger">Xóa</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
<%--                </c:forEach>--%>
                <!-- 2 -->
                <div class="col-md-4 px-5">
                    <div class="row bg-warning p-3 rounded">
                        <div class="col-md-4 text-white fs-4">Tổng</div>
                        <div class="col-md-8 text-white fs-4 text-end"> giá</div>
                    </div>
                    <div class="row py-3">
                        <button type="submit" class="btn btn-success">Thanh toán</button>
                    </div>
                    <div class="row">
                        <button type="submit" class="btn btn-primary">Xóa tất cả</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/views/user/page/footer.jsp"></jsp:include>
</body>
</html>
