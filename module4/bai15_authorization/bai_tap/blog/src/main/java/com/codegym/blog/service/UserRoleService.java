package com.codegym.blog.service;

import com.codegym.blog.model.User;
import com.codegym.blog.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserRoleService {
    Set<UserRole> findByUser(User users);
}
