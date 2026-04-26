// Name: Brendon ID: 761008604

package org.example.campusevent.controller;

import org.example.campusevent.model.Admin;
import org.example.campusevent.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // List all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Search admin by name
    @GetMapping("/search")
    public List<Admin> searchAdmins(@RequestParam String name) {
        return adminService.findByAdminName(name);
    }

    // save new admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    // Update admin
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id,
                             @RequestBody Admin admin) {
        return adminService.update(id, admin);
    }

    // delete admin
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.delete(id);
    }
}