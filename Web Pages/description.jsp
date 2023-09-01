<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Farm|View</title>
        <link rel="stylesheet" href="css/farm.css">
        <link rel="stylesheet" href="css/awesome/css/all.css">
    </head>
    <body>
   		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
		<%@ include file="navigation.html" %>
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/FarmRentSystemDB" 
						   user="saidi" password="blender1"/>
		<sql:query dataSource="${db}" var="rs">
			SELECT * FROM farm WHERE id = <c:out value="${row.farm_size }"></c:out>
		</sql:query>
		
		<c:forEach var="row" items="${rs.rows }">
			<div class="container">
	            <div class="farm">
	                <div class="img">
	                    <img src="css/pexel.jpg" alt>
	                </div>
	            </div>
	            <div class="farm">
	                <div style="padding: 10px;" class>
	                    <h3>General discriptions</h3>
	                    <h3  style="color: white">
	                    This farm is located at mbeya suitable for maize produaction
	                    it is located at
	                    tukuyu near the tinga tinga street Annsbdbn xbbsn fndf dfn
	                    sdnsdsnb snfsnfbd ffvdnfhsn
	                    sdsfbns sdnsnbdsnfssbn sndsbnds ds dfsnjdhs smdns dsnmdshns
	                    dsds dsdfsds dsndfs dfsndfsd dfsnfbs
	                    sdhsfsnfs sndfsdfnbsd fsdfnsd fsdfnsb fsndfb
	                    fsdnfsdfjslsknmdnnf dmfnf dfdnmf sdnm
	                    sndsdfnsbbnbsdbnsdbsfbnfbnf sjdfnf shvnd vdj gfj fnn dsksjzn weskfdn fekjrdn jhdfdndjhfd djfdkkmdf
	                    dfjdhfdmndf   fgkdf g flkgf gfj f gmkf g fgkf g fkm   fg djhfd
	                    bnfggnmfmngfn fmgnf fnmgf gnkg fgfmg fgfmng fgfjgnf gfmng fggfgd df hdj 
	
	                    </h3>
	                </div>
	            </div>
	        </div>
	        <div class="hidden" id="confirm">
	        </div>
	        <div class="option">
	            <div class="bottom descript">
	                <h3 style="color: black">Actions</h3>
	                <h3>Price: <i class="fa-solid fa-beat-fade">5000/=</i></h3><br>
	                <h3><button>Buy</button></h3>
	                <h3><button>Rent</button></h3>
	                <i class="fa fa"></i>
	            </div>
	            <div class="descript">
	                <h3 style="color: black">location</h3>
	                <h3>Region: Mbeya</h3>
	                <h3>District: Tukuyu</h3>
	                <h3>Specific: Tingatinga</h3>
	            </div>
	            <div class="descript">
	                <h3 style="color: black">Farm sumary</h3>
	                <h3>Size: 2 Hectares</h3>
	                <h3>Suitable for: Maize & Rice</h3>
	                <h3>Geographics: Basin</h3>
	            </div>
	            <div class="descript">
	                <h3 style="color: black">Seller Details</h3>
	                <h3>seller: Juma Hamadan</h3>
	                <h3>No: +2556275347678</h3>
	            </div>
	        </div>
		</c:forEach>
    </body>
</html>