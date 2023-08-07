<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 7:37 PM
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
        <div class="container pt-4">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/ban-hang/trang-chu">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="#">Sản phẩm</a></li>
                </ol>
            </nav>
        </div>
    </section>
    <section>
        <div class="container py-4">
            <div class="row">
                <div class="col-md-3">
                    <div class="card mb-3">
                        <div class="card-header">
                            <span><i class="bi bi-list"></i>   Dòng sản phẩm</span>
                        </div>
                        <div class="cate-lst">
                            <ul class="list-group">
                                <c:forEach items="${listDongSP}" var="ms">
                                    <li class="list-group-item text-white "><a href="#">${ms.ten}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="card-header">
                            <span><i class="bi bi-list"></i>   Màu sắc sản phẩm</span>
                        </div>
                        <div class="cate-lst">
                            <ul class="list-group">
                                <c:forEach items="${listMauSac}" var="ms">
                                    <li class="list-group-item text-white "><a href="#">${ms.ten}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="card-header">
                            <span><i class="bi bi-list"></i>   Nhà sản xuất sản phẩm</span>
                        </div>
                        <div class="cate-lst">
                            <ul class="list-group">
                                <c:forEach items="${listNSX}" var="nsx">
                                    <li class="list-group-item text-white "><a href="#">${nsx.ten}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-2">
                            <h5>Sắp xếp theo :</h5>
                        </div>
                        <div class="col-md-10">
                            <ul style="display: flex;list-style: none;">
                                <li><a href="#" class="btn-tht btn-li">Tên A-Z</a></li>
                                <li><a href="#" class="btn-tht btn-li">Tên Z-A</a></li>
                                <li><a href="#" class="btn-tht btn-li">Hàng mới</a></li>
                                <li><a href="#" class="btn-tht btn-li">Giá thấp đến cao</a></li>
                                <li><a href="#" class="btn-tht btn-li">Giá cao đến thấp</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- product -->
                    <div class="row">
                        <div class="row py-2">
                            <c:forEach items="${listCTSP}" var="ctsp">
                                <div class="col-md-3 py-2">
                                    <div class="card bder">
                                        <a href="/ban-hang/detail?id=${ctsp.id}" class="img">
                                            <img src="${ctsp.sanPham.getImage()}" class="card-img-top" alt="..." />
                                            <p class="card-title text-center">${ctsp.sanPham.getTen()}</p>
                                        </a>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <p class="card-text"><fmt:formatNumber value="${ctsp.giaBan}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</p>
                                                </div>
                                                <form action="/ban-hang/add?id=${ctsp.id}" method="post">
                                                    <div class="row pt-2">
                                                        <div class="col-md-4">
                                                            <%--  <a href="" class="fs-4"><i class="bi bi-bag"></i></a>--%>
                                                            <button type="submit" class="fs- btn btn-primary"><i class="bi bi-bag"></i></button>
                                                        </div>
                                                        <div class="col-md-4">
<%--                                                            <a href="#" class="fs-4"><i class="bi bi-heart"></i></a>--%>
                                                            <button type="submit" class="fs- btn btn-primary"><i class="bi bi-heart"></i></button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- page -->
                    <div class="row">
                        <div class="col page">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <c:forEach begin="${1}" end="${number}" var="i">
                                        <li class="page-item"><a class="page-link" href="/ban-hang/product?page=${i}">${i}</a></li>
                                    </c:forEach>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/views/user/page/footer.jsp"></jsp:include>
</body>
</html>
