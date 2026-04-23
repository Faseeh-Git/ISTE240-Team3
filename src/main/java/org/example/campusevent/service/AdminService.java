// Name: Brendon
// ID: 761008604

package org.example.campusevent.service;

import jakarta.transaction.Transactional;
import org.example.campusevent.model.Admin;
import org.example.campusevent.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Admin createAdmin(Admin admin) {

        if(admin.getAdminEmail() == null || admin.getAdminEmail().isEmpty())
            throw new RuntimeException("Email cannot be empty");

        return repository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return repository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return repository.findById(id);
    }

    public List<Admin> searchAdminsByName(String name) {
        return repository.findByAdminName(name);
    }

    public int updateAdminRole(Long id, String role) {
        return repository.updateRoleById(id, role);
    }

    public void deleteAdmin(Long id) {
        repository.deleteById(id);
    }
}