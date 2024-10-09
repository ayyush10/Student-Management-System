package com.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "performance")
public class Performance {

    @Id
    private int id;
    private int studentId;
    private String subject;
    private double score;

    // Constructors, Getters, and Setters

    public Performance() {}

    public Performance(int id, int studentId, String subject, double score) {
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
