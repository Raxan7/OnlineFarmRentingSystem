<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
    <head>
        <title>users</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="admin_pages/css/bootstrap.min.css">
         <link rel="stylesheet" href="admin_pages/css/mdb.min.css">
        <style>
            td{
                text-transform: lowercase;
            }
        </style>
    </head>
    <body>
        
        <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white">
    <div class="container-fluid">
      <button
        class="navbar-toggler"
        type="button"
        data-mdb-toggle="collapse"
        data-mdb-target="#navbarExample01"
        aria-controls="navbarExample01"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarExample01">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item active">
        <a class="nav-link" aria-current="page" href="admin_pages/Admin-Panel.html">Admin-Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/OnlineFarmRentingSystem/farmDisplayProcess">View-Farm</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/OnlineFarmRentingSystem/DisplayUsers">View-Users</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
        
  <table class="table align-middle mb-0 bg-white table-bordered table-responsive">
  <thead class="bg-light">
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>User Type</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="farm" items="${display}">
    <tr>
        <td>${farm.firstname}</td>
        <td>${farm.lastname}</td>
        <td>${farm.email}</td>
        <td>${farm.user_type}</td>
        <td><a class="text-danger" href="/OnlineFarmRentingSystem/deleteUser?email=${farm.email}" onclick="return confirm('Are sure you want to delete user?')">delete</a></td>
    
      
    </tr>
      </c:forEach>
  </tbody>
</table>
    </body>
</html>
