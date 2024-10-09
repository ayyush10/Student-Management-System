package com.studentmanagement.dao;

import com.studentmanagement.model.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);  // Remove static


    void update(Student student);
    List<Student> findAll();
    Student findByRollNumber(String rollNumber);
}
