package com.codegym.blog.service;

import com.codegym.blog.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserByEmail(String email);
}
