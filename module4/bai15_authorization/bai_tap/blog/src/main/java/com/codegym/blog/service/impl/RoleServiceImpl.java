package com.codegym.blog.service.impl;

import com.codegym.blog.model.Role;
import com.codegym.blog.repository.RoleRepository;
import com.codegym.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

}
