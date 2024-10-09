package com.studentmanagement.controller;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", urlPatterns = {"/students", "/add-student", "/edit-student", "/delete-student"})
public class StudentController extends HttpServlet {

    private StudentService studentService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/add-student":
                showNewForm(request, response);
                break;
            case "/edit-student":
                showEditForm(request, response);
                break;
            case "/delete-student":
                deleteStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/add-student":
                addStudent(request, response);
                break;
            case "/edit-student":
                updateStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/student-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/student-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentService.getStudentById(id);
        request.setAttribute("student", existingStudent);
        request.getRequestDispatcher("/student-form.jsp").forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");

        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setRollNumber(rollno);
        studentService.addStudent(newStudent);  // Use service layer instead of DAO directly

        response.sendRedirect("students");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setRollNumber(rollno);
        studentService.updateStudent(student);  // Use service layer instead of DAO directly

        response.sendRedirect("students");
    }


    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(id);
        response.sendRedirect("students");
    }
}
