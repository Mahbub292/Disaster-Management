package com.disaster.disaster_management_backend.service;
import com.disaster.disaster_management_backend.repo.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
import com.disaster.disaster_management_backend.model.*;

@Service
public class AdminService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private JavaMailSender mailSender;

    public String approvedVolunteer(Long id) {
        Users user = usersRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus("APPROVED");
        usersRepo.save(user);
        sendNotification(user, "Registration Approved", "Your registration has been approved. You can now log in.");
        return "Volunteer is Approved";
    }

    public String rejectVolunteer(Long userId) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus("REJECTED");
        usersRepo.save(user);
        sendNotification(user, "Registration Rejected", "Your registration has been rejected by the admin.");
        return "Volunteer is Rejected";
    }

    public List<Users> getVolunteers(){
        return usersRepo.findAll();
    }

    public String deleteVolunteer(Long id){
        Users user = usersRepo.findById(id).get();
        usersRepo.delete(user);
        return "Delete Volunteer.";
    }


    private void sendNotification(Users user, String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setSubject(subject);
        mail.setText(message);
        mail.setFrom("example@gmail.com"); // Replace with your email
        mailSender.send(mail);
    }

}
