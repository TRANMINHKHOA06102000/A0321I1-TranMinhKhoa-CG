package com.codegym.repository.user;

import com.codegym.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
