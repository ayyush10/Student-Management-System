package com.studentmanagement.service;

import com.studentmanagement.model.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByRollNumber(String rollNumber);
    void markAttendance(String rollNumber, boolean isPresent);
    double getAttendancePercentage(String rollNumber);
    String calculatePerformanceGrade(String rollNumber);

    Student getStudentById(int id);

    void deleteStudent(int id);

    void updateStudent(Student student);
}
