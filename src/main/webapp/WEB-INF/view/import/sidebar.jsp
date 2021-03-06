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
                <c:if test="${sessionScope.user.role} ==1">
                    <li>
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
