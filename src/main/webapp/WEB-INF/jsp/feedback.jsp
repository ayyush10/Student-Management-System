<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Feedback</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="alert alert-info my-4" role="alert">
        <h4 class="alert-heading">Feedback</h4>
        <p>${feedbackMessage}</p> <!-- The feedback message set in the servlet -->
        <hr>
        <a href="students" class="btn btn-primary">Back to Student Dashboard</a> <!-- Redirect back to the student dashboard -->
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
