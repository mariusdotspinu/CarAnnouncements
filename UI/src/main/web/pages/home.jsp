<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="templates/header_template.jsp" %>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/css/search.css' type="text/css">
    <link rel='stylesheet' href='${pageContext.request.contextPath}/css/card.css' type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/jquery-ui/1.11.4/jquery-ui.css">

    <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.11.4/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/datepicker.js"></script>

    <title>Home</title>
</head>
<body>
<header>
    <%@include file="containers/navbar.jsp" %>
</header>

<%@include file="containers/search_form.jsp" %>
<%@include file="containers/card_grid.jsp" %>
<%@include file="templates/footer_template.jsp" %>

</body>
</html>