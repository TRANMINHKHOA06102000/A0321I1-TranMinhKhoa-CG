package com.codegym.blog.repository;

import com.codegym.blog.model.User;
import com.codegym.blog.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Set<UserRole> findByUser(User users);
}
