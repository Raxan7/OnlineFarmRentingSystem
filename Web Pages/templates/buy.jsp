<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate"); 
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <style>
            body {
                background-color: #e9e0e0fa;
                text-align: center;
            }

            .input {
                position: relative;
                margin: 20px;
            }

            .input input {
                font-size: 16px;
                min-width: 1ch;
                background-color: #cdccccfa;
                outline: none;
                height: 0.5rem;
                border: none;
                border-bottom: 2px #75bb6d solid;
                transform: border 1s ease-in-out;
                border-top-left-radius: 10px;
                border-bottom-right-radius: 10px;
            }

            .input label {
                font-size: 20px;
                position: absolute;
                top: 0px;
                left: 6px;
                transition: 1s ease-out;
            }

            .input-field {
                padding: 10px;
                transition: 1s ease-out;
            }

            .input-field:focus {
                background-color: #e9e0e0;
                border-color: #ffb7b7;
                transform-origin: center;
            }

            .input-field:focus+label {
                top: -25px;
                color: #f55151;
            }

            .input input:valid+label {
                top: -25px;
            }

            .form form {
                width: 50%;
                background-color: #f4eeee;
                padding: 2rem;
                box-shadow: 4px 3px 3px #cecece;
                border-top-left-radius: 10px;
                border-bottom-right-radius: 50px;
            }

            .form {
                transform: translateY(7%);
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .submit input {
                height: 1.5rem;
                border: none;
                border-radius: 20px;
                background-color: #cdccccfa;
                width: 10rem;
            }

            .submit input:hover {
                background-color: #ffb7b7;
            }

            h2 {
                color: #75bb6d;
                .h3{
                    text-align: center;
                }
            }

            .image img {
                border-radius: 10px;
                min-width: 50%;
                max-width:60px;
                display:flex;
                margin-bottom:1rem;
            }
            
            .image {
            	display: flex;
                justify-content: center;
            }
            </style>	
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
				<div class="form">
	               <form action="../BuyServlet" method="post">
	                   <h2>Price Form</h2><br>
	                   <input type="hidden" id="farm_id" name="farm_id" value="<c:out value="${param.farm_id}" />">
	                   <div class="input">
	                       <h3>Tsh <c:out value="${row.farm_price }"></c:out>/=</h3>
	                   </div>
		               <br>
		               <div class="image">
		                   <img src=".././FarmDataRetrieveServlet?id=<c:out value="${row.id }"></c:out>" alt="">
		               </div>
		               <input type="submit" value="Confirm  transaction ">
		           </form>
		       </div>
			</c:forEach>
    <br><br><br>
    <br><br><br>
</body>
</html>