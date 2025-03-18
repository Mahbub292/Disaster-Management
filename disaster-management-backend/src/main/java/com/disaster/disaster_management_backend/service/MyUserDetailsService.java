package com.disaster.disaster_management_backend.service;
import com.disaster.disaster_management_backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.disaster.disaster_management_backend.repo.UsersRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepo usersRepo;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findByUserName(username);
        if (user == null) {
            System.out.println("MyUserDetailsService:User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UsersPrincipal(user);
     }
}
