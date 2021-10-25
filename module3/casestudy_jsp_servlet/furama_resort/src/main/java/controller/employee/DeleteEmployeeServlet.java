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
import java.util.List;

@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = "/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        try {
            employeeService.deleteEmp(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.selectAlEmp();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listEmployee", employeeList);
        request.getRequestDispatcher("jsp/employee/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
