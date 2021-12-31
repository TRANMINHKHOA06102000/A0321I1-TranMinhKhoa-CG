package com.codegym.service.employee;

import com.codegym.model.Employee;
import com.codegym.model.Role;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.user.RoleRepo;
import com.codegym.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepo roleRepo;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(String author, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(author,pageable);
    }

    @Override
    public void save(Employee employee) {
        //set role id nó là quyền j
        Set<Role> roles= new HashSet<>();
        roles.add(roleRepo.findAllByRoleName("ROLE_USER"));
        //nhập từ bàn phím password lưu xuống database để login
        employee.getUser().setPassword(PasswordUtil.generatePassword(employee.getUser().getPassword()));
        employee.getUser().setRoles(roles);
        // lưu lại vào database
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
