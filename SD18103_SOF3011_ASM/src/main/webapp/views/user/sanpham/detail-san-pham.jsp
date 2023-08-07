<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 7:32 PM
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
                    <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="#">Sản phẩm</a></li>
                    <li class="breadcrumb-item">name</li>
                </ol>
            </nav>
        </div>
    </section>
    <section>
        <div class="container">
            <div class="row">
                <!-- img -->
                <div class="col-md-5">
                    <div class="card bder">
                        <c:if test="${detailSanPham.sanPham.getImage() != null}">
                            <img class="img" src="<c:url value="/images/${detailSanPham.sanPham.getImage()}"/>" alt="">
                        </c:if>
                    </div>
                </div>
                <!-- thong-tin -->
                <div class="col-md-4">
                    <p class="title-khuyen-mai">${detailSanPham.sanPham.getTen()}</p>
<%--                    <div class="row">--%>
<%--                        <p>Tình trạng: <span class="title-chinh-sach">${detailSanPham.trangThai}</span></p>--%>
<%--                    </div>--%>
                    <div class="row">
                        <p>Mã sản phẩm: <span class="title-chinh-sach">Đang cập nhật</span></p>
                    </div>
                    <div class="row">
                        <p class="title-gia"><fmt:formatNumber value="${detailSanPham.giaBan}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</p>
                    </div>
                    <p class="mt-3">Số lượng: </p>
                    <div class="row">
                        <div class="number-product">
                            <button class="btn-num">-</button>
                            <input class="i-so-luong" type="number" value="1" name="soLuong" readonly>
                            <button class="btn-num">+</button>
                        </div>
                    </div>
                    <div class="row mt-5">
                        <button class="btn-them-ghang" type="submit">
                            <div class="row">
                                <div class="col-md-2 pt-3">
                                    <span><i class="bi bi-bag icon-gio-hang"></i></span>
                                </div>
                                <div class="col-md-10">
                                    <p class="title-btn mt-2">THÊM VÀO GIỎ HÀNG</p>
                                    <p>Giao hàng tận nơi miễn phí</p>
                                </div>
                            </div>
                        </button>
                    </div>
                </div>
                <!-- chinh-sach -->
                <div class="col-md-3">
                    <div class="card bground bder">
                        <p class="title-khuyen-mai">Chính sách cửa hàng</p>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="/images/chinhsach_1.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Miễn phí vẫn chuyển</p>
                                <p>Cho tất cả đơn hàng trong nội thành Hồ Chí Minh</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="/images/chinhsach_2.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Miễn phí đổi - trả</p>
                                <p>Đối với sản phẩm lỗi sản xuất hoặc vận chuyển</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="/images/chinhsach_3.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Hỗ trợ nhanh chóng</p>
                                <p>Gọi Hotline: 19006750 để được hỗ trợ ngay</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="/images/chinhsach_4.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Ưu đãi combo</p>
                                <p>Mua theo combo,mùa càng mua nhiều giá càng rẻ</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row py-4">
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-3">
                            <button class="btn-them-ghang">HƯỚNG DẪN MUA HÀNG</button>
                        </div>
                        <div class="col-md-3">
                            <button class="btn-them-ghang">HƯỚNG DẪN MUA HÀNG</button>
                        </div>
                    </div>
                    <div class="row py-3">
                        <div class="card">
                            <p>${detailProduct.moTa}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="row py-3">
                <div class="col-md-9">
                    <div class="row">
                        <p class="title-khuyen-mai">Sản phẩm liên quan</p>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="card bder">
                                <a href="#" class="img">
                                    <img src="/images/kim-chi-cai-thao-cat-lat-bibigo-ong-kims.webp"
                                         class="card-img-top" alt="..." />
                                    <p class="card-title img">Kim chi cải thảo</p>
                                </a>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <p class="card-text">12.000đ</p>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#" class="fs-3"><i class="bi bi-bag"></i></a>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#" class="fs-3"><i class="bi bi-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </section>
    <jsp:include page="/views/user/page/footer.jsp"></jsp:include>
</body>
</html>
