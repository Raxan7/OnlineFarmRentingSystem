<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body{
		text-align: center;
	}
	
	button{
		background:  white;
		border-radius: 20px;
		border: 1px solid #dfe1e5;
		font-weight: bold;
		padding: 6px 12px;
	}
</style>
<meta charset="UTF-8">
<title>Farm Sold</title>
</head>
<body>
	<h2 style="color:red;">You can't delete a farm that has been sold!</h2>
	<a href="Seller.jsp?farm_id=${param.farm_id }"><button>Back</button></a>
</body>
</html>