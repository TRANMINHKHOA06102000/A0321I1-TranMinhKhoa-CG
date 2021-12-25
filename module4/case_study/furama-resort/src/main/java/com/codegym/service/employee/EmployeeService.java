package com.codegym.service.employee;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findAllByEmployeeNameContaining(String author, Pageable pageable);
    void save(Employee employee);
    Employee findById(int id);
    void delete(int id);
}
