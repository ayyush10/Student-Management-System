package com.studentmanagement.listener;

import com.studentmanagement.dao.AttendanceDAO;
import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.dao.impl.AttendanceDAOImpl;
import com.studentmanagement.dao.impl.StudentDAOImpl;
import com.studentmanagement.service.AttendanceService;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.service.AttendanceServiceImpl;
import com.studentmanagement.service.StudentServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Set up Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(com.studentmanagement.model.Student.class)
                .addAnnotatedClass(com.studentmanagement.model.Attendance.class)
                .buildSessionFactory();

        // Set up DAOs
        StudentDAO studentDAO = new StudentDAOImpl(sessionFactory);
        AttendanceDAO attendanceDAO = new AttendanceDAOImpl(sessionFactory);

        // Set up Services
        StudentService studentService = new StudentServiceImpl(studentDAO);
        AttendanceService attendanceService = new AttendanceServiceImpl(attendanceDAO);

        // Store these in the servlet context for global access
        sce.getServletContext().setAttribute("studentService", studentService);
        sce.getServletContext().setAttribute("attendanceService", attendanceService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup Hibernate session factory
        SessionFactory sessionFactory = (SessionFactory) sce.getServletContext().getAttribute("sessionFactory");
        sessionFactory.close();
    }
}
