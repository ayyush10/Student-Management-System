package com.studentmanagement.controller;

import com.studentmanagement.model.Admin;
import com.studentmanagement.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminController", urlPatterns = {"/admin", "/login", "/logout", "/admin-dashboard"})
public class AdminController extends HttpServlet {

    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/login":
                showLoginForm(request, response);
                break;
            case "/logout":
                logoutAdmin(request, response);
                break;
            case "/admin-dashboard":
                showAdminDashboard(request, response);
                break;
            default:
                response.sendRedirect("login");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if ("/login".equals(action)) {
            loginAdmin(request, response);
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = new Admin(username, password);

        if (adminService.validateAdmin(admin)) {
            // Create a session for the admin
            HttpSession session = request.getSession();
            session.setAttribute("adminUser", username);
            response.sendRedirect("admin-dashboard");
        } else {
            // Invalid login attempt
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void showAdminDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if admin is logged in
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("adminUser") != null) {
            request.getRequestDispatcher("/admin-dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    private void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session to log out
        }
        response.sendRedirect("login");
    }
}
