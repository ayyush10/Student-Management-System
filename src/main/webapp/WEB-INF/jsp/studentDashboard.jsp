<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="my-4">Student Management Dashboard</h2>

    <!-- Display Feedback Messages -->
    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>

    <!-- Student List Table -->
    <h3>Student List</h3>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Roll Number</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.rollNumber}</td>
                <td>${student.email}</td>
                <td>
                    <a href="edit-student?id=${student.id}" class="btn btn-primary btn-sm">Edit</a>
                    <a href="delete-student?id=${student.id}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Add New Student Button -->
    <a href="add-student" class="btn btn-success my-3">Add New Student</a>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
