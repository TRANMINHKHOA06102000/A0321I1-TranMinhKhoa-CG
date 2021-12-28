package com.codegym.service.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPassword {
    public BCryptPassword() {
    }

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
