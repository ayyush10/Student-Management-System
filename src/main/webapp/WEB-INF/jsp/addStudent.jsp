<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Student</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="form-container">
    <h2>Add New Student</h2>
    <form action="student/add" method="POST">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="rollNumber">Roll Number:</label>
            <input type="text" id="rollNumber" name="rollNumber" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <button type="submit">Add Student</button>
        </div>
    </form>
</div>
</body>
</html>
