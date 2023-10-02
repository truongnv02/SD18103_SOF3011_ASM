<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%--    header--%>
    <jsp:include page="/views/user/page/header.jsp"></jsp:include>
    <jsp:include page="/views/user/page/slider.jsp"></jsp:include>

    <section>
        <div class="container">
            <p class="title-khuyen-mai">Khuyến mãi hấp dẫn</p>
            <span>Chương trình khuyến mãi hấp dẫn đang chờ đợi bạn</span>
            <hr>
            <div class="row">
                <c:forEach items="${listCTSP}" var="ctsp" begin="0" end="6" varStatus="status">
                    <div class="col-md-2 py-2">
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
                                    <div class="col-md-2">
                                        <a href="#" class="fs-4"><i class="bi bi-bag"></i></a>
                                    </div>
                                    <div class="col-md-2">
                                        <a href="#" class="fs-4"><i class="bi bi-heart"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>

    <%--    dich-vu--%>
    <section>
        <div class="container py-5">
            <p class="title-khuyen-mai">Dịch vụ đặc biệt của chúng tôi</p>
            <span>Những dịch vụ tốt nhất dành cho khách hàng của chúng tôi</span>
            <hr>
            <div class="row">
                <div class="col-md-4 item">
                    <div class="card bder">
                        <img src="/images/dichvu_1.webp" alt="" class="img">
                        <h5 class="title-dich-vu">Rau hữu cơ tươi</h5>
                        <div class="card-body">
                            <p>Được trồng theo phương pháp hiện đại nhất, đạt tiêu chuẩn quốc tế, vô cùng an toàn khi sử
                                dụng.</p>
                            <a href="#" class="btn-tht">Tìm hiểu thêm</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 item">
                    <div class="card bder">
                        <img src="/images/dichvu_2.webp" alt="" class="img">
                        <h5 class="title-dich-vu">Giao hàng nhanh chóng</h5>
                        <div class="card-body">
                            <p>Giao hàng trong thời gian nhanh nhất để đảm bảo chất lượng tốt nhất cho những sản phẩm
                                bạn đã đặt.</p>
                            <a href="#" class="btn-tht">Tìm hiểu thêm</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 item">
                    <div class="card bder">
                        <img src="/images/dichvu_3.webp" alt="" class="img">
                        <h5 class="title-dich-vu">Thanh toán dễ dàng</h5>
                        <div class="card-body">
                            <p>Nhiều hình thức thanh toán làm cho việc đặt hàng của bạn và shop trở nên dễ dàng và tiện
                                lợi.</p>
                            <a href="#" class="btn-tht">Tìm hiểu thêm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- list-product -->
    <section>
        <div class="container py-3">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <img src="/images/image_product1.webp" alt="">
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <p class="title-khuyen-mai">Rau củ</p>
                        <hr>
                    </div>
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
                    <div class="item-btn">
                        <a href="#" class="btn-tht">Xem tất cả</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-4">
                    <img class="bder" src="/images/banner_three_1.webp" alt="">
                </div>
                <div class="col-md-4">
                    <img class="bder" src="/images/banner_three_2.webp" alt="">
                </div>
                <div class="col-md-4">
                    <img class="bder" src="/images/banner_three_3.webp" alt="">
                </div>
            </div>
        </div>
    </section>

    <section>
        <div class="container py-3">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <img src="/images/image_product2.webp" alt="">
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <p class="title-khuyen-mai">Trái cây</p>
                        <hr>
                    </div>
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
                    <div class="item-btn">
                        <a href="#" class="btn-tht">Xem tất cả</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section>
        <div class="container py-5">
            <div class="row">
                <img src="/images/banner.webp" alt="">
            </div>
        </div>
    </section>

    <section>
        <div class="container py-3">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <img src="/images/image_product3.webp" alt="">
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <p class="title-khuyen-mai">Đồ khô</p>
                        <hr>
                    </div>
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
                    <div class="item-btn">
                        <a href="#" class="btn-tht">Xem tất cả</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section>
        <div class="container py-5">
            <div class="row">
                <img src="/images/banner2.webp" alt="">
            </div>
        </div>
    </section>

    <%--    footer--%>
    <jsp:include page="/views/user/page/footer.jsp"></jsp:include>
</body>
</html>
