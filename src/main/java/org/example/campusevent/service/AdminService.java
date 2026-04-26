// Name: Brendon ID: 761008604

package org.example.campusevent.service;

import org.example.campusevent.model.Admin;
import org.example.campusevent.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Search admins by name
    public List<Admin> findByAdminName(String name) {
        return adminRepository.findByAdminName(name);
    }

    // Save admin
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    // Update admin
    public Admin update(Long id, Admin updatedAdmin) {

        Admin existing = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        existing.setAdminName(updatedAdmin.getAdminName());
        existing.setAdminEmail(updatedAdmin.getAdminEmail());
        existing.setRole(updatedAdmin.getRole());

        return adminRepository.save(existing);
    }

    // Delete admin
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}