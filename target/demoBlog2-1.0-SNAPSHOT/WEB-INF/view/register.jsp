<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <c:import url="${pageContext.request.contextPath}./import/css.jsp"/>


</head>

<body class="animsition">
<div class="page-wrapper">
    <div class="page-content--bge5">
        <div class="container">
            <div class="login-wrap">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}../cool-admin/images/icon/logo.png"
                                 alt="CoolAdmin">
                        </a>
                    </div>
                    <c:if test="${mess!=null}">
                        <div class="alert alert-danger" role="alert">
                                ${mess}
                        </div>
                    </c:if>

                    <div class="login-form">
                        <form action="" method="post">
                            <input type="hidden" name="action" value="register">
                            <div class="form-group">
                                <label>Full Name</label>
                                <input class="au-input au-input--full" type="text" name="fullName"
                                       placeholder="FullName">
                            </div>
                            <div class="form-group">
                                <label>Email Address</label>
                                <input class="au-input au-input--full" type="email" name="email" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="au-input au-input--full" type="password" name="password"
                                       placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label>Repeat Password</label>
                                <input class="au-input au-input--full" type="password" name="password-repeat"
                                       placeholder="Repeat Password">
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


<c:import url="${pageContext.request.contextPath}./import/script.jsp"/>


</body>

</html>
<!-- end document-->
