package com.studentmanagement.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the hibernate.cfg.xml configuration file
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception and rethrow
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the SessionFactory object to use in DAO layer
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Close caches and connection pools
    public static void shutdown() {
        getSessionFactory().close();
    }
}
