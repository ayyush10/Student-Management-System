package com.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    private int id;
    private String name;
    private String rollNumber;
    private String email;
    private int totalClasses;  // New fields for attendance tracking
    private int attendedClasses;

    public Student() {}

    public Student(int id, String name, String rollNumber, String email) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
    }

    // Getters and setters for new fields

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    public void setAttendance(boolean isPresent) {
        if (isPresent) {
            attendedClasses++;
        }
        totalClasses++;
    }
}
