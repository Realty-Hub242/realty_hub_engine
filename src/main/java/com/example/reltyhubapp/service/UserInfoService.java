package com.example.reltyhubapp.service;

import com.example.reltyhubapp.entity.User;
import com.example.reltyhubapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(username);

        return user.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("User : not found"));
    }

    public String addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new RuntimeException("userName, email, and password are required");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Add";
    }
}
