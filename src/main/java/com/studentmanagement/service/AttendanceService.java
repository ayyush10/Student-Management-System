package com.studentmanagement.service;

import com.studentmanagement.model.Attendance;

import java.util.List;

public interface AttendanceService {
    void markAttendance(String rollNumber, boolean isPresent);
    List<Attendance> getAttendanceByRollNumber(String rollNumber);
    double calculateAttendancePercentage(String rollNumber);
}
