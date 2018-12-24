<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <%@include file="templates/header_template.jsp" %>
    <title>Register</title>
</head>
<body>
<div class="container">
    <div class="form-align center col-lg">
        <h1 class="h3 mb-3 font-weight-normal">Please fill below</h1>
        <form:form cssClass="form-signin" id="registerForm" modelAttribute="newUser" action="processRegister"
                   method="post">

            <form:errors path="emailAddress" cssClass="validation-error"/>
            <form:input path="emailAddress" cssClass="form-control" name="emailAddress"
                        placeholder="Please enter your email address"/>
            <form:errors path="password" cssClass="validation-error"/>
            <form:password path="password" cssClass="form-control" name="password"
                           placeholder="Please enter a password"/>

            <button class="btn btn-lg btn-primary btn-block register-btn" type="submit">Register</button>
        </form:form>
    </div>
</div>
<%@include file="templates/footer_template.jsp" %>
</body>
</html>