<%
response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account setting</title>
    <style>
        body{
        margin-top: none;
        margin-left: 20rem;
        padding: 8rem;
        border: 1px rgb(4, 4, 8) solid;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        border-radius: 15px;
        width: 20%;
        height: 10%;
        }
    </style>
</head>
<body>
    <form>
        <h1>Account setting</h1><br>
        <div>
            <h3>First name</h3>
            <label for="first_name"></label>
            <input type="text" name="fname" value="restuta" disabled>
        </div><br>
        <div>
            <h3>Last name</h3>
            <label for="last_name"></label>
            <input type="text" name="lname" value="qambesh" disabled>
        </div><br>
        <div>
            <h3>Email</h3>
            <label for="email"></label>
            <input type="text" name="email" value="er@gmail.com" disabled>
        </div><br>
        <div>
            <h3>Password</h3>
            <label for="password"></label>
            <input type="text" name="password" value="awaire" disabled>
        </div><br>
        <div>
            <h3>User type</h3>
           <label for="user_type"></label>
           <input type="text" name="usertype" value="farmers" disabled>
        </div>
    </form>
</body>
</html>