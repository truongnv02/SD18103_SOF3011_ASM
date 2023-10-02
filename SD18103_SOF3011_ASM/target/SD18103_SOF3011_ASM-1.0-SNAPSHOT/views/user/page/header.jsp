<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header -->
<section>
    <div class="container py-3">
        <div class="row">
            <div class="col-md-3">
                <img src="/images/logo.webp" class="img-fluid" alt="logo">
            </div>
            <div class="col-md-7">
                <form action="/ban-hang/search" method="get">
                    <div class="input-group mb-3">
                        <input value="${txtValue}" name="txtSearch" type="text" class="form-control" placeholder="Từ khóa ...." aria-label="Từ khóa ....">
                        <button class="input-group-text" type="submit"><i class=" bi bi-search"></i></button>
                    </div>
                </form>
            </div>
            <div class="col-md-2">
                <div class="row">
                    <div class="col">
                        <a href="#" class="position-relative">
                            <span class="fs-3"><i class="bi bi-telephone"></i></span>
                        </a>
                    </div>
                    <div class="col">
                        <a href="/account/login" class="position-relative">
                            <span class="fs-3"><i class="bi bi-person"></i></span>
                        </a>
                    </div>
                    <div class="col">
                        <a href="#" class="position-relative">
                            <span class="fs-3"><i class="bi bi-heart"></i></span>
                            <span
                                    class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                    0
                                </span>
                        </a>
                    </div>
                    <div class="col">
                        <a href="/ban-hang/gio-hang" class="position-relative">
                            <span class="fs-3"><i class="bi bi-bag"></i></span>
                            <span
                                    class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                    ${size}
                                </span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- mymainmenu -->
<section class="mymainmenu">
    <div class="container bg-mainmenu">
        <div class="row ">
            <div class="col-md-3"></div>
            <div class="col-md-9">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active text-white" aria-current="page" href="/ban-hang/trang-chu">Trang chủ</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white" href="#">Giới thiệu</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link text-white" href="/ban-hang/san-pham">Sản phẩm</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link text-white" href="#" id="navbarDropdown"
                                       role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Tin tức
                                    </a>
                                    <ul class="dropdown-menu bder" aria-labelledby="navbarDropdown">
                                        <li><a class="dropdown-item" href="#">Mẹo ăn ngon</a></li>
                                        <li><a class="dropdown-item" href="#">Vào bếp cùng Mew</a></li>
                                        <li><a class="dropdown-item" href="#">Review thực phẩm nhà Mew</a></li>
                                        <li><a class="dropdown-item" href="#">Khuyến mãi hot</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white" href="#">Tuyển dụng</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white" href="#">Liên hệ</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</section>
