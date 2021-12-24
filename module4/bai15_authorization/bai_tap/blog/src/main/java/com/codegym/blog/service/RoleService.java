package com.codegym.blog.service;

import com.codegym.blog.model.Role;
import org.springframework.stereotype.Service;
@Service
public interface RoleService {
    Role findById(int id);
}
