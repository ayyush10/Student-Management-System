package com.studentmanagement.dao;

import com.studentmanagement.model.Attendance;
import java.util.List;

public interface AttendanceDAO {
    void save(Attendance attendance);
    List<Attendance> findByRollNumber(String rollNumber);
}
