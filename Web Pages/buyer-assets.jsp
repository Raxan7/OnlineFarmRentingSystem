<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Buyer Assets</title>
	    <%@ include file="auth/include/navbar_css.html" %>
	    <link rel="stylesheet" href="css/list_view.css">
	</head>
	<body style="text-align: center; background: silver;">
		<%@ include file="auth/form_index.jsp" %>
		<c:set var="user_id" value="${sessionScope.email}" />
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://sql.freedb.tech:3306/freedb_raxan7_db" 
						   user="freedb_saidi" password="7*vtUS?fjyBFJg3"/>
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM farm WHERE buyer_id = '${user_id }'
		</sql:query>
		
		<div class="list-view-container">
			<c:forEach var="row" items="${rs.rows }">
			   
			   <a href="description.jsp?farm_id=${row.id }">
			   		<div class="product">
					    <div class="product-image">
					        
					        <img src="./FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" alt="Product Image">
					    </div>
					    <div class="product-details">
					        <h3 class="product-title">Farm Location : <strong><c:out value="${row.location }"></c:out></strong></h3>
					        <p class="product-description text-color">
					            ${row.description }
					        </p>
					        <div class="sales-details-div">
					        	<p class="product-price"><strong>Price : </strong>Tsh. <c:out value="${row.farm_price }"></c:out></p>
					        	<c:choose>
									<c:when test="${row.sales_status == 'SOLD' }">
										<p class="product-price"><strong>Bought By : <c:out value="${row.buyer_id }"></c:out></strong></p>
									</c:when>
									<c:when test="${user_type == 'AVAILABLE' }">

									</c:when>
									<c:otherwise>
										
									</c:otherwise>
								 </c:choose>
					        </div>
					        
					    </div>
					</div>
			   </a>
			</c:forEach>
		</div>
		
		<%@ include file="auth/include/javascripts.html" %>
	</body>
</html>



