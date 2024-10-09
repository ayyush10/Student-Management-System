<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentmanagement.model.Student"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>View Students</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="table-container">
  <h2>Student List</h2>
  <table>
    <thead>
    <tr>
      <th>Roll Number</th>
      <th>Name</th>
      <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Student> students = (List<Student>) request.getAttribute("students");
      if (students != null) {
        for (Student student : students) {
    %>
    <tr>
      <td><%= student.getRollNumber() %></td>
      <td><%= student.getName() %></td>
      <td><%= student.getEmail() %></td>
    </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>
