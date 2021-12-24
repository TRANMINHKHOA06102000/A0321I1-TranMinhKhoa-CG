package com.codegym.blog.service.impl;

import com.codegym.blog.model.User;
import com.codegym.blog.repository.UserRepository;
import com.codegym.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
