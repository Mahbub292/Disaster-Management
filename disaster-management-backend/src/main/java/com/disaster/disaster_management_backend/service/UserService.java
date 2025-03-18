package com.disaster.disaster_management_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.disaster.disaster_management_backend.model.Donation;
import com.disaster.disaster_management_backend.model.Users;
import com.disaster.disaster_management_backend.repo.DonationRepo;
import com.disaster.disaster_management_backend.repo.UsersRepo;

@Service
public class UserService {

    private final DonationRepo donationRepo;

    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    public UsersRepo usersRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authManager;

    UserService(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }

    public Users userRegister(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return usersRepo.save(users);
    }
    public String verify(Users user) {
        String status = usersRepo.findByUserName(user.getUserName()).getStatus();
        if (status.equals("APPROVED")) {
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                String role = usersRepo.findByUserName(user.getUserName()).getRole();
                if(role.equals("ADMIN")){
                    return "a"+jwtService.generateToken(user.getUserName());
                }else{
                    return "v"+jwtService.generateToken(user.getUserName());
                }
            } else {
                return "fail";
            }
        }else{
            return "deny";
        }
        
    }
    public Long countVolunteers(){
        return usersRepo.countVolunteers();
    }
    public List<Users> getVolunteer(){
        return usersRepo.findAll();
    }
    public Donation addDonationInfo(Donation donation){
        return donationRepo.save(donation);
    }
    public Double getTotalDonationAmount(){
        return donationRepo.totalDonationAmount();
    }
}
