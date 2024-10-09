<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mark Attendance</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="form-container">
    <h2>Mark Attendance</h2>
    <form action="attendance/mark" method="POST">
        <div class="form-group">
            <label for="rollNumber">Roll Number:</label>
            <input type="text" id="rollNumber" name="rollNumber" required>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="Present">Present</option>
                <option value="Absent">Absent</option>
            </select>
        </div>
        <div class="form-group">
            <button type="submit">Mark Attendance</button>
        </div>
    </form>
</div>
</body>
</html>
