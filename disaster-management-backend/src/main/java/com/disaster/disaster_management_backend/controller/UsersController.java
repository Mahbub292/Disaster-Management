package com.disaster.disaster_management_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.disaster.disaster_management_backend.model.Donation;
import com.disaster.disaster_management_backend.model.Users;
import com.disaster.disaster_management_backend.service.UserService;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users userRegister(@RequestBody Users users){
        return userService.userRegister(users);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
    @GetMapping("/available-volunteers")
    public Long countvolunteers(){
        return userService.countVolunteers();
    }
    @GetMapping("/volunteers-info-local")
    public List<Users> getVolunteer(){
        return userService.getVolunteer();
    }
    @PostMapping("/donation")
    public Donation addDonationInfo(@RequestBody Donation donation){
        return userService.addDonationInfo(donation);
    }
    @GetMapping("/total-donation-amount")
    public Double getTotalDonationAmount(){
        return userService.getTotalDonationAmount();
    }
    
}
