package com.codegym.repository.user;

import com.codegym.model.Role;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<Role,Integer> {
    List<Role> findByUsers(User user);
}
