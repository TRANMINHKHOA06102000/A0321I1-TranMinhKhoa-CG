package com.codegym.repository.user;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
    User findByEmployee_EmployeeEmail(String email);
//    Boolean existsByUserName(String userName);

}
