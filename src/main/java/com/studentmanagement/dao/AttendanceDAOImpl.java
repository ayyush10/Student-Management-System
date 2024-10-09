package com.studentmanagement.dao.impl;

import com.studentmanagement.dao.AttendanceDAO;
import com.studentmanagement.model.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    private SessionFactory sessionFactory;  // Injected Hibernate session factory

    public AttendanceDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Attendance attendance) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(attendance);
        tx.commit();
        session.close();
    }

    @Override
    public List<Attendance> findByRollNumber(String rollNumber) {
        Session session = sessionFactory.openSession();
        List<Attendance> attendanceRecords = session.createQuery("from Attendance where rollNumber = :rollNumber", Attendance.class)
                .setParameter("rollNumber", rollNumber)
                .list();
        session.close();
        return attendanceRecords;
    }
}
