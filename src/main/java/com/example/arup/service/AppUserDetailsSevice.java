package com.example.arup.service;

import com.example.arup.dao.AppUserRepository;
import com.example.arup.details.AppUserDetails;
import com.example.arup.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailsSevice implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findById(name).get();
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AppUserDetails(user);
    }
}
