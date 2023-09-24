<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Image Gallery</title>
</head>
<body>
    <h1>Image Gallery</h1>
    <img src=".././FarmDataRetrieveServlet?id=1" width="100px" height="100px">
    
    <c:forEach var="imageData" items="${imageIds}">
        <h2><c:out value="${imageData}"/></h2>
        <br>
    </c:forEach>

    <c:forEach var="imageData" items="${imageIds}">
        <img src=".././FarmDataRetrieveServlet?id=<c:out value="${imageData}"/>" width="100px" height="100px">
        <br>
    </c:forEach>
</body>
</html>
