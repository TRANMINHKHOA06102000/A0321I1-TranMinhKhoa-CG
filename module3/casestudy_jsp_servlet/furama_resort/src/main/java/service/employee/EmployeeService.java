package service.employee;

import bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<Employee> selectAlEmp() throws SQLException;

    boolean insertEmp(Employee employee) throws SQLException;

    boolean deleteEmp(int idEmp) throws SQLException;

    Employee selectEmp(int id) throws SQLException;

    boolean updateEmp(Employee employee) throws SQLException;

    List<Employee> findEmp(String nameEmp) throws SQLException;
}
