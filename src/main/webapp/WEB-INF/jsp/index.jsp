<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Main page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h3>${pageContext.request.userPrincipal.name}</h3>
  <sec:authorize access="!isAuthenticated()">
    <h4><a href="/login">Login</a></h4>
    <h4><a href="/registration">Sign up</a></h4>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Logout</a></h4>
  </sec:authorize>
  <h4><a href="/notebooks">Notebooks list</a></h4>
  <h4><a href="/notebooks/sorted-descend-by-producer">Notebooks list sorted by producer in descend order (for registered users)</a></h4>
  <h4><a href="/notebooks/16gb-plus">Notebooks list with RAM more or equals 16GB (for registered users)</a></h4>
  <h4><a href="/notebooks/used">Used notebooks list (for registered users)</a></h4>
</div>
</body>
</html>