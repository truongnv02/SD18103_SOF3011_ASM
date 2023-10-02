<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 8/1/2023
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assets/css/login.css">
</head>
<body>
    <div>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form action="/account/check" method="post">
                        <h2>Sign in</h2>
                        <div class="inputbox">
                            <input type="text" required class="username" name="ma">
                            <label>Username</label>
                        </div>
                        <div class="inputbox">
                            <input type="password" required class="password" name="matKhau">
                            <label>Password</label>
                        </div>
                        <div class="forget">
                            <label><input type="checkbox">Remember Me <a href="#">Forget Password</a></label>
                        </div>
                        <button type="submit" class="btn_signin">Sign in</button>
                        <div class="register">
                            <p>Don't have a account <a href="#">Register</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
</body>
</html>
