<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farm Registration</title>
    <link rel="stylesheet" href="css/add_farm_styles.css">
    <%@ include file="auth/include/navbar_css.html" %>
</head>
<body>
	<%@ include file="auth/form_index.jsp" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	
	
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://sql.freedb.tech:3306/freedb_raxan7_db"						   
						   user="freedb_saidi" password="7*vtUS?fjyBFJg3"/>
	<sql:query dataSource="${db}" var="rs">
		SELECT * FROM farm WHERE id = <c:out value="${param.farm_id }"></c:out>
	</sql:query>
	
	<c:forEach var="row" items="${rs.rows }">
		<c:set var="location" value="${row.location}" />
        <c:set var="image" value="${row.image}" />
        <c:set var="description" value="${row.description}" />
        <c:set var="f_size" value="${row.farm_size}" />
        <c:set var="f_price" value="${row.farm_price}" />
        <c:set var="f_status" value="${row.status}" />
        <c:set var="scontact" value="${row.contact}" />
	</c:forEach>
		
    <div class="form-container">
        <h2>Farm Details</h2>
        <form action="EditFarmServelet" method="post">
        	<input type="hidden" id="farm_id" name="farm_id" value="<c:out value="${param.farm_id}" />">
        	
            <div class="form-group">
                <label for="location">Farm Location</label>
                <input type="text" id="location" name="location" value="<c:out value="${location}"></c:out>" required>
            </div>
            <div class="form-group">
                <label for="description">Farm Description</label>
                <textarea id="description" name="description"  required><c:out value="${description}"></c:out></textarea>
            </div>
            <div class="form-group">
                <label for="fsize">Farm Size</label>
                <input type="text" id="fsize" name="fsize" value="<c:out value="${f_size}"></c:out>" required>
            </div>
            <div class="form-group">
                <label for="fprice">Farm Price</label>
                <input type="text" id="fprice" name="fprice" placeholder="Enter the Price in Tanzanian Shillings" value="<c:out value="${f_price}"></c:out>" required>
            </div>
            <div class="form-group">
                <label>Farm Status</label>
                <c:choose>
	                <c:when test="${f_status=='RENT'}">
		                <input type="radio" id="rent" name="fstatus" value="RENT" required checked>
		                <label for="rent">Rent</label>
		                <input type="radio" id="purchase" name="fstatus" value="PURCHASE" required>
		                <label for="purchase">Purchase</label>
	                </c:when>
	                <c:when test="${f_status=='PURCHASE'}">
		                <input type="radio" id="rent" name="fstatus" value="RENT" required >
		                <label for="rent">Rent</label>
		                <input type="radio" id="purchase" name="fstatus" value="PURCHASE" required checked>
		                <label for="purchase">Purchase</label>
	                </c:when>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="contact">Contact</label>
                <input type="text" id="contact" name="contact" value="<c:out value="${scontact}"></c:out>" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Submit">
            </div>
            
        </form>
        

    </div>
</body>
</html>
