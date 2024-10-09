package com.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private int id;
    private String name;
    private String rollNumber;
    private String email;

    // Constructors, Getters, and Setters

    public Student() {}

    public Student(int id, String name, String rollNumber, String email) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
    }

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

    public void setAttendance(boolean isPresent) {
    }
}
