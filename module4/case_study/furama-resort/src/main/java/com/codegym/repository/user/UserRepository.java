package com.codegym.repository.user;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);

    @Query("select e.employeeEmail from Employee e where e.employeeEmail= :email")
    User findByEmployee_EmployeeEmail(String email);
//    Boolean existsByUserName(String userName);

}
