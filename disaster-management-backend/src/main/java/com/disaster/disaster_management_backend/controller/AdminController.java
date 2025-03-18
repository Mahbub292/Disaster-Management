package com.disaster.disaster_management_backend.controller;

import com.disaster.disaster_management_backend.service.AdminService;
import com.disaster.disaster_management_backend.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

    @Autowired
    public AdminService adminService;

    @GetMapping("/volunteers")
    public List<Users> getVolunteers(){
        return adminService.getVolunteers();
    }

    @GetMapping("/volunteer/approved/{id}")
    public String approvedVolunteer(@PathVariable Long id){
        return adminService.approvedVolunteer(id);
    }
    @GetMapping("/volunteer/reject/{id}")
    public String rejectVolunteer(@PathVariable Long id){
        return adminService.rejectVolunteer(id);
    }
    @DeleteMapping("/volunteer/delete/{id}")
    public String deleteVolunteer(@PathVariable Long id){
        return adminService.deleteVolunteer(id);
    }
}
