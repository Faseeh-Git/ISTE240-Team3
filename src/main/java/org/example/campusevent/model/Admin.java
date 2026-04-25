// Name: Brendon ID: 761008604

package org.example.campusevent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminID;

    @Column(length = 50, nullable = false)
    private String adminName;

    @Column(length = 100, nullable = false, unique = true)
    private String adminEmail;

    @Column(nullable = false)
    private String role;

    public Admin(){}

    public Admin(String adminName, String adminEmail, String role) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.role = role;
    }

    public Long getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getRole() {
        return role;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public void setRole(String role) {
        this.role = role;
    }
}