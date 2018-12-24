<nav class="navbar navbar-dark fixed-top bg-dark">
    <a href="${pageContext.request.contextPath}/home">
        <img src="${pageContext.request.contextPath}/images/home_icon.png">
    </a>

    <c:choose>
        <c:when test="${!user.logged}">
            <div class="form">
                <a href="${pageContext.request.contextPath}/register">
                    <input type="button" class="btn btn-outline-danger my-2 my-sm-0" value="Sign Up">
                </a>
                <a href="${pageContext.request.contextPath}/login">
                    <input type="button" class="btn btn-outline-success my-2 my-sm-0" value="Login">
                </a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="form-row">
                <label class="greetings-message" style="margin-right: 20px">Hello ${user.emailAddress}</label>
                <form:form method="post" action="logout">
                    <button type="submit" formaction="logout" class="btn btn-outline-danger my-2 my-sm-0">Log Out
                    </button>
                </form:form>
            </div>
        </c:otherwise>
    </c:choose>
</nav>