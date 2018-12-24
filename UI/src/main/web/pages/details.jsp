<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="templates/header_template.jsp" %>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<form:form cssClass="form-signin" modelAttribute="announcement">
    <div class="container center">
        <c:if test="${announcement.images ne null}">
            <div id="carousel" class="carousel slide text-center" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="data:image/jpeg;base64,${announcement.images.get(0)}" alt="Screen"
                             width="300" height="300">
                    </div>
                    <c:forEach begin="1" end="${announcement.images.size() -1}" varStatus="image">
                        <div class="carousel-item">
                            <img src="data:image/jpeg;base64,${announcement.images.get(image.index)}" alt="Screen"
                                 width="300" height="300">
                        </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev" href="#carousel" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#carousel" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </c:if>
        <div class="d-block">
            <label>Title : <c:out value="${announcement.title}"/></label><br/>
            <label>Description: <c:out value="${announcement.description}"/></label><br/>
            <label>Brand : <c:out value="${announcement.brand}"/></label><br/>
            <label>Model : <c:out value="${announcement.model}"/></label><br/>
            <label>Price : <c:out value="${announcement.price}"/></label><br/>
            <label>Fabrication Date : <c:out value="${announcement.fabricationDate}"/> </label>
        </div>
    </div>
</form:form>
<%@ include file="templates/footer_template.jsp" %>
</body>
</html>