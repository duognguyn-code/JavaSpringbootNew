package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserBymail(email);
        if (user == null){
            throw new UsernameNotFoundException("Not found");
        }
        return null;
    }
}
