<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

      <header class="site-navbar js-sticky-header site-navbar-target" role="banner">
      <c:set var="first_name" value="${sessionScope.first_name}" />
      <c:set var="last_name" value="${sessionScope.last_name}" />
      <c:set var="user_type" value="${sessionScope.user_type}" />

        <div class="container">
          <div class="row align-items-center position-relative">


            <div class="site-logo">
              <a href="index.html" class="text-black"><span class="text-primary">Farmers<sup>Zone</sup></a>
            </div>

            <div class="col-12">
              <nav class="site-navigation text-right ml-auto " role="navigation">

                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li><a href="test.jsp" class="nav-link">Home</a></li>

                  <li class="has-children">
                    <a href="#about-section" class="nav-link">Services</a>
                    <ul class="dropdown arrow-top">
                      <c:choose>
						<c:when test="${user_type == 'BUYER' }">
							<li><a href="buyer.jsp?status=PURCHASE" class="nav-link">Buy</a></li>
                            <li><a href="buyer.jsp?status=RENT" class="nav-link">Rent</a></li>
						</c:when>
						<c:when test="${user_type == 'SELLER' }">
							<li><a href="add_farm.jsp" class="nav-link">Lease/Sale</a></li>
                            
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					 </c:choose>
                    </ul>
                    <c:choose>
						<c:when test="${user_type == 'SELLER' }">
							<li><a href="MyFarm.jsp" class="nav-link">My Farm</a></li>
						</c:when>
						<c:when test="${user_type == 'BUYER' }">
							<li><a href="#" class="nav-link">My Assets</a></li>
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					 </c:choose>
                  </li>

                  <!-- <li><a href="#why-us-section" class="nav-link">Why Us</a></li>

                  <li><a href="#testimonials-section" class="nav-link">Testimonials</a></li>
                  <li><a href="#blog-section" class="nav-link">Blog</a></li>
                  <li><a href="#contact-section" class="nav-link">Contact</a></li> -->
                  
                  <li class="has-children">
                    <a href="#profile" class="nav-link" style="font-size: 1.5em;"><strong>Welcome, ${first_name} ${last_name}</strong></a>
                    <ul class="dropdown arrow-top">
                    	<li><a href="#settings" class="accountSettings.jsp">Account Settings</a></li>
                    	<li><a href="LogoutServlet" class="nav-link">Logout</a></li>
                    </ul>
                  </li>
                  
                </ul>
              </nav>

            </div>

            <div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

          </div>
        </div>

      </header>
  

