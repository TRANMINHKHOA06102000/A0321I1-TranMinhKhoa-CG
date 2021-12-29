package com.codegym.repository.user;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);

//    @Query(value = "select employee.employee_email from employee where employee_email = :email", nativeQuery = true)
//    User findEmployeeEmail(@Param("email") String email);

    User findByEmployee_EmployeeEmail(String  email);
}
