package com.codegym.blog.service.impl;

import com.codegym.blog.model.User;
import com.codegym.blog.model.UserRole;
import com.codegym.blog.repository.UserRoleRepository;
import com.codegym.blog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Set<UserRole> findByUser(User users) {
        return userRoleRepository.findByUser(users);
    }
}
