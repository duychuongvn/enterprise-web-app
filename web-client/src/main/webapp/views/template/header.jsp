<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
    href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.min.css"
    rel="stylesheet">
    <link
    href="<%=request.getContextPath()%>/resources/css/login.css"
    rel="stylesheet">
<script
    src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>
<script
    src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div >
    <span><h1>This is Header</h1></span>
    <br/>
    <a href="<%=request.getContextPath()%>/jsp/home.jsp">Home</a>
       <a href="<%=request.getContextPath()%>/">Logout</a>
    </div>
</body>