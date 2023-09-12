<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<body>
<header>
    <h2 class="logo">Farmers<sup>Zone</sup></h2>
    <nav class="navigation">
        <a href="#">Sale</a>
        <a href="#">Lease</a>
        <a href="#">Purchase</a>
        <a href="#">Rent</a>
        <button class="btnLogin-popup" type="submit" class="btn">Buying</button> 
        <a href="farm.html"><button class="btnLogin-popup" type="submit" class="btn">Add Farm</button></a> 
        <a href="home.html"><button class="btnLogin-popup" class="btn">Logout</button></a>
        <div class="login-register">
    </nav>
</header>
	<c:set var="name" value="${sessionScope.email}" />
	<h1>${name}</h1>
</body>
</html>