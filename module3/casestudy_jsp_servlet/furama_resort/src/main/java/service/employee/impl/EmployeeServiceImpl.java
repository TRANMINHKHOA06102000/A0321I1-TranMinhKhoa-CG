package service.employee.impl;

import bean.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.impl.EmployeeRepositoryImpl;
import service.employee.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> selectAlEmp() throws SQLException {
        return employeeRepository.selectAlEmp();
    }

    @Override
    public boolean insertEmp(Employee employee) throws SQLException {
        return employeeRepository.insertEmp(employee);
    }

    @Override
    public boolean deleteEmp(int idEmp) throws SQLException {
        return employeeRepository.deleteEmp(idEmp);
    }

    @Override
    public Employee selectEmp(int id) throws SQLException {
        return employeeRepository.selectEmp(id);
    }

    @Override
    public boolean updateEmp(Employee employee) throws SQLException {
        return employeeRepository.updateEmp(employee);
    }

    @Override
    public List<Employee> findEmp(String nameEmp) throws SQLException {
        return employeeRepository.findEmp(nameEmp);
    }
}
