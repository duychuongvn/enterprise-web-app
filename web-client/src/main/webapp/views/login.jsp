<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<html>
<head>
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link
            href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.min.css"
            rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/login.css"
          rel="stylesheet">
    <script
            src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>
    <script
            src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container center_div">
    <br/> <br/>
    <br/>
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
        <div class=" " style="color: red;">
            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>

            <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
        </div>
    </c:if>
    <br/>

    <div id="loginForm">
        <form action="j_spring_security_check" method="post" class="login-form">

            <div class="form-group">
                <label for="username">UserName:</label> <input type="text"
                                                               class="form-control" id="username" name="username"
                                                               placeholder="Enter Username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label> <input type="password"
                                                               class="form-control" id="password" name="password"
                                                               placeholder="Enter password">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>
        <a href="#" class="">Lost your password?</a> <a href="usermanagement/registerUser.do" class="">New
        User?</a>
    </div>
</div>
</body>
</html>