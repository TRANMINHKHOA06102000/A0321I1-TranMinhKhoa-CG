package controller.employee;

import bean.Employee;
import service.employee.EmployeeService;
import service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateEmployeeServlet", urlPatterns = "/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/employee/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employee_name = request.getParameter("employee_name").trim();
        String employee_birthday = request.getParameter("employee_birthday").trim();
        String employee_id_card = request.getParameter("employee_id_card").trim();
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone = request.getParameter("employee_phone").trim();
        String employee_email = request.getParameter("employee_email").trim();
        String employee_address = request.getParameter("employee_address").trim();
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username").trim();
        Employee employee = new Employee(employee_name, employee_birthday, employee_id_card, employee_salary,
                employee_phone, employee_email, employee_address, position_id, education_degree_id,
                division_id, username);
        try {
            if (employeeService.insertEmp(employee)) {
                request.setAttribute("listEmployee", employeeService.selectAlEmp());
                request.getRequestDispatcher("jsp/employee/list.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/employee/create.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
