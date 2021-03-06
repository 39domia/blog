<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
user
User
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                        <img src="../../../cool-admin/images/icon/logo.png" alt="CoolAdmin">
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
                                <a href="index.html">Dashboard 1</a>
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
                    <li class="active">
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
                                        <img src="../../../cool-admin/images/icon/avatar-01.jpg" alt="John Doe">
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">john doe</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="../../../cool-admin/images/icon/avatar-01.jpg"
                                                         alt="John Doe">
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
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Edit</strong> user
                                </div>
                                <div class="card-body card-block">
                                    <form method="post" action="/user" class="form-horizontal">
                                        <input type="hidden" name="action" value="editUser">
                                        <input type="hidden" name="id" value="${user.id}">
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="email" class=" form-control-label">Email*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="email" name="email"
                                                       value="${user.email}" class="form-control" required>
                                                <small class="form-text text-muted">This is a category name input
                                                    field</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="alias" class=" form-control-label">alias*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="alias" name="alias"
                                                       value="${user.alias}" class="form-control">
                                                <small class="form-text text-muted">This is a category name input
                                                    field</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="role" class=" form-control-label">role*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <select name="role" id="role">
                                                    <option value="1">Admin</option>
                                                    <option value="2">Author</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="fullName" class=" form-control-label">fullName*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="fullName" name="fullName"
                                                       value="${user.fullName}" class="form-control">
                                                <small class="form-text text-muted">This is a category name input
                                                    field</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="yob" class=" form-control-label">yob*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="number" id="yob" name="yob"
                                                       value="${user.yob}" class="form-control">
                                                <small class="form-text text-muted">This is a category name input
                                                    field</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="description"
                                                       class=" form-control-label">description*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea name="description" id="description"
                                                          rows="4" class="form-control">${user.description}</textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="about" class=" form-control-label">about*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea id="about" name="about">${user.about}</textarea>
                                                <small class="form-text text-muted">This is a category name input
                                                    field</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="image" class=" form-control-label">image*</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="url" id="image" name="image"
                                                       value="${user.image}" class="form-control">
                                                <small class="form-text text-muted">This is a category name input
                                                    field</small>
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> Submit
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> Reset
                                            </button>
                                            <a href="/user" class="btn btn-warning btn-sm">
                                                <i class="fa fa-hand-o-left"></i> Back to category list
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

<!-- Jquery JS-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%--<script src="${pageContext.request.contextPath}../cool-admin/vendor/jquery-3.2.1.min.js"></script>--%>
<%--<!-- Bootstrap JS-->--%>
<%--<script src="${pageContext.request.contextPath}../cool-admin/vendor/bootstrap-4.1/popper.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}../cool-admin/vendor/bootstrap-4.1/bootstrap.min.js"></script>--%>
<!-- Vendor JS       -->
<script src="${pageContext.request.contextPath}../cool-admin/vendor/slick/slick.min.js">
</script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/wow/wow.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/animsition/animsition.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/circle-progress/circle-progress.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/select2/select2.min.js">
</script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<!-- Main JS-->
<script src="${pageContext.request.contextPath}../cool-admin/js/main.js"></script>

<!-- Code injected by live-server -->
<script type="text/javascript">
    // <![CDATA[  <-- For SVG support
    if ('WebSocket' in window) {
        (function () {
            function refreshCSS() {
                var sheets = [].slice.call(document.getElementsByTagName("link"));
                var head = document.getElementsByTagName("head")[0];
                for (var i = 0; i < sheets.length; ++i) {
                    var elem = sheets[i];
                    var parent = elem.parentElement || head;
                    parent.removeChild(elem);
                    var rel = elem.rel;
                    if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                        var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                        elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                    }
                    parent.appendChild(elem);
                }
            }

            var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
            var address = protocol + window.location.host + window.location.pathname + '/ws';
            var socket = new WebSocket(address);
            socket.onmessage = function (msg) {
                if (msg.data == 'reload') window.location.reload();
                else if (msg.data == 'refreshcss') refreshCSS();
            };
            if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
                console.log('Live reload enabled.');
                sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
            }
        })();
    } else {
        console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
    }
    // ]]>

    $(document).ready(function () {
        $('.toast').toast({delay: 5000});
        $('.toast').toast('show');
    });
    $('#about').summernote({
        tabsize: 2,
        height: 200
    });
</script>


<!-- end document-->
<div class="selection_bubble_root" style="display: none;"></div>
</body>
</html>
