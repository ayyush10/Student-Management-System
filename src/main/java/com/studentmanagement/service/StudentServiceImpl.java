package com.studentmanagement.service;

import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;  // Injected DAO instance

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.save(student);  // Delegating to the DAO layer for persistence
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();  // Retrieving all students from the DAO
    }

    @Override
    public Student getStudentByRollNumber(String rollNumber) {
        return studentDAO.findByRollNumber(rollNumber);  // Fetch student by roll number
    }

    @Override
    public void markAttendance(String rollNumber, boolean isPresent) {
        Student student = studentDAO.findByRollNumber(rollNumber);
        if (student != null) {
            student.setAttendance(isPresent);
            studentDAO.update(student);  // Updating attendance in the database
        }
    }

    @Override
    public double getAttendancePercentage(String rollNumber) {
        Student student = studentDAO.findByRollNumber(rollNumber);
        if (student != null) {
            int totalClasses = student.getTotalClasses();
            int attendedClasses = student.getAttendedClasses();
            if (totalClasses > 0) {
                return (double) attendedClasses / totalClasses * 100;
            }
        }
        return 0;
    }

    @Override
    public String calculatePerformanceGrade(String rollNumber) {
        Student student = studentDAO.findByRollNumber(rollNumber);
        if (student != null) {
            double attendancePercentage = getAttendancePercentage(rollNumber);
            if (attendancePercentage >= 90) {
                return "A";
            } else if (attendancePercentage >= 80) {
                return "B";
            } else if (attendancePercentage >= 70) {
                return "C";
            } else if (attendancePercentage >= 60) {
                return "D";
            } else {
                return "F";
            }
        }
        return "N/A";
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.update(student);  // Delegate to the DAO
    }

}
