package org.example.campusevent.model;

import org.springframework.stereotype.Component;

@Component
public class Admin {

    private int adminID;
    private String adminName;
    private String adminEmail;
    private String role;

    public Admin() {

    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Amin [ID=" + adminID +
                ", name=" + adminName +
                ", email=" + adminEmail +
                ", role=" + role + "]";
    }

}
