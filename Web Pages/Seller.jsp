<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Farm|View</title>
        <link rel="stylesheet" href="css/style11.css">

    </head>
    <body>
   		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/FarmRentSystemDB" 
						   user="saidi" password="blender1"/>
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM farm WHERE id = <c:out value="${param.farm_id }"></c:out>
		</sql:query>
		
		<c:forEach var="row" items="${rs.rows }">
			<div class="farm">
	               
	                    <img src="./FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" width="850px" class="image">
	    
	            <div class="description">
	                
	                    <h3>General descriptions</h3>
	                    <h3  style="color: white"><c:out value="${row.description }"></c:out></h3>
	                
	            </div>
	        </div>
	        <div class="hidden" id="confirm">
	        </div>
	        <div class="option">
	            <div class="bottom descript">
	                <h3 style="color: black">Actions</h3>
	                <h3>Price: <i class="fa-solid fa-beat-fade"><c:out value="${row.price }"></c:out>/=</i></h3><br>
	                <button>Edit</button>
	            
	                <i class="fa fa"></i>
	            </div>
	            <div class="descript">
	                <h3 style="color: black">location</h3>
	                <h3><c:out value="${row.location }"></c:out></h3>
                <!-- <h3>Region: Mbeya</h3>
	                <h3>District: Tukuyu</h3>
	                <h3>Specific: Tingatinga</h3> -->
	            </div>
	            <div class="descript">
	                <h3 style="color: black">Farm summary</h3>
	                <h3>Size: <c:out value="${row.farm_size }"></c:out> Hectares</h3>
	                <h3>Suitable for: Maize & Rice</h3>
	                <h3>Geographics: Basin</h3>
	            </div>
	            <div class="descript">
	                <h3 style="color: black">Seller Details</h3>
	                <h3>seller: Juma Hamadan</h3>
	                <h3>No: <c:out value="${row.contact }"></c:out></h3>
	            </div>
	        </div>
		</c:forEach>
    </body>
</html>