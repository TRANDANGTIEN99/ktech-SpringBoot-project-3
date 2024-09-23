package com.shoppingmall.service;

import com.shoppingmall.model.WebUser;
import com.shoppingmall.repository.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private WebUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public WebUser registerUser(WebUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("INACTIVE");
        return userRepository.save(user);
    }

    public WebUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
