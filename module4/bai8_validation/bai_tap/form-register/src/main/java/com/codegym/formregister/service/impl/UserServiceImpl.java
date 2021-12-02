package com.codegym.formregister.service.impl;


import com.codegym.formregister.model.User;
import com.codegym.formregister.repository.UserRepository;
import com.codegym.formregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
