// Name: Brendon
// ID: 761008604

package org.example.campusevent.controller;

import org.example.campusevent.model.Admin;
import org.example.campusevent.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return service.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return service.getAdminById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Admin> searchAdmins(@RequestParam String name) {
        return service.searchAdminsByName(name);
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return service.createAdmin(admin);
    }

    @PutMapping("/{id}")
    public int updateRole(@PathVariable Long id,
                          @RequestParam String role) {
        return service.updateAdminRole(id, role);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);
    }
}