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
    <div class="form-container">
        <h2>Farm Details</h2>
        <form action="FarmRegisterServlet" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="location">Farm Location</label>
                <input type="text" id="location" name="location" required>
            </div>
            <div class="form-group">
                <label for="image">Farm Picture</label>
                <input type="file" id="image" name="image" required>
            </div>
            <div class="form-group">
                <label for="description">Farm Description</label>
                <textarea id="description" name="description" required></textarea>
            </div>
            <div class="form-group">
                <label for="fsize">Farm Size</label>
                <input type="text" id="fsize" name="fsize" required>
            </div>
            <div class="form-group">
                <label>Farm Status</label>
                <input type="radio" id="rent" name="fstatus" value="RENT" required>
                <label for="rent">Rent</label>
                <input type="radio" id="purchase" name="fstatus" value="PURCHASE" required>
                <label for="purchase">Purchase</label>
            </div>
            <div class="form-group">
                <label for="contact">Contact</label>
                <input type="text" id="contact" name="contact" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
    <%@ include file="auth/include/javascripts.html" %>
</body>
</html>
