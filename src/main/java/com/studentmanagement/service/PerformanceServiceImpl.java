package com.studentmanagement.service.impl;

import com.studentmanagement.service.AttendanceService;
import com.studentmanagement.service.PerformanceService;

public class PerformanceServiceImpl implements PerformanceService {

    private AttendanceService attendanceService;  // Injected AttendanceService for attendance data

    public PerformanceServiceImpl(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @Override
    public String calculateGrade(String rollNumber) {
        double attendancePercentage = attendanceService.calculateAttendancePercentage(rollNumber);

        // Sample grading logic based on attendance percentage
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
}
