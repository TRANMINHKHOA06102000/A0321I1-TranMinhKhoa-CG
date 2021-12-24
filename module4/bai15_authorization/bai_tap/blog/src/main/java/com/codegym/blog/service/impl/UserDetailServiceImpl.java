package com.codegym.blog.service.impl;

import com.codegym.blog.model.User;
import com.codegym.blog.model.UserRole;
import com.codegym.blog.service.UserRoleService;
import com.codegym.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRoleService userRoleService;

    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User users = userService.findUserByEmail(email);

        if (users == null) {
            throw new UsernameNotFoundException("User " + email + " was not found");
        }
        Set<UserRole> userRoles = userRoleService.findByUser(users);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
            }
        }
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),
                grantedAuthorities);
    }
}
