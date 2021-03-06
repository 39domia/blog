<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="user" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Category</title>

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
                    <li>
                        <a href="/post">
                            <i class="fas fa-table"></i>Post</a>
                    </li>
                    <li>
                        <a href="/category">
                            <i class="fas fa-table"></i>Category</a>
                    </li>
                    <li>
                        <a href="/user">
                            <i class="fas fa-table"></i>User</a>
                    </li>
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
                                                    <img src="../../../cool-admin/images/icon/avatar-01.jpg" alt="John Doe"/>
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
                    <div class="row pb-4">
                        <div class="col-7">
                            <a href="/user?action=createUser"
                               class="au-btn au-btn-icon au-btn--green au-btn--small ml-3">
                                <i class="zmdi zmdi-plus"></i>Add new user</a>
                        </div>
                        <form class="form-header col-5" action="/user?action=searchUser" method="post">
                            <input class="au-input au-input--full" type="text" name="keyWord" placeholder="Enter user name">
                            <button class="au-btn--submit" type="submit">
                                <i class="zmdi zmdi-search"></i>
                            </button>
                        </form>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="table-responsive table--no-card m-b-30">
                                <table class="table table-borderless table-striped table-earning">
                                    <thead>
                                    <tr>
                                        <th> ID</th>
                                        <th> email</th>
                                        <th> alias</th>
                                        <th> role</th>
                                        <th> fullName</th>
                                        <th> yob</th>
                                        <th> description</th>
                                        <th> about</th>
                                        <th> createdDate</th>
                                        <th> image</th>
                                        <th class="text-right">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <td>${user.id}</td>
                                            <td>${user.email}</td>
                                            <td>${user.alias}</td>
                                            <td>${user.role}</td>
                                            <td>${user.fullName}</td>
                                            <td>${user.yob}</td>
                                            <td>${user.description}</td>
                                            <td>${user.about}</td>
                                            <td>${user.createdDate}</td>
                                            <td><img src='${user.image}' alt=""></td>
                                            <td>
                                                <div class="table-data-feature">
                                                    <a href="/user?action=editUser&id=${user.id}"
                                                       class="item" data-toggle="tooltip" data-placement="top" title=""
                                                       data-original-title="Edit">
                                                        <i class="zmdi zmdi-edit"></i>
                                                    </a>
                                                    <a class="btn btn-secondary mb-1" href="/user?action=deleteUser&id=${user.id}"
                                                       onclick="return confirm('Are you sure about that?')"
                                                    >
                                                        <i class="zmdi zmdi-delete"></i>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="smallmodal" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="smallmodalLabel">Small Modal</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>
                            Are you sure about that?
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            Cancel
                        </button>
                        <button  type="button" class="btn btn-primary">
                            <%--                            <a href="/category?action=deleteUser&id=${categories.idCategory}">Confirm</a>--%>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>

<!-- Jquery JS-->
<script src="../../../cool-admin/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="../../../cool-admin/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="../../../cool-admin/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="../../../cool-admin/vendor/slick/slick.min.js">
</script>
<script src="../../../cool-admin/vendor/wow/wow.min.js"></script>
<script src="../../../cool-admin/vendor/animsition/animsition.min.js"></script>
<script src="../../../cool-admin/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="../../../cool-admin/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="../../../cool-admin/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="../../../cool-admin/vendor/circle-progress/circle-progress.min.js"></script>
<script src="../../../cool-admin/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../../../cool-admin/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="../../../cool-admin/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="../../../cool-admin/js/main.js"></script>

</body>

</html>
<!-- end document-->
