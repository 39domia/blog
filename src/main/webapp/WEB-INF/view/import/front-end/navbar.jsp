<nav class="navbar navbar-expand-md  navbar-light bg-light">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarMenu">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="/index">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle"
                       href="${pageContext.request.contextPath}vendor/category.html" id="dropdown05"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Categories</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown05">
                        <c:forEach items="${categories}" var="category">
                            <a class="dropdown-item" href="index?action=view-category&category-id=${category.id}">${category.name}</a>
                        </c:forEach>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.html">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.html">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
