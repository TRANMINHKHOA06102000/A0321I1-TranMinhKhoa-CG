package com.codegym.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncode = encoder.encode("12345");
        System.out.println(passwordEncode);
    }
}
