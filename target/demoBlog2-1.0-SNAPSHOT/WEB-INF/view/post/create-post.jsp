<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Create Post</title>

    <c:import url="${pageContext.request.contextPath}../import/css.jsp"/>


</head>

<body class="">
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="index.html">
                        <img src="../../../cool-admin/images/icon/logo.png" alt="CoolAdmin"/>
                    </a>
                    <button class="hamburger hamburger--slider" type="button">
                        <span class="hamburger-box">
                            <span class="hamburger-inner"></span>
                        </span>
                    </button>
                </div>
            </div>
        </div>
        <nav class="navbar-mobile">
            <div class="container-fluid">
                <ul class="navbar-mobile__list list-unstyled">
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-tachometer-alt"></i>Dashboard</a>
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="cool-admin/index.html">Dashboard 1</a>
                            </li>
                            <li>
                                <a href="index2.html">Dashboard 2</a>
                            </li>
                            <li>
                                <a href="index3.html">Dashboard 3</a>
                            </li>
                            <li>
                                <a href="index4.html">Dashboard 4</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="chart.html">
                            <i class="fas fa-chart-bar"></i>Charts</a>
                    </li>
                    <li>
                        <a href="table.html">
                            <i class="fas fa-table"></i>Tables</a>
                    </li>
                    <li>
                        <a href="form.html">
                            <i class="far fa-check-square"></i>Forms</a>
                    </li>
                    <li>
                        <a href="calendar.html">
                            <i class="fas fa-calendar-alt"></i>Calendar</a>
                    </li>
                    <li>
                        <a href="map.html">
                            <i class="fas fa-map-marker-alt"></i>Maps</a>
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-copy"></i>Pages</a>
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="login.html">Login</a>
                            </li>
                            <li>
                                <a href="register.html">Register</a>
                            </li>
                            <li>
                                <a href="forget-pass.html">Forget Password</a>
                            </li>
                        </ul>
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-desktop"></i>UI Elements</a>
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="button.html">Button</a>
                            </li>
                            <li>
                                <a href="badge.html">Badges</a>
                            </li>
                            <li>
                                <a href="tab.html">Tabs</a>
                            </li>
                            <li>
                                <a href="card.html">Cards</a>
                            </li>
                            <li>
                                <a href="alert.html">Alerts</a>
                            </li>
                            <li>
                                <a href="progress-bar.html">Progress Bars</a>
                            </li>
                            <li>
                                <a href="modal.html">Modals</a>
                            </li>
                            <li>
                                <a href="switch.html">Switchs</a>
                            </li>
                            <li>
                                <a href="grid.html">Grids</a>
                            </li>
                            <li>
                                <a href="fontawesome.html">Fontawesome Icon</a>
                            </li>
                            <li>
                                <a href="typo.html">Typography</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="#">
                <img src="../../../cool-admin/images/icon/logo.png" alt="Cool Admin"/>
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="active">
                        <a href="/post">
                            <i class="fas fa-table"></i>Post</a>
                    </li>
                    <c:if test="${sessionScope.user.role == 1}">
                        <li class="active">
                            <a href="/category">
                                <i class="fas fa-table"></i>Category</a>
                        </li>
                        <li>
                            <a href="/user">
                                <i class="fas fa-table"></i>User</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <form class="form-header" action="" method="POST">
                            <a href="/index" type="button" class="btn btn-primary">
                                <i class="fa fa-star"></i>&nbsp; Go to blog</a>
                        </form>
                        <div class="header-button">
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="../../../cool-admin/images/icon/avatar-01.jpg" alt="John Doe"/>
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">john doe</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="../../../cool-admin/images/icon/avatar-01.jpg"
                                                         alt="John Doe"/>
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">john doe</a>
                                                </h5>
                                                <span class="email">johndoe@example.com</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-account"></i>Account</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-money-box"></i>Billing</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="#">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <c:if test="${errors!= null}">
                        <c:forEach var="error" items="${errors}">
                            <div class="row">
                                <div class="alert alert-danger" role="alert">
                                        ${error}
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Create</strong> Post
                                </div>
                                <div class="card-body card-block">
                                    <form action="/post" method="post" class="form-horizontal">
                                        <input type="hidden" name="action" value="createPost">
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="postTitle" class=" form-control-label">title</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="postTitle" name="title"
                                                       placeholder="Enter name" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="shortContent" class=" form-control-label">Short
                                                    content</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea name="shortContent" id="shortContent" rows="4"
                                                          placeholder="Content..." class="form-control"
                                                ></textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="summernote" class=" form-control-label">Full
                                                    content</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea name="fullContent" id="summernote" rows="9"
                                                          placeholder="Content..." class="form-control"
                                                          required></textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="image" class=" form-control-label">Image</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="image" name="image"
                                                       placeholder="Enter image" class="form-control" required>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label"> Category</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <select name="category" class="form-control">
                                                    <c:forEach items="${categories}" var="category">
                                                        <option value="${category.id}">${category.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <c:if test="${sessionScope.user.role == 1}">
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label class=" form-control-label"> Author</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <select name="user" class="form-control">
                                                        <c:forEach items="${users}" var="user">
                                                            <option value="${user.id}">${user.email}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </c:if>
                                        <div class="row card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> Submit
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> Reset
                                            </button>
                                            <a href="/post" type="button" class="btn btn-warning btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> back
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${mess!=null}">
                            <div class="position-fixed bottom-0 right-0 p-3" style="z-index: 5; right: 0; bottom: 0;">
                                <div id="liveToast" class="toast hide bg-light" role="alert" aria-live="assertive"
                                     aria-atomic="true" data-delay="2000">
                                    <div class="toast-header">
                                        <svg class="bd-placeholder-img rounded mr-2" width="20" height="20"
                                             xmlns="http://www.w3.org/2000/svg" aria-hidden="true"
                                             preserveAspectRatio="xMidYMid slice" focusable="false">
                                            <rect width="100%" height="100%" fill="#007aff"></rect>
                                        </svg>
                                        <strong class="mr-auto">Information</strong>
                                        <small></small>
                                        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="toast-body">
                                            ${mess}
                                    </div>
                                </div>
                            </div>
                        </c:if>
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
