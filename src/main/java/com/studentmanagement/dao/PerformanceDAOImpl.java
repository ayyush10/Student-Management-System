package com.studentmanagement.dao;

import com.studentmanagement.model.Performance;
import com.studentmanagement.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PerformanceDAOImpl implements PerformanceDAO {

    @Override
    public void save(Performance performance) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(performance);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Performance performance) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(performance);
        tx.commit();
        session.close();
    }

    @Override
    public Performance findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Performance performance = session.get(Performance.class, id);
        session.close();
        return performance;
    }

    @Override
    public List<Performance> findByStudentId(int studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Performance> performances = session
                .createQuery("FROM Performance WHERE studentId = :studentId", Performance.class)
                .setParameter("studentId", studentId)
                .list();
        session.close();
        return performances;
    }

    @Override
    public List<Performance> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Performance> performances = session.createQuery("FROM Performance", Performance.class).list();
        session.close();
        return performances;
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Performance performance = session.get(Performance.class, id);
        if (performance != null) {
            session.delete(performance);
        }
        tx.commit();
        session.close();
    }
}
