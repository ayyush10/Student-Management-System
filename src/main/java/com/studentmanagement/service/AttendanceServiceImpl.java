package com.studentmanagement.service;

import com.studentmanagement.dao.AttendanceDAO;
import com.studentmanagement.model.Attendance;
import com.studentmanagement.service.AttendanceService;

import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceDAO attendanceDAO;  // Injected DAO instance

    public AttendanceServiceImpl(AttendanceDAO attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
    }

    @Override
    public void markAttendance(String rollNumber, boolean isPresent) {
        Attendance attendance = new Attendance();
        attendance.setRollNumber(rollNumber);
        attendance.setPresent(isPresent);
        attendanceDAO.save(attendance);  // Save attendance record using DAO
    }

    @Override
    public List<Attendance> getAttendanceByRollNumber(String rollNumber) {
        return attendanceDAO.findByRollNumber(rollNumber);  // Retrieve attendance records by roll number
    }

    @Override
    public double calculateAttendancePercentage(String rollNumber) {
        List<Attendance> attendanceRecords = attendanceDAO.findByRollNumber(rollNumber);
        int totalClasses = attendanceRecords.size();
        int presentCount = (int) attendanceRecords.stream().filter(Attendance::isPresent).count();
        if (totalClasses > 0) {
            return (double) presentCount / totalClasses * 100;
        }
        return 0;
    }
}
