<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		body {
			padding: 20px;
		}
	    .about{
		    padding: 1rem;
		    border: 1px rgb(4, 4, 8) solid;
		    display: flex;
		    flex-direction: row;
		    justify-content: space-between;
		    border-radius: 15px;
		    max-width: 150%;
		    max-height: 100%;
		    margin-bottom: 10px;
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
	
	   </style>
	   <link rel="stylesheet" href="css/style.css">
	</head>
	<body style="text-align: center;">
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
		<%@ include file="navigation.html" %>
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/FarmRentSystemDB" 
						   user="saidi" password="blender1"/>
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM images
		</sql:query>
		
		<c:forEach var="row" items="${rs.rows }">
			<div class="about">
		       <div class="paragraph">
		   		<h2><c:out value="${row.name }"></c:out></h2>
		           <h3>online farm selling and renting system </h3>
		           Welcome to our online farm selling and renting system where we aim to simplify this matter
		           and as we know most of people depend on agriculture in order to earn living. 
		       </div>
		       <div class="image">
		           <img src="./FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" width="300px" height="200px">
		       </div>
		   </div>
		</c:forEach>
	</body>
</html>



