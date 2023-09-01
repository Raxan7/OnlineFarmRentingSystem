<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
	    .about{
		    padding: 1rem;
		    border: 1px rgb(4, 4, 8) solid;
		    display: flex;
		    flex-direction: row;
		    justify-content: space-between;
		    border-radius: 15px;
		    min-width: 150%;
		    max-height: 100%;
		    margin-bottom: 10px;
		    backdrop-filter: blur(20px);
		}
		.image img{
		    border-radius: 15px;
		    max-width: 97%;
		}
		h2{
		    text-align: center;
		}
		.paragraph{
		    padding: 1rem;
		    background-color:rgb(233, 213, 213);
		    border-radius: 15px;
		    left: 1rem;
		    width: 97%;
		    margin-right: 3%;
		}
		.list-view-container {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
		paragraph {
			text-align: left;
		}
	
	   </style>
	   <%@ include file="auth/include/navbar_css.html" %>
	</head>
	<body style="text-align: center; background: silver;">
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
		<%@ include file="auth/form_index.jsp" %>
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/FarmRentSystemDB" 
						   user="saidi" password="blender1"/>
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM farm
		</sql:query>
		
		

		<div class="list-view-container">
			<c:forEach var="row" items="${rs.rows }">
				<div class="about">
			       <div class="paragraph" style="background-color: lightgreen;">
			   		<h2><c:out value="${row.location }"></c:out></h2><!-- Farm Location for Rent/Buy -->
			   		<br>
			           <h4 style="text-align: left;"><c:out value="${row.farm_size }"></c:out> Hectares </h4>
			           <br>
			           <p style="text-align: left;"><c:out value="${row.description }"></c:out></p> 
			       </div>
			       <div class="image">
			           <img src="./FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" width="300px" height="200px">
			       </div>
			   </div>
			</c:forEach>
		</div>
		
		<%@ include file="auth/include/javascripts.html" %>
	</body>
</html>



