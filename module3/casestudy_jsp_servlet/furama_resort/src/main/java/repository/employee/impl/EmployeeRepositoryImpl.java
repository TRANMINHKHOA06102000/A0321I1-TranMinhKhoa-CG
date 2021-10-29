package repository.employee.impl;

import bean.Customer;
import bean.Employee;
import repository.BaseRepository;
import repository.employee.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select employee.*" + "from employee " +
            "left join `position` on `position`.position_id=employee.position_id " +
            "left join education_degree on education_degree.education_degree_id=employee.education_degree_id " +
            "left join division on division.division_id=employee.division_id " +
            "left join `user` on `user`.username=employee.username;";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee(employee_name,employee_birthday," +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id," +
            "education_degree_id,division_id,username)" +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_EMPLOYEE_BY_NAME_SQL = "select employee.* from employee " +
            "left join `position` on `position`.position_id=employee.position_id " +
            "left join education_degree on education_degree.education_degree_id=employee.education_degree_id " +
            "left join division on division.division_id=employee.division_id " +
            "left join `user` on `user`.username=employee.username " +
            "where ((employee.employee_name like ?));";
    private static final String DELETE_EMPLOYEE_BY_ID_SQL = "delete from employee where employee_id =?;";
    private static final String SELECT_EMPLOYEE_BY_ID_SQL = "select employee.* from employee " +
            "left join `position` on `position`.position_id=employee.position_id " +
            "left join education_degree on education_degree.education_degree_id=employee.education_degree_id " +
            "left join division on division.division_id=employee.division_id " +
            "left join `user` on `user`.username=employee.username " +
            "where employee.employee_id=?;";
    private static final String UPDATE_EMPLOYEE_BY_ID_SQL = "update employee " +
            "set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?" +
            ",employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?," +
            "division_id=?,username=?" +
            "where employee.employee_id=?;";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> selectAlEmp() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int employee_id = resultSet.getInt("employee_id");
            String employee_name = resultSet.getString("employee_name");
            String employee_birthday = resultSet.getString("employee_birthday");
            String employee_id_card = resultSet.getString("employee_id_card");
            double employee_salary = resultSet.getDouble("employee_salary");
            String employee_phone = resultSet.getString("employee_phone");
            String employee_email = resultSet.getString("employee_email");
            String employee_address = resultSet.getString("employee_address");
            int position_id = resultSet.getInt("position_id");
            int education_degree_id = resultSet.getInt("education_degree_id");
            int division_id = resultSet.getInt("division_id");
            String username = resultSet.getString("username");
            employeeList.add(new Employee(employee_id, employee_name, employee_birthday, employee_id_card,
                    employee_salary, employee_phone, employee_email, employee_address, position_id,
                    education_degree_id, division_id, username));
        }
        return employeeList;
    }

    @Override
    public boolean insertEmp(Employee employee) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL);
        preparedStatement.setString(1, employee.getEmployee_name());
        preparedStatement.setString(2, employee.getEmployee_birthday());
        preparedStatement.setString(3, employee.getEmployee_id_card());
        preparedStatement.setDouble(4, employee.getEmployee_salary());
        preparedStatement.setString(5, employee.getEmployee_phone());
        preparedStatement.setString(6, employee.getEmployee_email());
        preparedStatement.setString(7, employee.getEmployee_address());
        preparedStatement.setInt(8, employee.getPosition_id());
        preparedStatement.setInt(9, employee.getEducation_degree_id());
        preparedStatement.setInt(10, employee.getDivision_id());
        preparedStatement.setString(11, employee.getUsername());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public boolean deleteEmp(int idEmp) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(DELETE_EMPLOYEE_BY_ID_SQL);
        preparedStatement.setInt(1, idEmp);
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public Employee selectEmp(int id) throws SQLException {
        Employee employee = null;
        PreparedStatement statement = this.baseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID_SQL);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            employee = new Employee();
            employee.setEmployee_id(rs.getInt("employee_id"));
            employee.setEmployee_name(rs.getString("employee_name"));
            employee.setEmployee_birthday(rs.getString("employee_birthday"));
            employee.setEmployee_id_card(rs.getString("employee_id_card"));
            employee.setEmployee_salary(rs.getDouble("employee_salary"));
            employee.setEmployee_phone(rs.getString("employee_phone"));
            employee.setEmployee_email(rs.getString("employee_email"));
            employee.setEmployee_address(rs.getString("employee_address"));
            employee.setPosition_id(rs.getInt("position_id"));
            employee.setEducation_degree_id(rs.getInt("education_degree_id"));
            employee.setDivision_id(rs.getInt("division_id"));
            employee.setUsername(rs.getString("username"));
        }
        return employee;
    }

    @Override
    public boolean updateEmp(Employee employee) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(UPDATE_EMPLOYEE_BY_ID_SQL);
        preparedStatement.setString(1, employee.getEmployee_name());
        preparedStatement.setString(2, employee.getEmployee_birthday());
        preparedStatement.setString(3, employee.getEmployee_id_card());
        preparedStatement.setDouble(4, employee.getEmployee_salary());
        preparedStatement.setString(5, employee.getEmployee_phone());
        preparedStatement.setString(6, employee.getEmployee_email());
        preparedStatement.setString(7, employee.getEmployee_address());
        preparedStatement.setInt(8, employee.getPosition_id());
        preparedStatement.setInt(9, employee.getEducation_degree_id());
        preparedStatement.setInt(10, employee.getDivision_id());
        preparedStatement.setString(11, employee.getUsername());
        preparedStatement.setInt(12, employee.getEmployee_id());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public List<Employee> findEmp(String nameEmp) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(FIND_EMPLOYEE_BY_NAME_SQL);
        preparedStatement.setString(1, "%" + nameEmp + "%");
        ResultSet rs = preparedStatement.executeQuery();
        Employee employee = null;
        while (rs.next()) {
            employee = new Employee();
            employee.setEmployee_id(rs.getInt("employee_id"));
            employee.setEmployee_name(rs.getString("employee_name"));
            employee.setEmployee_birthday(rs.getString("employee_birthday"));
            employee.setEmployee_id_card(rs.getString("employee_id_card"));
            employee.setEmployee_salary(rs.getDouble("employee_salary"));
            employee.setEmployee_phone(rs.getString("employee_phone"));
            employee.setEmployee_email(rs.getString("employee_email"));
            employee.setEmployee_address(rs.getString("employee_address"));
            employee.setPosition_id(rs.getInt("position_id"));
            employee.setEducation_degree_id(rs.getInt("education_degree_id"));
            employee.setDivision_id(rs.getInt("division_id"));
            employee.setUsername(rs.getString("username"));
            employeeList.add(employee);
        }
        return employeeList;
    }
}