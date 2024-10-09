package com.studentmanagement.dao;

import com.studentmanagement.model.Performance;
import java.util.List;

public interface PerformanceDAO {
    void save(Performance performance);   // Save a new performance entry
    void update(Performance performance); // Update an existing performance entry
    Performance findById(int id);         // Find performance by its ID
    List<Performance> findByStudentId(int studentId); // Find performance entries by student ID
    List<Performance> findAll();          // Retrieve all performance records
    void delete(int id);                  // Delete a performance entry by ID
}
