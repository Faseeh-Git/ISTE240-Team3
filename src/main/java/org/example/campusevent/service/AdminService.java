package org.example.campusevent.service;

import org.example.campusevent.model.Admin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private List<Admin> admins = new ArrayList<>();

    public AdminService(){
        admins.add(new Admin(1, "John", "johnadmin@gmail.com", "designer"));
        admins.add(new Admin(2, "James", "jamesadmin@gmail.com", "maintenance"));
    }

    public List<Admin> getAdmin(){
        return admins;
    }

    public void addAdmin(Admin admin){
        admins.add(admin);
    }
}