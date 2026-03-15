package org.example.campusevent.controller;

import org.example.campusevent.model.Admin;
import org.example.campusevent.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String getAdmins(Model model){
        model.addAttribute("admins", adminService.getAdmin());
        return "admin";
    }

    @GetMapping("/admin/add")
    public String showAddAdmin(){
        return "addadmin";
    }

    @PostMapping("/admin/add")
    public String addAdmin(Admin admin){
        adminService.addAdmin(admin);
        return "success";
    }
}