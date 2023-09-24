<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="admin_pages/css/bootstrap.min.css">
        <link rel="stylesheet" href="admin_pages/css/mdb.min.css">
        
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
  <!-- Navbar -->
        
        
        <table class="table align-middle mb-0 bg-white table-bordered table-responsive">
            <tr>
                <th>id</th>
                <th>Location</th>
                <th>Description</th>
                <th>Farm size</th>
                <th>Farm Price</th>
                <th>Status</th>
                <th>Sales Status</th>
                <th>Contact</th>
                <th>Action</th>
            </tr>
            
        <c:forEach var="users" items="${display}">
            <tr>
                <td>${users.id}</td>
                <td>${users.location}</td>
                <td>${users.desscription}</td>
                <td>${users.farm_size}</td>
                <td>${users.farm_price}</td>
                <td>${users.status}</td>
                <td>${users.sales_status}</td>
                <td>${users.contact}</td>
                <td ><a class="text-danger" href="/OnlineFarmRentingSystem/deleteData?id=${users.id}" onclick="return confirm('Are you sure you want to delete?')">delete</a></td>
            </tr>
           
        </c:forEach>
        </table>
    </body>
</html>
