<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- slide -->
<section class="mymaincontent py-2">
    <div class="container">
        <!-- slider -->
        <div class="slider">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/images/slide-img1.webp" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/images/slide-img2.webp" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <!-- mew-mall -->
        <div class="mew-mall mt-4 mb-5">
            <div class="row">
                <div class="col-md-3">
                    <div class="row">
                        <div class="col-2">
                            <img src="/images/img_poli_1.webp" alt="">
                        </div>
                        <div class="col-10">
                            <p>Sản phẩm an toàn</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="row">
                        <div class="col-2">
                            <img src="/images/img_poli_2.webp" alt="">
                        </div>
                        <div class="col-10">
                            <p>Cam kết chất lượng</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="row">
                        <div class="col-2">
                            <img src="/images/img_poli_3.webp" alt="">
                        </div>
                        <div class="col-10">
                            <p>Dịch vụ vượt trội</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="row">
                        <div class="col-2">
                            <img src="/images/img_poli_4.webp" alt="">
                        </div>
                        <div class="col-10">
                            <p>Giao hàng nhanh chóng</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>