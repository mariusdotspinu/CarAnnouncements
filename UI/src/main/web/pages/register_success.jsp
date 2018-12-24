<%--
  Created by IntelliJ IDEA.
  User: mariu
  Date: 12-Nov-18
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<html>
<head>
    <%@include file="templates/header_template.jsp" %>
    <title>Register Successful</title>
</head>
<body>
<div class="container">
    <div class="form-align form-signin center col-lg">

        <h1 class="h1 mb-3 font-weight-normal">Registration Successful</h1>
        <img class="success_icon" src="${pageContext.request.contextPath}/images/success.png">
        <form action="${pageContext.request.contextPath}/login">
            <input type="submit" class="btn btn-lg btn-primary btn-block register-success-btn" value="Login">
        </form>

    </div>
</div>
<%@include file="templates/footer_template.jsp" %>
</body>
</html>