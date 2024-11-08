<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Farm|View</title>
        <%@ include file="../auth/include/navbar_css.html" %>
        <link rel="stylesheet" href="../css/style11.css">

    </head>
    <body>
   		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
		<%@ include file="../auth/form_index.jsp" %>
		
		
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
			   url="jdbc:mysql://localhost:3306/FarmRentSystemDB" 
			   user="saidi" password="blender1"/>
			   
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM farm WHERE id = <c:out value="${param.farm_id }"></c:out>
		</sql:query>
		
		
		
		<c:forEach var="row" items="${rs.rows }">
			<div class="card">
	            <img class="image" src=".././FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>">
	            <div>
	            	<h2>Farm Description</h2>
	                <h3><c:out value="${row.location }"></c:out></h3>
	                <p class="farm-description-p"><c:out value="${row.description }"></c:out></p>
	            </div>
	        </div>
	        <br>
	        <br>
	        <div class="option">
	            <div class="bottom descript">
	                <h3 id="h3" style="color: black">Farm Price</h3>
	                <h3 id="h3">Price: <i class="fa-solid fa-beat-fade"><c:out value="${row.farm_price }"></c:out>/=</i></h3><br>
	            </div>
	            <div class="descript">
	                <h3 id="h3" style="color: black">Farm Location</h3>
	                <h3 id="h3"><c:out value="${row.location }"></c:out></h3>
	            </div>
	            <div class="descript">
	                <h3 id="h3" style="color: black">Farm Summary</h3>
	                <h3 id="h3">Size: <c:out value="${row.farm_size }"></c:out> Hectares</h3>
	                <h3 id="h3">Suitable for: Maize & Rice</h3>
	            </div>
	            <div class="descript">
	                <h3 id="h3" style="color: black">Seller Details</h3>
	                <h3 id="h3">Seller: <c:out value="${row.owner }"></c:out></h3>
	                <h3 id="h3">No: <c:out value="${row.contact }"></c:out></h3>
	            </div>
	        </div>
	        <div class="edit-delete-btns">
	        	<a href="Edit.jsp?farm_id=${row.id }"><button id="edit-btn" class="custom-btns">Edit</button></a>
	        	<a href="../DeleteServlet?farm_id=${row.id }"><button id="delete-btn" class="custom-btns" onclick="return confirm('Are you sure you want to delete?')">Delete</button></a>
	        </div>
		</c:forEach>
    </body>
</html>