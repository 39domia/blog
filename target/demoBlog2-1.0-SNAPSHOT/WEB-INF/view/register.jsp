<%--
  Created by IntelliJ IDEA.
  User: Domia
  Date: 3/5/2021
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Register</title>

    <<!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}../cool-admin/css/font-face.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/font-awesome-4.7/css/font-awesome.min.css"
          rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/font-awesome-5/css/fontawesome-all.min.css"
          rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/mdi-font/css/material-design-iconic-font.min.css"
          rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/animsition/animsition.min.css" rel="stylesheet"
          media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
          rel="stylesheet"
          media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/css-hamburgers/hamburgers.min.css"
          rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/select2/select2.min.css" rel="stylesheet"
          media="all">
    <link href="${pageContext.request.contextPath}../cool-admin/vendor/perfect-scrollbar/perfect-scrollbar.css"
          rel="stylesheet" media="all">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}../cool-admin/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
    <div class="page-content--bge5">
        <div class="container">
            <div class="login-wrap">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}../cool-admin/images/icon/logo.png" alt="CoolAdmin">
                        </a>
                    </div>
                    <div class="login-form">
                        <form action="" method="post">
                            <input type="hidden" name="action" value="register">
                            <div class="form-group">
                                <label>Full Name</label>
                                <input class="au-input au-input--full" type="text" name="fullName" placeholder="FullName">
                            </div>
                            <div class="form-group">
                                <label>Email Address</label>
                                <input class="au-input au-input--full" type="email" name="email" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="au-input au-input--full" type="password" name="password" placeholder="Password">
                            </div>
                            <div class="login-checkbox">
                                <label>
                                    <input type="checkbox" name="aggree">Agree the terms and policy
                                </label>
                            </div>
                            <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">register</button>
                        </form>
                        <div class="register-link">
                            <p>
                                Already have account?
                                <a href="login">Sign In</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<c:import url="${pageContext.request.contextPath}../import/script.jsp"/>

</body>

</html>
<!-- end document-->
