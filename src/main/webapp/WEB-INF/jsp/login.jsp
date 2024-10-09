<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Smart Student Management System</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="login-container">
    <h2>Login to Your Account</h2>
    <form action="login" method="POST">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <button type="submit">Login</button>
        </div>
    </form>
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</div>
</body>
</html>
