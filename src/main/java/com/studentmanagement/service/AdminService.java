package com.studentmanagement.service;

import com.studentmanagement.model.Admin;

public class AdminService {

    // Hardcoded admin credentials (for demo purposes)
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    // Validate admin credentials
    public boolean validateAdmin(Admin admin) {
        return ADMIN_USERNAME.equals(admin.getUsername()) && ADMIN_PASSWORD.equals(admin.getPassword());
    }
}
