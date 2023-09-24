<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate"); 
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	    <%@ include file="../auth/include/navbar_css.html" %>
	    <link rel="stylesheet" href="../css/list_view.css">
	    
	</head>
	<body style="text-align: center; background: silver;">
		<%@ include file="../auth/form_index.jsp" %>
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
			   url="jdbc:mysql://localhost:3306/FarmRentSystemDB" 
			   user="saidi" password="blender1"/>
			   
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM farm WHERE status='${param.status}' ORDER BY CASE WHEN sales_status = 'AVAILABLE' THEN 0 ELSE 1 END, sales_status;
		</sql:query>
		
		<div class="list-view-container">
			<c:forEach var="row" items="${rs.rows }">
			   
			   <a href="description.jsp?farm_id=${row.id }">
			   		<c:choose>
						<c:when test="${row.sales_status == 'AVAILABLE' }">
							<div class="product">
							    <div class="product-image">
							        
							        <img class="image" src=".././FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" alt="Product Image">
							    </div>
							    <div class="product-details">
							        <h3 class="product-title">Farm Location : <strong><c:out value="${row.location }"></c:out></strong></h3>
							        <p class="product-description text-color">
							            ${row.description }
							        </p>
							        <div class="sales-details-div">
							        	<p class="product-price"><strong>Price : </strong>Tsh. <c:out value="${row.farm_price }"></c:out></p>
							        	<p class="product-status"><strong style="color: indigo;">Availability : </strong><c:out value="${row.sales_status }"></c:out></p>
							        </div>
							        
							    </div>
							</div>
						</c:when>
						<c:when test="${row.sales_status == 'SOLD' }">
							<div style="background-color: #C0C0C0;" class="product">
							    <div class="product-image">
							        
							        <img src=".././FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" alt="Product Image">
							    </div>
							    <div class="product-details">
							        <h3 class="product-title">Farm Location : <strong><c:out value="${row.location }"></c:out></strong></h3>
							        <p class="product-description text-color">
							            ${row.description }
							        </p>
							        <div class="sales-details-div">
							        	<p class="product-price"><strong>Price : </strong>Tsh. <c:out value="${row.farm_price }"></c:out></p>
							        	<p class="product-status"><strong style="color: indigo;">Availability : </strong><c:out value="${row.sales_status }"></c:out></p>
							        </div>
							        
							    </div>
							</div>
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					 </c:choose>
			   </a>
			</c:forEach>
		</div>
		
		<%@ include file="../auth/include/javascripts.html" %>
	</body>
</html>



